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
    public static double[] dicesProbability(int n) {
        double base = 0.16667;
        int len = 5*n + 1;
        double[] res = new double[len];

        for (int i = 0; i < len / 2; i++) {
            if (n == 1){
                res[i] = base;
            }else {
                String substring = String.valueOf(Math.pow(base, n) * (i + 1)).substring(0, 7);
                res[i] = Double.valueOf(substring);
            }
            res[len - 1 - i] = res[i];
        }
        return res;
    }
}
