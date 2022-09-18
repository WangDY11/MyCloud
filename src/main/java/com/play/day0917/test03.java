package com.play.day0917;

/**
 * @author wdy
 * @Description TODO
 * @createTime 2022年09月17日
 */
public class test03 {


    public static void main(String[] args) {
        int a[] = new int[]{7,1,5,3,6,4};
        System.out.println(maxProfit(a));
    }



    public static int maxProfit(int[] prices) {
        int max = 0;
        // 贪心需要说明的是，贪心算法只能用于计算最大利润，计算的过程并不是实际的交易过程。
        // 因为交易次数不受限，如果可以把所有的上坡全部收集到，一定是利益最大化的
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]){
                max += (prices[i] - prices[i - 1]);
            }
        }
        return max;

    }
}
