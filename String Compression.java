class Solution {
    public int compress(char[] chars) {
         int i=0,ans=0;
        int n=chars.length;
        while(i<n){
            int j=i+1;
            while(j<n && chars[i]==chars[j]){
                j++;
            }
            chars[ans++]=chars[i];
            int count=j-i;
            if(count>1){
                String ch=Integer.toString(count);
                for(char cnt: ch.toCharArray()){
                    chars[ans++]=cnt;
                }
            }
            i=j;
        }
        return ans;
    }
}