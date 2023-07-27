class Solution {
    public char findTheDifference(String s, String t) {
        // 128 - ASCII symbols identical to Unicode
        int[] dict = new int[128];

        // iterate over the first string and increment each appearing character
        for (char ch : s.toCharArray()) {
            dict[ch]++;
        }

        // iterate over the second string and decrement each appearing character
        for (char ch : t.toCharArray()) {
            dict[ch]--;
        }

        // return the first negative value
        for (int i = 0; i < dict.length; i++) {
            if (dict[i] < 0) {
                return (char)(i);
            }
        }
        return ' ';
    }
}