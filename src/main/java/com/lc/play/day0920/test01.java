package com.lc.play.day0920;


public class test01 {

    public static void main(String[] args) {
        int n[] = new int[]{10,9,2,5,3,7,101,18};
        System.out.println(binarySearch(n, 101));
    }

    public static int binarySearch(int[] nums, int target){
        // 设置查找区间
        int left = 0,right = nums.length - 1;
        int mid = 0;

        while (left <= right){  // 注意是等于
            mid = left + (right - left)/2;  // 防止溢出
            if (nums[mid] == target){
                return mid;
            }else if (nums[mid] > target){
                right = mid - 1;
            }else if (nums[mid] < target){
                left = mid + 1;
            }
        }
        return -1;
    }

}
