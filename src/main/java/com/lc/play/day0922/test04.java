package com.lc.play.day0922;

/**
 * @author wdy
 * @Description TODO
 * @createTime 2022年09月22日
 */
public class test04 {

    public static void main(String[] args) {
        System.out.println(numWays(7));
    }
    // 0 1 2 3 4
    // 0 1 1 2 3
    public static int numWays(int n) {
        if (n == 0){
            return 1;
        }

        if (n == 1){
            return 1;
        }

        int p0 = 1;
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
