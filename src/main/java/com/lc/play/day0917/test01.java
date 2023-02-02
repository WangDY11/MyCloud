package com.lc.play.day0917;

/**
 * @author wdy
 * @Description TODO
 * @createTime 2022年09月17日
 */
public class test01 {


    public static void main(String[] args) {
        int a[] = new int[]{7,1,5,3,6,4};
        System.out.println(maxProfit(a));
    }

    public static int maxProfit(int[] prices) {

        int min = Integer.MAX_VALUE;

        int max = 0;

        for (int i = 0; i < prices.length; i++) {

            min = Math.min(prices[i], min);

            max = Math.max(prices[i]- min, max);
        }

        return max;

    }
}
