class Solution {
    public boolean canMakeSquare(char[][] grid) {
        int blackCount = 0;
        int whiteCount = 0;

        // Count the number of black and white cells
        for (int i = 0; i <= 1; i++) {
            for (int j = 0; j <= 1; j++) {
                if (grid[i][j] == 'B') {
                    blackCount++;
                } else {
                    whiteCount++;
                }
                if (grid[i+1][j] == 'B') {
                    blackCount++;
                } else {
                    whiteCount++;
                }
                if (grid[i][j+1] == 'B') {
                    blackCount++;
                } else {
                    whiteCount++;
                }
                if (grid[i+1][j+1] == 'B') {
                    blackCount++;
                } else {
                    whiteCount++;
                }
                
                // If there are already 4 cells of the same color, return true
        if (blackCount >= 4 || whiteCount >= 4) {
            return true;
        }

        // If there are 3 cells of the same color, return true if there is at least one cell of the opposite color
        if (blackCount == 3 && whiteCount == 1) {
            return true;
        }
        if (whiteCount == 3 && blackCount == 1) {
            return true;
        }
                
                blackCount=0;
                whiteCount=0;
            }
        }

        // Otherwise, return false
        return false;
    }
}