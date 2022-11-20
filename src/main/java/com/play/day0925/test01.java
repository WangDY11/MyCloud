package com.play.day0925;


public class test01 {

    public static void main(String[] args) {
        System.out.println(movingCount(2, 3, 1));

    }

    // 不能移动到方格外

    // 不能进入行坐标和列坐标的数位之和大于k的格子
    public static int movingCount(int m, int n, int k) {

        // 初始化
        boolean[][] dp = new boolean[m][n];

        dp[0][0] = true;

        int count = 1;

        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                if ((i == 0 && j == 0) || get(i) + get(j) > k) {
                    continue;
                }

                // vis[i][j]=vis[i−1][j] or vis[i][j−1]

                if (i - 1 >= 0){
                    dp[i][j] |= dp[i - 1][j];
                }

                if (j - 1 >= 0){
                    dp[i][j] |= dp[i][j - 1];
                }

                count += dp[i][j] == true ? 1 : 0;

            }

        }

        return count;
    }

    private static int get(int x) {

        int res = 0;

        while ( x != 0){

            res += x % 10;

            x /= 10;

        }

        return res;

    }
}
