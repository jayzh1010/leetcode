package problems;

public class LongCommonSubsequence {
    public static int solute(String text1, String text2) {
        // return dfs(text1, text2, text1.length()-1, text2.length()-1);
        return dp(text1, text2);
    }

    private static int dfs(String x1, String x2, int i1, int i2) {
        if (i1 < 0 || i2 < 0) {
            return 0;
        }
        if (x1.charAt(i1) == x2.charAt(i2)) {
            return 1+ dfs(x1, x2, i1-1, i2-1);
        } else {
            int count1 = dfs(x1, x2, i1-1, i2);
            int count2 = dfs(x1, x2, i1, i2-1);
            return count1>count2 ? count1 : count2;

        }
    }

    private static int dp(String text1, String text2) {
        int m = text2.length();
        int n = text1.length();
        int[][] dp = new int[m+1][n+1];

        for (int i=1; i<=m; i++) {
            for (int j=1; j<=n; j++) {
                if (text1.charAt(j-1) == text2.charAt(i-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }
}
