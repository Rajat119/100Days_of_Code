class Solution {
    public int maximumCount(int[] nums) {
        int pcount=0, ncount=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                pcount++;
            }
            if(nums[i]<0){
                ncount++;
            }
        }
        return (Math.max(pcount,ncount));
    }
}