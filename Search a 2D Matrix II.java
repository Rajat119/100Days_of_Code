class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row=matrix.length;
        int col=matrix[0].length;

        int rI=0;
        int cI=col-1;

        while(rI<row && cI>=0){
            int element=matrix[rI][cI];
            if(element==target)
            return true;
            if(element<target)
            rI++;
            if(element>target)
            cI--;
        }
        return false;
    }
}