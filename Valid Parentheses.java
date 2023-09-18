class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack=new Stack<Character>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='(' || ch=='{' || ch=='['){
                stack.push(ch);
            }else{
                if(!stack.isEmpty()){
                    char top=stack.peek();
                    if((ch==')' && top=='(') ||
                       (ch=='}' && top=='{') || 
                       (ch==']' && top=='[')){
                           stack.pop();
                    }else{
                        return false;
                    }
                }else{
                    return false;
                }
            }
        }
        if(stack.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
}