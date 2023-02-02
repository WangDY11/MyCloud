package com.lc.play.day0922;

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

        return (fib(n - 1) + fib(n - 2)) % 1000000007;

    }
}
