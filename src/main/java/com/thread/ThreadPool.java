package com.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author wdy
 * @Description 线程池
 * @createTime 2022年12月13日
 */
public class ThreadPool {

    public static class MyTask implements Runnable{

        @Override
        public void run() {
            System.out.println(System.currentTimeMillis() + ":" + Thread.currentThread().getId());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        MyTask task = new MyTask();

        ExecutorService es = Executors.newFixedThreadPool(5);
        ExecutorService es2 = Executors.newCachedThreadPool();
        Executors.newSingleThreadScheduledExecutor();

        for (int i = 0; i < 10; i++) {
            es.submit(task);
        }
    }
}
