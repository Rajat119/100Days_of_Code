class Solution {
    public boolean satisfiesConditions(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (i < grid.length-1 && grid[i + 1][c] != grid[i][c]) return false;
                if (c < grid[0].length-1 && grid[i][c + 1] == grid[i][c]) return false;
            }
        }
        return true;
    }
}