class Solution {
    public int maxProfit(int[] prices) {
        return solveSO(prices);
    }

    public static int solveSO(int[] prices){
        int n=prices.length;
        int[] curr=new int[n+1];
        int[] next=new int[n+1];
        for (int index = n - 1; index >= 0; index--) {
            for (int buy = 0; buy <= 1; buy++) {
                int ans = 0;
                if (buy == 1) {
                    int buyKaro = -prices[index] + next[0];
                    int skip = 0 + next[1];
                    ans = Math.max(buyKaro, skip);
                } else {
                    int sellKaro = prices[index] + next[1];
                    int skip = 0 + next[0];
                    ans = Math.max(sellKaro, skip);
                }
                curr[buy] = ans;
            }
            next=curr;
        }
        return next[1];
    }
}