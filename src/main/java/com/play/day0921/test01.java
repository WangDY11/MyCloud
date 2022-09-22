package com.play.day0921;


public class test01 {

    public static void main(String[] args) {
        int n[] = new int[]{10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(n));
    }


    public static int lengthOfLIS(int[] nums) {
        int max = 0;

        int[] dp = new int[nums.length];

        dp[0] = 1;

        for (int i = 1; i < nums.length; i++) {

            dp[i] = 1;

            for (int j = 0; j < i; j++) {

                if (nums[i] > nums[j]){

                    dp[i] = Math.max(dp[j] + 1, dp[i]);

                }

            }

            max = Math.max(max, dp[i]);
        }

        return max;
    }
}
