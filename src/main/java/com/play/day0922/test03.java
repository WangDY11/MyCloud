package com.play.day0922;

/**
 * @author wdy
 * @Description TODO
 * @createTime 2022年09月22日
 */
public class test03 {

    public static void main(String[] args) {
        System.out.println(fib(5));
    }
    // 0 1 2 3 4
    // 0 1 1 2 3
    public static int fib(int n) {

        if (n < 2){
            return n;
        }

        int p0 = 0;
        int p1 = 1;
        int temp = 0;

        for (int i = 2; i <= n; i++) {

            temp = p1;

            p1 = (p0 + p1) % 1000000007; // p2

            p0 = temp;

        }

        return p1;


    }
}
