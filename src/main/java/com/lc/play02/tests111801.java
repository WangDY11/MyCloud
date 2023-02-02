package com.lc.play02;

/**
 * @author wdy
 * @Description 丑数
 * @createTime 2022年11月18日
 */
public class tests111801 {
    public static void main(String[] args) {
        System.out.println(nthUglyNumber(10));
    }

    // 2 3 5
    // 1
    // 2
    // 3
    // 4
    // 5
    // 6  = 2^1*3^1
    // 8  = 2^3
    // 9  = 3^2
    // 10 = 2^1 * 5^1
    // 12 = 2^2 * 3^1
    // 15 = 3^1 * 5^1
    //
    public static int nthUglyNumber(int n) {
        int dp[] = new int[n+1];
        dp[1] = 1;
        int a = 1, b = 1, c = 1;
        for (int i = 2; i <= n; i++) {
            int a1 = dp[a] * 2;
            int b1 = dp[b] * 3;
            int c1 = dp[c] * 5;
            int min = Math.min(Math.min(a1, b1), c1);
            dp[i] = min;
            if (min == a1) a++;
            if (min == b1) b++;
            if (min == c1) c++;
        }
        return dp[n];
    }
}
