package com.play02;

/**
 * @author wdy
 * @Description TODO
 * @createTime 2022年10月31日
 */
public class tests1031 {

    /**
     * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
     示例 1：

     输入: 2
     输出: 1
     解释: 2 = 1 + 1, 1 × 1 = 1
     示例2:

     输入: 10
     输出: 36
     解释: 10 = 3 + 3 + 4, 3 ×3 ×4 = 36

     * @param n
     * @return
     */
    public int cuttingRope(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 0; i < n; i++) {

            for (int j = 1; j < i; j++) {

                dp[j] = Math.max(dp[i - j] * j, j*(i - j));

            }
        }


        return dp[n];
    }

}