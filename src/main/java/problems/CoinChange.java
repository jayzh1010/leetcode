package problems;

import java.util.Arrays;

/**
 * #322
 * 零钱兑换
 * https://leetcode-cn.com/problems/coin-change/
 */
public class CoinChange {
    private static int min = Integer.MAX_VALUE;
    public static int solute(int[] coins, int amount) {

        // return useDfs(coins, amount);
        return dp(coins, amount);
    }

    private static int useDfs(int[] coins, int amount) {
        Arrays.sort(coins);
        dfs(amount, coins, coins.length-1, 0);
        return min==Integer.MAX_VALUE ? -1 : min;
    }

    private static void dfs(int amount, int[] coins, int level, int count) {
        if (amount == 0) {
            min = min < count ? min : count;
            return;
        }
        if (level < 0 || amount<0 || count>min) {
            return;
        }
        for (int i=amount/coins[level]; i>=0 && count+i<min; i--) {

            dfs(amount-i*coins[level], coins, level-1, count+i);
        }
    }

    private static int dp(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        dp[0] = 0;
        for (int i=1; i<amount+1; i++) {
            dp[i] = amount+1;
            for (int coin: coins) {
                if (i>=coin) {
                    dp[i] = Math.min(dp[i-coin]+1, dp[i]);
                }
            }
        }
        return dp[amount]==amount+1 ? -1 : dp[amount];
    }
}
