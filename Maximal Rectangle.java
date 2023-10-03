class Solution {
    public int maximalRectangle(char[][] matrix) {
        int maxArea = 0;
        int[] heights = new int[matrix[0].length];
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == '1') heights[j]++;
                else heights[j] = 0;
            }

            int area = largestRectangleArea(heights);
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
    }

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;

        int[] ls = new int[n];  // next smallest index on the left
        ls[0] = -1;
        Stack<Integer> st = new Stack<>();
        st.push(0);

        for(int i = 1; i < n; i++) {
            while(st.size() > 0 && heights[i] <= heights[st.peek()]) st.pop();

            if(st.size() == 0) ls[i] = -1;
            else ls[i] = st.peek();
            st.push(i);
        }

        int[] rs = new int[n];  // next smallest index on the right
        rs[n-1] = n;
        st = new Stack<>();
        st.push(n-1);

        for(int i = n-2; i >= 0; i--) {
            while(st.size() > 0 && heights[i] <= heights[st.peek()]) st.pop();

            if(st.size() == 0) rs[i] = n;
            else rs[i] = st.peek();
            st.push(i);
        }

        int maxArea = 0;
        for(int i = 0; i < n; i++) {
            int width = rs[i] - ls[i] - 1;
            int area = heights[i] * width;
            maxArea = Math.max(area, maxArea);
        } 

        return maxArea;
    }
}