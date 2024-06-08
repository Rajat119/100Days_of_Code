class Solution {
    public int minSideJumps(int[] obstacles) {
        int[] curr = new int[4];
        int[] next = new int[4];
        int n=obstacles.length-1;
        next[0] = 0;
        next[1] = 0;
        next[2] = 0;
        next[3] = 0;

        for (int currP = n - 1; currP >= 0; currP--) {
            for (int currL = 1; currL <= 3; currL++) {
                if (obstacles[currP + 1] != currL) {
                    curr[currL] = next[currL];
                } else {
                    int ans = Integer.MAX_VALUE;
                    for (int i = 1; i <= 3; i++) {
                        if (currL != i && obstacles[currP] != i) {
                            ans = Math.min(ans, 1 + next[i]);
                        }
                    }
                    curr[currL] = ans;
                }
            }
        next=curr;
        }
    return (Math.min(next[2],Math.min(1+next[1], 1+next[3])));
    }
}