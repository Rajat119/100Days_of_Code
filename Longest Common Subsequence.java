class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        return solveSO(text1,text2);
    }

    public int solveSO(String a,String b){
        int[] curr=new int[b.length()+1];
        int[] next=new int[b.length()+1];
        for(int i=a.length()-1;i>=0;i--){
            for(int j=b.length()-1;j>=0;j--){
                if(a.charAt(i)==b.charAt(j)){
            curr[j]=1+next[j+1];
        }
        else{
            curr[j]=Math.max(next[j],curr[j+1]);
        }
            }
            next=curr.clone();
        }
        
        return next[0];
    }
}