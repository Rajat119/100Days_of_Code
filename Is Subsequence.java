class Solution {
    public boolean isSubsequence(String s, String t) {
        int i=0,j=0;
        int n=s.length();
        int m=t.length();
        if(n<1){
            return true;
        }
        while(i<m){
            if(s.charAt(j)==t.charAt(i)){
                j++;
            }
            i++;
        if(j==n){
            return true;
        }
        }
        return false;
    }
}