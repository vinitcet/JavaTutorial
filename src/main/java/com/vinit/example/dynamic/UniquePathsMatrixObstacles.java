package com.vinit.example.dynamic;

public class UniquePathsMatrixObstacles {
    public static void main(String[] args) {
        int[][] og = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        int[][] og2 = {{1, 0}};
        System.out.println(uniquePathsWithObstacles(og2));
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int column = obstacleGrid[0].length;
        int[][] dp = new int[row + 2][column + 2];
        int setrow = 1;
        int setcolumn = 1;
        for (int i = 0; i < row; i++) {
            if (obstacleGrid[i][0] == 1) {
                setrow = 0;
                dp[i][0] = setrow;
            } else {
                dp[i][0] = setrow;
            }
        }
        for (int j = 0; j < column; j++) {
            if (obstacleGrid[0][j] == 1) {
                setcolumn = 0;
                dp[0][j] = setcolumn;
            } else {
                dp[0][j] = setcolumn;
            }
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                dp[i][j] = obstacleGrid[i][j] == 1 ? 0 : dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[row - 1][column - 1];
    }
}
