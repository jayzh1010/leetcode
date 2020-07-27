package problems;

public class ClimbStairs {
    public static int solute(int n) {
        // return dfs(n);
        return dp(n);
    }

    private static int dfs(int n) {
        if (n < 3) {
            return n;
        }
        return dfs(n-1) + dfs(n-2);

    }

    private static int dp(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i=2; i<=n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
