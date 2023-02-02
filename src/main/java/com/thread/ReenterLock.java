package com.thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wdy
 * @Description TODO
 * @createTime 2022年12月08日
 */
public class ReenterLock implements Runnable{

    public static ReentrantLock lock = new ReentrantLock();
    public static int i = 0;

    @Override
    public void run() {
        for (int j = 0; j < 10000000; j++) {
            lock.lock();
            try {
                i++;
            }finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReenterLock t1 = new ReenterLock();
        Thread l1 = new Thread(t1);
        Thread l2 = new Thread(t1);
        l1.start();
        l2.start();
        l1.join();
        l2.join();
        System.out.println(i);
    }
}
