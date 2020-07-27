package problems;

/**
 * #152
 * 乘积最大子数组
 * https://leetcode-cn.com/problems/maximum-product-subarray/
 */
public class MaxProduct {
    public static int solute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int ans = nums[0];
        int[][] dp = new int[nums.length][2];
        dp[0][0] = nums[0];
        dp[0][1] = nums[0];
        for (int i=1; i<nums.length; i++) {
            if (nums[i] >= 0) {
                dp[i][0] = Math.min(dp[i-1][0]*nums[i], nums[i]);
                dp[i][1] = Math.max(dp[i-1][1]*nums[i], nums[i]);
            } else {
                dp[i][0] = Math.min(dp[i-1][1]*nums[i], nums[i]);
                dp[i][1] = Math.max(dp[i-1][0]*nums[i], nums[i]);
            }

            ans = Math.max(ans, dp[i][1]);

        }

        return ans;
    }
}
