package com.lc.play.day0918;


/**
 * @author wdy
 * @Description TODO
 * @createTime 2022年09月18日
 */
public class test02 {

    public static void main(String[] args) {
        int[] n = new int[]{2,1,1,2};
        System.out.println(rob(n));

    }



    public static int rob(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1){
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        int a0 = nums[0];
        int a1 = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            int temp = a1;
            // 第三天
            a1 = Math.max(a1, a0 + nums[i]);

            a0 = temp;

        }

        return a1;
    }

}
