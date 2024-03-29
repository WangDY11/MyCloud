package com.lc.play02;

import com.baomidou.mybatisplus.extension.api.R;

/**
 * @author wdy
 * @Description TODO
 * @createTime 2022年11月14日
 */
public class test11141 {

    /**
     * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
     * 输入:
     * [
     *  [1,3,1],
     *  [1,5,1],
     *  [4,2,1]
     * ]
     * 输出: 12
     * 解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物
     */

    public static void main(String[] args) {
        // dp[i][j] = Math.max( dp[i-1][j] + grid[i][j], dp[i][j-1] + grid[i][j]  )
        int [][]grid = new int[4][1];
        grid[0][0] = 1;
        grid[1][0] = 3;
        grid[2][0] = 1;
        grid[3][0] = 1;

//        grid[1][0] = 1;
//        grid[1][1] = 5;
//        grid[1][2] = 1;
//
//        grid[2][0] = 4;
//        grid[2][1] = 2;
//        grid[2][2] = 1;

        System.out.println(maxValue(grid));
    }

    public static int maxValue(int[][] grid) {
        int m = grid.length; // 行
        int n = grid[0].length; // 列
        for (int i = 1; i < n; i++) {
            grid[0][i] += grid[0][i-1];
        }
        for (int j = 1; j < m; j++){
            grid[j][0] += grid[j-1][0];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                grid[i][j] += Math.max(grid[i-1][j], grid[i][j-1]);
            }
        }
        return grid[m-1][n-1];
    }
}
