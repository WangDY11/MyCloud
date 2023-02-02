package com.lc.play.day0917;

/**
 * @author wdy
 * @Description TODO
 * @createTime 2022年09月17日
 */
public class test02 {


    public static void main(String[] args) {
        int a[] = new int[]{7,1,5,3,6,4};
        System.out.println(maxProfit(a));
    }
    // 确定状态和状态变量：
    // 某天两种情况，手里有股票，手里没有股票，所以可以构建二维数组
    // dayPrice[i][0]: i天手里有股票的利润
    // dayPrice[i][1]: i天手里没有股票的利润

    // 找状态转移方程：
    // f（n）
    public static int maxProfit(int[] prices) {
        // 第一天手里有股票

        int dayPrice[][] = new int[prices.length][2];
        // 第一天手里没股票
        dayPrice[0][0] = 0;
        dayPrice[0][1] = -prices[0];

        for (int i = 1; i < prices.length; i++) {

            dayPrice[i][0] = Math.max( dayPrice[i-1][0], dayPrice[i-1][1] + prices[i] );
            dayPrice[i][1] = Math.max( dayPrice[i-1][1], dayPrice[i-1][0] - prices[i] );
        }

        return dayPrice[prices.length - 1][0];

    }
}
