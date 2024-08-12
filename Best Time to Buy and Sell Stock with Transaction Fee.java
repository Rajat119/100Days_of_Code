class Solution {
    public int maxProfit(int[] prices, int fee) {
        return solve(prices,fee);
    }

    public int solve(int[] prices, int fee){
        int n=prices.length;
        int[] curr=new int[2];
        int[] next=new int[2];
        for(int i=n-1;i>=0;i--){
            for(int buy=0;buy<=1;buy++){
                int ans=0;
                if(buy==1){
                    int buyKaro=-prices[i]+next[0];
                    int skip=0+next[1];
                    ans=Math.max(buyKaro,skip);
                }
                else{
                    int sellKaro=prices[i]+next[1]-fee;
                    int skip=0+next[0];
                    ans=Math.max(sellKaro,skip);
                }
                curr[buy]=ans;
            }
            next=curr;
        }
        return next[1];
    }
}