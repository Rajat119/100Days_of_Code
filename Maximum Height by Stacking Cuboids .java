class Solution {
    public int maxHeight(int[][] cuboids) {
         int n = cuboids.length;
        for(int i = 0; i< n;i++){
            Arrays.sort(cuboids[i]);
        }
        Arrays.sort(cuboids, (a, b) -> (b[2] - a[2] == 0 ? (b[1] - a[1] == 0 ? b[0] - a[0] : b[1] - a[1]) : b[2] - a[2]));
        int[] dp = new int[n+1];
       for(int i = 1 ; i< n+1 ;i++){
           dp[i] = cuboids[i-1][2];
       }
        // dp[0] = 0;
        int max = cuboids[0][2];
        for(int index = 2; index < n+1; index++){
            for(int track = 1; track < index ; track++){
                if(cuboids[index-1][0]<=cuboids[track-1][0] && cuboids[index-1][1]<=cuboids[track-1][1] && cuboids[index-1][2]<=cuboids[track-1][2]){
                    dp[index] = Math.max(dp[index], cuboids[index-1][2]+dp[track]);
                }
                max = Math.max(max, dp[index]);
                
                }
        }
        return max;
    }
}