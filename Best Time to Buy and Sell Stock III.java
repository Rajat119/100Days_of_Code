class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        return solveSO(prices);
    }

    public int solveSO(int[] prices){
        int n=prices.length;
        int[][] curr=new int[n+1][3];
        int[][] next=new int[n+1][3];
        for (int idx = n - 1; idx >= 0; idx--) {
            for (int buy = 0; buy <= 1; buy++) {
                for (int lim = 1; lim <= 2; lim++) {
                    int ans = 0;
                    if (buy == 1) {
                        int buyKaro = -prices[idx] + next[0][lim];
                        int skip = 0 + next[1][lim];
                        ans = Math.max(buyKaro, skip);
                    } else {
                        int sellKaro = prices[idx] + next[1][lim-1];
                        int skip = 0 + next[0][lim];
                        ans = Math.max(sellKaro, skip);
                    }
                    curr[buy][lim] = ans;
                }
            }
            next=curr;
        }

        return next[1][2];

    }
}