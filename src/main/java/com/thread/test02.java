package com.thread;

/**
 * @author wdy
 * @Description TODO
 * @createTime 2022年11月30日
 */
public class test02 {
    private final static Object o = new Object();

    public static class T1 extends Thread{
        @Override
        public void run() {
            synchronized (o){
                System.out.println(System.currentTimeMillis()+ "T1 start");
                try {
                    System.out.println(System.currentTimeMillis()+ "T1 wait for object");
                    o.wait();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println(System.currentTimeMillis()+ "T1 end");
            }
        }
    }

    public static class T2 extends Thread{
        @Override
        public void run() {
            synchronized (o){
                System.out.println(System.currentTimeMillis()+ "T2 start notify one thread");
                o.notify();
                System.out.println(System.currentTimeMillis()+ "T2 end");
                try {
                    Thread.sleep(2000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread t1 = new T1();
        Thread t2 = new T2();
        t1.start();
        t2.start();
    }
}
