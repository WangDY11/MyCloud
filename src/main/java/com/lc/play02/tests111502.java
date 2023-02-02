package com.lc.play02;

/**
 * @author wdy
 * @Description n个骰子的点数
 * @createTime 2022年11月15日
 */
public class tests111502 {

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

    public static double[] dicesProbability(int n) {
        int len = 5 * n + 1;
        double[] res = new double[len];
        double all = Math.pow(6, n);
        // n个筛子范围[n, 6n] ,长度为 5n+1
        // dp[n][j] 表示n个筛子出现j的次数
        // dp[n][j] = sum( dp[n-1][j-i] ) i = 1...6

        int dp[][] = new int[n + 1][6*n+1];

        for (int i = 1; i <= 6; i++) {
            dp[1][i] = 1;
        }
        // i个筛子[2,n]
        for (int i = 2; i <= n; i++) {
            // j表示：i个筛子的和为j，  范围[i, 6*i]
            for (int j = i; j <= 6*i; j++) {
                // 状态转移 i-1 个筛子，和为j - k
                for (int k = 1; k <= 6 && k <= j; k++) { // 3 4   2 3
                    dp[i][j] += dp[i - 1][j - k];
                }
            }
        }
        for (int i = n; i <= 6*n; i++) {
            res[i - n] = (double) dp[n][i] / all;
        }
        return res;
    }
}
