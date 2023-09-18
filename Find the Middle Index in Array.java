class Solution {
    public int findMiddleIndex(int[] arr) {
        int totalSum=0;
        for(int i:arr){
            totalSum+=i;
        }
        int leftSum=0;
        for(int i=0;i<arr.length;i++){
            if(i!=0){
                leftSum+=arr[i-1];
            }
            if(totalSum-leftSum-arr[i]==leftSum){
                return i;
            }
        }
        return -1;
    }
}