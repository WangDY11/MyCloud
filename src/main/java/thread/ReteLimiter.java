package thread;

import com.google.common.util.concurrent.RateLimiter;

/**
 * @author wdy
 * @Description 限流
 * @createTime 2022年12月13日
 */
public class ReteLimiter {


    static RateLimiter limiter = RateLimiter.create(2);


    public static class Task implements Runnable{
        @Override
        public void run() {
            System.out.println(System.currentTimeMillis());
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 50; i++) {
            limiter.acquire();
            new Thread(new Task()).start();
        }
    }



}
