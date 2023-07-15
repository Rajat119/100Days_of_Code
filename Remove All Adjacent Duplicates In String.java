
class Solution {
    public String removeDuplicates(String s) {

        StringBuilder sb = new StringBuilder();
        int slength = 0;
        char[] arr = s.toCharArray();
        for(char car: arr){
            if(slength >0 && car == sb.charAt(slength - 1)){
                sb.deleteCharAt(slength-- - 1);
            }else{
                sb.append(car);
                slength++;
            }
        }
        return sb.toString();
    }
}