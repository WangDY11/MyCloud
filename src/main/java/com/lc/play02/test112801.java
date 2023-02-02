package com.lc.play02;

/**
 * @author wdy
 * @Description 剪绳子Ⅱ
 * @createTime 2022年11月28日
 */
public class test112801 {

    public static void main(String[] args) {
        System.out.println(cuttingRope(10));
        System.out.println(cuttingRope(2));
        System.out.println(cuttingRope(120));
    }

    public static int cuttingRope(int n) {
        // f(n) = math.max( j * (n - j), j * dp[n - j] )     1 <= j < n
        // j表示截取最后一段绳子长度，前面 n-j 长度要吗不截取，要吗还截取
        int dp[] = new int[n + 1];
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            int max = 0;
            for (int j = 1; j < i; j++) {
                int temp = Math.max( j * (i - j), j * dp[i - j] );
                max = Math.max(max, temp);
            }
            dp[i] = max;
        }
        return dp[n];
    }
}
