package com.lc.play03;

import java.util.HashMap;

/**
 * @author wdy
 * @Description 两数之和
 * @createTime 2023年02月02日
 */
public class twoSum {
    /**
     * 给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那两个整数，并返回它们的数组下标。
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
     * 你可以按任意顺序返回答案。
     */
    public static void main(String[] args) {
        int[] num = new int[]{3,3,6};
        int[] ints = twoSum(num, 6);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }


    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            int m = target - nums[i];
            if (map.containsKey(m)){
                return new int[]{i, map.get(m)};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
