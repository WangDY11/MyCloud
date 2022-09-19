package com.play.day0919;

public class test01 {

    public static void main(String[] args) {
//        int n[] = new int[]{10,9,2,5,3,7,101,18};
        int n[] = new int[]{0,1,0,3,2,3};

        System.out.println(lengthOfLIS(n));
    }
    // fn = fn-1 + 1 || fn-1
    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;

        // 划分阶段 dp[i]表示已i结尾的最长子序列
        int dp[] = new int[n];
        // dp[i] = max(dp[j]) + 1,其中 0 ≤ j < i && num[j] < num[i]

        int max = 1;

        dp[0] = 1;

        for (int i = 1; i < n; i++) {
            // 初始化dp[i]
            dp[i] = 1;
            for (int j = 0; j < i; j++){
                // 已j结尾的最长子序列
                if (nums[i] > nums[j]){

                    dp[i] = Math.max(dp[j] + 1, dp[i]);

                }
            }

            max = Math.max(dp[i], max);

        }
        return max;
    }
}
