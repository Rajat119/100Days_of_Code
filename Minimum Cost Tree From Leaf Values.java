class Solution {
    public int mctFromLeafValues(int[] arr) {
        int result=0;
        Stack<Integer> stack = new Stack<>();
        stack.push(Integer.MAX_VALUE);
        for(int a: arr){
            while(stack.peek()<=a){
                int mid=stack.pop();
                result+=mid*Math.min(stack.peek(),a);
            }
            stack.push(a);
        }
        while(stack.size()>2){
            result+=stack.pop()*stack.peek();
        }
        return result;
    }
}