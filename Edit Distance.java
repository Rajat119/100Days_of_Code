class Solution {
    public int minDistance(String word1, String word2) {
        return solveSO(word1,word2);
    }

    public int solveSO(String s1,String s2){
        if(s1.length()==0) return s2.length();
        if(s2.length()==0) return s1.length();
        int[] curr=new int[s2.length()+1];
        int[] next=new int[s2.length()+1];
        for(int j=0;j<s2.length();j++) next[j]=s2.length()-j;

        for(int i=s1.length()-1;i>=0;i--){
            curr[s2.length()]=s1.length()-i;
            for(int j=s2.length()-1;j>=0;j--){
                int ans=0;
                if(s1.charAt(i)==s2.charAt(j)) ans=next[j+1];
        else{
            int insert=1+curr[j+1];
            int delete=1+next[j];
            int replace=1+next[j+1];

            ans=Math.min(insert,Math.min(delete,replace));
        }
        curr[j]=ans;
            }
            next=curr.clone();
        }
        return next[0];
    }
}