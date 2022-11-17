package com.play02;

import java.math.BigDecimal;

/**
 * @author wdy
 * @Description n个骰子的点数
 * @createTime 2022年11月15日
 */
public class tests111501 {

    public static void main(String[] args) {

        double[] l1 = dicesProbability(1);
        for (double v : l1) {
            System.out.print(v + "\t");
        }
        System.out.println();
        double[] l2 = dicesProbability(2);
        for (double v : l2) {
            System.out.print(v + "\t");
        }
    }
    // n = 1, 6
    // n = 2, 12    [2,12]  11
    // n = 3, 18    [3,18]  16
    //              [n,6*n] 5n+1
    // 1 2 3 4 5 6  1/6 1/6 1/6 1/6 1/6 1/6
    // 1 2 3 4 5 6  1/6*1/6 [1/6*1/6]*2 1/6*1/6*1/6+1/6*1/6*1/6
    // 1 2 3 4 5 6

    /**
     *
     * 逆向 f(n, x) = sum( i= 1-6 )  f(n - 1, x - i) * 1/6
     *
     * 正向 f(n - 1, x) = sum( i = 1-6 ) f(n, x + i)
     *
     *  n = 4 , x =5
     *  f(3 , 5) = f(4, 6 ) + f(4, 7) + f(4, 8) + f(4, 9) + f(4, 10) + f(4, 11)
     */
    public static double[] dicesProbability(int n) {
        double base = 0.16667;
        int len = 5*n + 1;
        double[] res = new double[len];








        return res;
    }
}
