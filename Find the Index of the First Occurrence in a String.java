class Solution {
    public int strStr(String haystack, String needle) {
        int res=-1;
        if(haystack.contains(needle)){
            int index=haystack.indexOf(needle);
            res=index;
        }
        return res;
    }
}