package com.lc.play.day0923;

import org.checkerframework.checker.units.qual.A;

/**
 * @author wdy
 * @Description TODO
 * @createTime 2022年09月23日
 */
public class test01 {

    public static void main(String[] args) {
        int[] n = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(n));
    }

    
    public static int maxSubArray(int[] nums) {

        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {

            nums[i] = Math.max(0, nums[i - 1]) + nums[i];

            max = Math.max(max, nums[i]);
        }

        return max;

    }


}
