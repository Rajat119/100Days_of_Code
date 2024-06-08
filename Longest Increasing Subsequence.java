class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        
        int [] dp=new int[n];
        
        int lengthOfLIS=0;
        
        for(int current:nums){
            
            int i=0,j=lengthOfLIS;
            
            while(i!=j){
                int mid=(i+j)/2;
                
                if(dp[mid]<current) i=mid+1;
                
                else j=mid;
            }
            
            dp[i]=current;
            
            if(i==lengthOfLIS) lengthOfLIS++;
        }
        return lengthOfLIS;
        
    }
}
