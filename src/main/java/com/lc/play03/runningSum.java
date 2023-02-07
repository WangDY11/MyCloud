package com.lc.play03;

/**
 * @author wdy
 * @Description 1480. 一维数组的动态和
 * @createTime 2023年02月03日
 */
public class runningSum {


    public static void main(String[] args) {
        int[] a = new int[]{1,2,3,4};
        int[] ints = runningSum(a);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    /**
     * 给你一个数组 nums 。数组「动态和」的计算公式为：runningSum[i] = sum(nums[0]…nums[i]) 。
     * 请返回 nums 的动态和。
     */
    public static int[] runningSum(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        return nums;
    }
}
