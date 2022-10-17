LeetCode Link => https://leetcode.com/problems/check-if-the-sentence-is-pangram/

class Solution {
    static int size = 26;
    public boolean checkIfPangram(String s) {
        boolean present[]= new boolean[size];
        for (int i = 0; i < s.length(); i++) {
            if (isValid(s.charAt(i))) {
                int letter = s.charAt(i) - 'a';
                present[letter] = true;
            }
        }
        for (int i = 0; i < size; i++) {
 
            if (!present[i])
                return false;
        }
        return true;
    }
    
    static boolean isValid(char c){
        if(!Character.isLetter(c))return false;
        
        return true;
    }
}
