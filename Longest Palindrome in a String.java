gfg link: https://practice.geeksforgeeks.org/problems/longest-palindrome-in-a-string3411/1

QUES:
Given a string S, find the longest palindromic substring in S. Substring of string S: S[ i . . . . j ] where 0 ≤ i ≤ j < len(S). 
Palindrome string: A string that reads the same backward. More formally, S is a palindrome if reverse(S) = S. In case of conflict, 
return the substring which occurs first ( with the least starting index).

Example 1:

Input:
S = "aaaabbaa"
Output: aabbaa
Explanation: The longest Palindromic
substring is "aabbaa".
Example 2:

Input: 
S = "abc"
Output: a
Explanation: "a", "b" and "c" are the 
longest palindromes with same length.
The result is the one with the least
starting index.
Your Task:
You don't need to read input or print anything. Your task is to complete the function longestPalin() which takes the string S as input 
and returns the longest palindromic substring of S.

Expected Time Complexity: O(|S|2).
Expected Auxiliary Space: O(1).

Constraints:
1 ≤ |S| ≤ 103
  
CODE:
class Solution{
    static String longestPalin(String S){
        // code here
        int length = 0;
        String ans = "";
        for(int i=0; i<S.length(); i++){
            int l = i, r = i;
            while(l>=0 && r<S.length() && S.charAt(l) == S.charAt(r)){
                if(r-l+1 > length){
                    ans = S.substring(l, r+1);
                    length = r-l+1;
                }
                l--;
                r++;
            }
            l = i; r = i+1;
            while(l>=0 && r<S.length() && S.charAt(l) == S.charAt(r)){
                if(r-l+1 > length){
                    ans = S.substring(l, r+1);
                    length = r-l+1;
                }
                l--;
                r++;
            }
        }
        return ans;
    }
}
