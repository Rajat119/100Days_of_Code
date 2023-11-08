class Solution {
    public int rob(int nums[]) {
    int choose =nums[0];
    int discard = 0;
    
    for (int i = 1; i < nums.length; i++) {
        int Nchoice = discard + nums[i];
        int Ndiscard = Math.max(choose, discard);
        
        choose = Nchoice;
        discard = Ndiscard;
    }
    
    int res = Math.max(choose, discard);
    return res;
  
    }
}