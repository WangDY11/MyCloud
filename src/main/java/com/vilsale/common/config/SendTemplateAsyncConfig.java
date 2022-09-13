package com.vilsale.common.config;

import com.alibaba.ttl.threadpool.TtlExecutors;
import lombok.extern.log4j.Log4j2;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author wdy
 * @Description TODO
 * @createTime 2022年03月14日
 */
@Configuration
@Log4j2
public class SendTemplateAsyncConfig implements AsyncConfigurer {

    @Override
    @Bean("sendTemplateService")
    public Executor getAsyncExecutor() {
        // 最小活跃线程数
        int corePoolSize = 1;
        // 最大活跃线程数
        int maximumPoolSize = 1;
        // 线程池所使用的缓冲队列
        int queueCapacity = 2;
        // 指定线程池中线程空闲超过 5s 后将被回收
        int keepAliveTime = 10;

        ThreadPoolTaskExecutor threadPool = new ThreadPoolTaskExecutor();
        threadPool.setCorePoolSize(corePoolSize);
        threadPool.setMaxPoolSize(maximumPoolSize);
        threadPool.setQueueCapacity(queueCapacity);
        threadPool.setKeepAliveSeconds(keepAliveTime);
        // 等待任务在关机时完成--表明等待所有线程执行完
        threadPool.setWaitForTasksToCompleteOnShutdown(true);
        // 线程名称前缀
        threadPool.setThreadNamePrefix("sendTemplateService-");
        // 拒绝策略,如果添加到线程池失败，那么主线程会去执行该任务
        threadPool.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        threadPool.initialize();
        return TtlExecutors.getTtlExecutorService(threadPool.getThreadPoolExecutor());
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return new AsyncUncaughtExceptionHandler() {
            @Override
            public void handleUncaughtException(Throwable ex, Method method, Object... params) {
                StringWriter sw = new StringWriter();
                PrintWriter pw = new PrintWriter(sw);
                ex.printStackTrace();
                // log.error()发送邮件报警
                log.error(sw.toString());
            }
        };
    }
}
