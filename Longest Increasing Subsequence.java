class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        ArrayList<Integer> temp = new ArrayList<>();
        int ans=1;
        temp.add(nums[0]);
        for(int i=1;i<n;i++){
            if( nums[i]>temp.get(temp.size()-1)){
                temp.add(nums[i]);
                ans++;
            }
            else{
                int index = Collections.binarySearch(temp,nums[i]);
                if(index<0){
                    index=-index-1;
                }
                temp.set(index,nums[i]);
            }
        }
        return ans;
    }
}
