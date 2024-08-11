class Solution {
    public int maxProfit(int k, int[] prices) {
        return solveSO(k,prices);
    }

    public int solveSO(int k,int[] prices){
        int n=prices.length;
        int[] curr=new int[2*k+1];
        int[] next=new int[2*k+1];
        for(int i=n-1;i>=0;i--){
            for(int op=0;op<2*k;op++){
                int ans=0;
                if(op%2==0){
            int buyKaro = -prices[i] + next[op+1];
            int skip = 0 + next[op];
            ans = Math.max(buyKaro, skip);
        } else {
            int sellKaro = prices[i] + next[op+1];
            int skip = 0 + next[op];
            ans = Math.max(sellKaro, skip);
        }
        curr[op]=ans;
            }
            next=curr;
        }
        return next[0];
    }
}