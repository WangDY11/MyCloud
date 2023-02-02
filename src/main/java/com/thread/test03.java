package com.thread;

/**
 * @author wdy
 * @Description TODO
 * @createTime 2022年11月30日
 */
public class test03 extends Thread{

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new test03();
        t1.start();
        t1.join();

    }
}
