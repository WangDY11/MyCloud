package com.play02;

/**
 * @author wdy
 * @Description 丑数
 * @createTime 2022年11月18日
 */
public class tests111801 {
    // 2 3 5
    // 1, 2, 3, 4, 5
    //
    // 6  = 2^1*3^1
    // 8  = 2^3
    // 10 = 2^1 * 5^1
    // 12 = 2^2 * 3^1
    //
    public int nthUglyNumber(int n) {
        int dp[] = new int[1691];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        dp[4] = 4;
        dp[5] = 5;
        if (n <= 5){
            return dp[n];
        }
        for (int i = 6; i <= n; i++) {



        }
        return dp[n];
    }
}
