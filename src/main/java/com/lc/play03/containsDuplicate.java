package com.lc.play03;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wdy
 * @Description 217. 存在重复元素
 * @createTime 2023年02月10日
 */
public class containsDuplicate {

    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[]{1, 2, 3, 1}));
        System.out.println(containsDuplicate(new int[]{1,2,3,1}));
        System.out.println(containsDuplicate(new int[]{1,1,1,3,3,4,3,2,4,2}));
    }

    /**
     * 给你一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，返回 true ；如果数组中每个元素互不相同，返回 false 。
     */
    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (Integer i : nums) {
            if (!set.add(i)){
                return true;
            }
        }
        return false;
    }
}
