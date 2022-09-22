package com.play.day0922;

/**
 * @author wdy
 * @Description TODO
 * @createTime 2022年09月22日
 */
public class test02 {

    public static void main(String[] args) {
        System.out.println(fib(5));
    }
    // 0 1 2 3 4
    // 0 1 1 2 3
    public static int fib(int n) {

        if (n < 2){
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
            dp[i] %= 1000000007;
        }

        return dp[n];

    }
}
