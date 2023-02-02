package com.thread;

/**
 * @author wdy
 * @Description 中断线程
 * @createTime 2022年11月30日
 */
public class test01 extends Thread{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (Thread.currentThread().isInterrupted()){
                System.out.println("中断");
                break;
            }
            try {
                Thread.sleep(2000); // 当线程在休眠时，中断他，这个异常就会产生,
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
            System.out.println(i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread.interrupted(); // 测试当前线程是否已中断。此方法将清除线程的中断状态。换言之，如果连续两次调用此方法，则第二次调用将返回false（除非当前线程在第一次调用清除其中断状态之后且在第二次呼叫检查它之前再次中断）。
        Thread t1 = new Thread(new test01());
        t1.start();
        Thread.sleep(3000);
        t1.interrupt(); // 中断线程
    }
}
