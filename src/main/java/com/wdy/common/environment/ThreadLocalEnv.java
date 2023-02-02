package com.wdy.common.environment;

import com.alibaba.ttl.TransmittableThreadLocal;
/**
 * @desc 定义线程环境
 * @date 2019/5/24
 * @author wjy
 */
public class ThreadLocalEnv {

    private static final ThreadLocal<ThreadLocalVar> ENV = new TransmittableThreadLocal<>();

    public static ThreadLocalVar getENV() {
        return ENV.get();
    }

    public static void setENV(ThreadLocalVar threadLocalVar) {
        ENV.set(threadLocalVar);
    }

}
