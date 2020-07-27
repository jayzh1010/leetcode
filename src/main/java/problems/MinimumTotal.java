package problems;

import java.util.List;

/**
 * #120
 * 三角形最小路径和
 * https://leetcode-cn.com/problems/triangle/description/
 */
public class MinimumTotal {
    public static int solute(List<List<Integer>> triangle) {
        // return original(triangle);
        return extraSpaceN(triangle);
    }

    private static int original(List<List<Integer>> triangle) {
        int m = triangle.size();
        int n = triangle.get(m-1).size();
        int[][] dp = new int[m+1][n+1];

        for (int i=m-1; i>=0; i--) {
            for (int j=0; j<triangle.get(i).size(); j++) {
                dp[i][j] = Math.min(dp[i+1][j], dp[i+1][j+1]) + triangle.get(i).get(j);
            }
        }

        return dp[0][0];
    }

    private static int extraSpaceN(List<List<Integer>> triangle) {
        int m = triangle.size();
        int n = triangle.get(m-1).size();
        int[] dp = new int[n+1];

        for (int i=m-1; i>=0; i--) {
            for (int j=0; j<triangle.get(i).size(); j++) {
                dp[j] = Math.min(dp[j], dp[j+1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }
}
