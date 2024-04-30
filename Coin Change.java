class Solution {
    public int coinChange(int[] coins, int amount) {
     int[] dp = new int[amount + 1];
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    int subRes = dp[i - coins[j]];
                    if (subRes != Integer.MAX_VALUE && subRes + 1 < dp[i]) {
                        dp[i] = subRes + 1;
                    }
                }
            }
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}