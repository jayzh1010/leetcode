package problems;

/**
 * #53
 * 最大子序列和
 * https://leetcode-cn.com/problems/maximum-subarray/
 */
public class MaxSubArray {
    public static int solute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int ans = nums[0];
        for (int i=1; i< nums.length; i++) {
            dp[i] = Math.max(dp[i-1]+nums[i], nums[i]);
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
