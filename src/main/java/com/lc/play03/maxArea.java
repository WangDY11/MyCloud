package com.lc.play03;

/**
 * @author wdy
 * @Description 11. 盛最多水的容器
 * @createTime 2023年02月10日
 */
public class maxArea {
    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));  // 49
        System.out.println(maxArea(new int[]{1,1})); // 1
    }

    /**
     * https://aliyun-lc-upload.oss-cn-hangzhou.aliyuncs.com/aliyun-lc-upload/uploads/2018/07/25/question_11.jpg
     * 给定一个长度为 n 的整数数组height。有n条垂线，第 i 条线的两个端点是(i, 0)和(i, height[i])。
     * 找出其中的两条线，使得它们与x轴共同构成的容器可以容纳最多的水。
     * 返回容器可以储存的最大水量。
     * 说明：你不能倾斜容器。
     */
    public static int maxArea(int[] height) {
        int len = height.length;
        int max = 0;
        // 循环每条边
        for (int i = 0; i < len; i++) {
            // 每条边开头的最大面积
            for (int j = i + 1; j < len; j++) {
                int x = Math.min(height[i], height[j]);
                int y = j - i;
                max = Math.max(x * y, max);
            }
        }
        return max;
    }
}
