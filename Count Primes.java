class Solution {
    public int countPrimes(int n) {
        int cnt=0;
        boolean ans[]=new boolean[n+1];
        
        for(int i=0;i<n;i++){
            ans[i]=true;
        }
        for(int i=2;i<n;i++){
            if(ans[i]){
            cnt++;

            for(int j=i*2;j<n;j=j+i){
                ans[j]=false;
            }
            }
        }
        return cnt;
    }
}