package com.lc.play02;

/**
 * @author wdy
 * @Description n个骰子的点数
 * @createTime 2022年11月15日
 */
public class tests111503 {

    public static void main(String[] args) {

        double[] l1 = dicesProbability(1);
        for (double v : l1) {
            System.out.print(v + "\t");
        }
        System.out.println();
        double[] l2 = dicesProbability(2);
        for (double v : l2) {
            System.out.print(v + "\t");
        }
    }

    public static double[] dicesProbability(int n) {
        //我们知道，每个阶段的状态都只和它前一阶段的状态有关，因此我们不需要用额外的一维来保存所有阶段。
        //
        //用一维数组来保存一个阶段的状态，然后对下一个阶段可能出现的点数 j 从大到小遍历，实现一个阶段到下一阶段的转换。
        //
        //优化空间的时候从高到低主要是因为如果从低到高的话，那边后面使用的就是本轮已经改变的值，不再是上一轮的值了。
        //
        //思考：从后向前的方法很妙
        //
        int len = 5 * n + 1;
        double[] res = new double[len];
        double all = Math.pow(6, n);

        // 总的状态数为6 * n，bp[0]不使用
        int dp[] = new int[6*n+1];

        // 阶段1的状态[1,6]
        for (int i = 1; i <= 6; i++) {
            dp[i] = 1;
        }
        // 阶段2的状态[2,12]
        // i个筛子[2,n]
        for (int i = 2; i <= n; i++) {
            // j表示：i个筛子的和为j，  范围[i, 6*i]
            for (int j=i*6; j>=i; j--) {
                dp[j] = 0;
                // 状态转移 i-1 个筛子，和为j - k
                for (int k = 1; k <= 6; k++) { // 3 4   2 3
                    // 从实际情况分析，n-1 个 骰子的最小值就是 n-1,不会比这个还小
                    if(j - k < i - 1) break;
                    dp[j] += dp[j - k];
                }
            }
        }
        for (int i = n; i <= 6*n; i++) {
            res[i - n] = (double) dp[i] / all;
        }
        return res;
    }
}
