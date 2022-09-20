package com.play.day0920;


public class test03 {

    public static void main(String[] args) {
        int n[] = new int[]{2,2,2,3,4,5};
        System.out.println(binarySearch(n, 2));
    }

    // 寻找左区间
    public static int binarySearch(int[] nums, int target){
        // 设置查找区间
        int left = 0,right = nums.length;
        int mid = 0;

        while (left < right){
            mid = left + (right - left) / 2;  // 防止溢出
            if (nums[mid] == target){
                right = mid;
            }else if (nums[mid] > target){
                right = mid;
            }else if (nums[mid] < target){
                left = mid + 1;
            }
        }
        if (left >= nums.length){
            return -1;
        }
        return nums[left] == target ? left : -1;
    }

}
