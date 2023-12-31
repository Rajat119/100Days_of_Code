class Solution {
    public int findPeakElement(int[] nums) {
     int s=0;
     int n=nums.length;
     int e=n-1;
     int mid=(s+e)/2;
     while(s<e){
         if(nums[mid]<nums[mid+1]){
             s=mid+1;
         }
         else{
             e=mid;
         }
         mid=(s+e)/2;
     } 
         return s;
    }
}