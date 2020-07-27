package problems;

public class UniquePathsWithObstacles {
    public static int solute(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];

        dp[m-1][n-1] = obstacleGrid[m-1][n-1] == 1 ? 0 : 1;
        for (int i=m-1; i>=0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                // 有障碍直接置为0
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                    // 右下角
                } else if (j == (n - 1) && i == (m - 1)) {
                    dp[i][j] = obstacleGrid[m - 1][n - 1] == 1 ? 0 : 1;
                    // 右边界
                } else if (j == (n - 1) && i < (m - 1)) {
                    dp[i][j] = dp[i + 1][j];
                    // 下边界
                } else if (i == (m - 1) && j < (n - 1)) {
                    dp[i][j] = dp[i][j + 1];
                } else {
                    dp[i][j] = dp[i][j + 1] + dp[i + 1][j];
                }
            }
        }
        return dp[0][0];
    }
}
