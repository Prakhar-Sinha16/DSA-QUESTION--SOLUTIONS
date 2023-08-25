gfg link: https://practice.geeksforgeeks.org/problems/palindrome-string0817/1

QUES:
Given a string S, check if it is palindrome or not.

Example 1:

Input: S = "abba"
Output: 1
Explanation: S is a palindrome
Example 2:

Input: S = "abc" 
Output: 0
Explanation: S is not a palindrome
Your Task:
You don't need to read input or print anything. Complete the function isPalindrome()which accepts string S and returns an integer value 1 or 0.

Expected Time Complexity: O(Length of S)
Expected Auxiliary Space: O(1)

Constraints:
1 <= Length of S<= 2*105

CODE:
  class Solution {
    int isPalindrome(String S) {
        // code here
        char[] s = S.toCharArray();
        return isPalindrome(s, 0, s.length - 1) ? 1 : 0;
    }
    
    static boolean isPalindrome(char[]s, int i, int j){
        while(i < j){
            if(s[i] != s[j]) return false;
            i++;j--;
        }
        return true;
    }
};
