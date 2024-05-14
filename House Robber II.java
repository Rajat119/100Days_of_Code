class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(nums.length==1) return nums[0];
        int first[]=new int[nums.length];
        int second[]=new int[nums.length];
        for(int i=0;i<n;i++){
            if(i!=n-1) first[i]=nums[i];
            if(i!=0) second[i]=nums[i];
        }
        return Math.max(solve(first),solve(second));
    }

    public int solve(int nums[]) {
    int prev1 =nums[0];
    int prev2 = 0;
    
    for (int i = 1; i < nums.length; i++) {
        int pick = prev2 + nums[i];
        int notPick = prev1;
        
        int ans = Math.max(pick, notPick);
        
        prev2 = prev1;
        prev1 = ans;
    }
    
    return prev1;
    }
}