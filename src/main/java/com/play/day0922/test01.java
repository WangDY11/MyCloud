package com.play.day0922;

/**
 * @author wdy
 * @Description TODO
 * @createTime 2022年09月22日
 */
public class test01 {

    public static void main(String[] args) {
        System.out.println(fib(5));
    }

    public static int fib(int n) {

        if (n < 2){
            return n;
        }
        int s = 0;
        for (int i = 2; i <= n; i++) {
            s = fib(i - 1) + fib(i - 2);
        }

        return s % 1000000007;

    }
}
