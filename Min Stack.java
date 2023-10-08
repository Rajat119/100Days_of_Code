class MinStack {
    private int size, top;
    private int[] stack, minStack;
    public MinStack() {
        size = 1000;
        stack = new int[size];
        minStack = new int[size];
        top = -1;
    }
    
    public void push(int val) {
        if(top==size-1)
            return;
        else{
            stack[++top] = val;
            if(top==0)
                minStack[top] = val;
            else
                minStack[top] = Math.min(val, minStack[top-1]);
        }
    }
    
    public void pop() {
        if(top==-1)
            return;
        else
            top--;
    }
    
    public int top() {
        if(top==-1)
            return -1;
        return stack[top];
    }
    
    public int getMin() {
        if(top==-1)
            return -1;
        return minStack[top];
    }
}
