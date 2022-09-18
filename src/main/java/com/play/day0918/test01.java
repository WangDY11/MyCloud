package com.play.day0918;


/**
 * @author wdy
 * @Description TODO
 * @createTime 2022年09月18日
 */
public class test01 {

    public static void main(String[] args) {
        int[] n = new int[]{2,1,1,2};
        System.out.println(rob(n));

    }


    // 划分阶段
        // 当天的最高金额就是昨天有偷钱的最高金额，或者昨天没偷钱加今天偷的钱
    // 确定状态

    // 状态转移方程

    // 边界条件
    public static int rob(int[] nums) {
        if (nums.length == 1){
            return nums[0];
        }
        int max = 0;

        int dp[][] = new int[nums.length][2];

        // 第一天没偷钱
        dp[0][0] = 0;
        dp[0][1] = nums[0];

//        // 第二天没偷钱:昨天偷了钱 和 昨天没偷钱今天也没有偷钱
//        dp[1][0] = Math.max(dp[0][1], dp[0][0]);
//        // 第二天偷了钱： 昨天没偷钱+今天偷了钱
//        dp[1][1] = dp[0][0] + nums[1];

        for (int i = 1; i < nums.length; i++) {

            dp[i][0] = Math.max(dp[i-1][1], dp[i-1][0]);

            dp[i][1] = dp[i-1][0] + nums[i];

            max = Math.max(dp[i][0], dp[i][1]);
        }

        return max;
    }

}
