package com.lc.play.day0918;


/**
 * @author wdy
 * @Description TODO
 * @createTime 2022年09月18日
 */
public class test03 {

    public static void main(String[] args) {
        int[] n = new int[]{2,1,1,2};
        System.out.println(rob(n));

    }



    public static int rob(int[] nums) {


        //偷窃第 k 间房屋，那么就不能偷窃第 k-1 间房屋，偷窃总金额为前 k−2 间房屋的最高总金额与第 k 间房屋的金额之和。

        //不偷窃第 k 间房屋，偷窃总金额为前 k−1 间房屋的最高总金额。

        // 用 dp[i] 表示前 i 间房屋能偷窃到的最高总金额，那么就有如下的状态转移方程：

        // dp[i] = max(dp[i−2]+nums[i], dp[i−1])

        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1){
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        return dp[nums.length - 1];
    }

}
