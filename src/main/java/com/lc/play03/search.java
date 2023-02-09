package com.lc.play03;

/**
 * @author wdy
 * @Description 704. 二分查找
 * @createTime 2023年02月09日
 */
public class search {

    public static void main(String[] args) {
        System.out.println(search(new int[]{-1, 0, 3, 5, 9, 12}, 9));
        System.out.println(search(new int[]{-1, 0, 3, 5, 9, 12}, 2));
        System.out.println(search(new int[]{5}, 5));
    }

    /**
     * 给定一个n个元素有序的（升序）整型数组nums 和一个目标值target ，写一个函数搜索nums中的 target，如果目标值存在返回下标，否则返回 -1。
     */
    public static int search(int[] nums, int target) {
        int length = nums.length;
        int mid = length / 2;
        int left = 0;
        int right = length - 1;

        while (left <= right){
            if (nums[mid] == target){
                return mid;
            }else if (nums[mid] < target){
                left = mid + 1;
            }else if (nums[mid] > target){
                right = mid - 1;
            }
            // 两个是数学上的恒等式，在计算机里可能两个int相加会溢出，先减除后加确实可以用于更大的数组
//            mid = (left + right)/2;
//            mid = (right - left) / 2 + left;
            mid = (right + left)>>1;
        }
        return -1;
    }
}
