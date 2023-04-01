gfg link: https://practice.geeksforgeeks.org/problems/non-repeating-character-1587115620/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article

QUES:
Given a string S consisting of lowercase Latin Letters. Return the first non-repeating character in S. If there is no non-repeating character, return '$'.

Example 1:

Input:
S = hello
Output: h
Explanation: In the given string, the
first character which is non-repeating
is h, as it appears first and there is
no other 'h' in the string.
Example 2:

Input:
S = zxvczbtxyzvy
Output: c
Explanation: In the given string, 'c' is
the character which is non-repeating. 
Your Task:
You only need to complete the function nonrepeatingCharacter() that takes string S as a parameter and returns the character. If there is no non-repeating character then return '$' .

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(Number of distinct characters).
Note: N = |S|

Constraints:
1 <= N <= 103
  
CODE:
class Solution
{
    //Function to find the first non-repeating character in a string.
    static char nonrepeatingCharacter(String s)
    {
        //Your code here
        char result=s.charAt(0);
        for(int i=0;i<s.length();i++){
            if(s.indexOf(s.charAt(i),s.indexOf(s.charAt(i))+1)!=-1){
                result = '$';
            }
            if(s.indexOf(s.charAt(i),s.indexOf(s.charAt(i))+1)==-1){
                result = s.charAt(i);
                break;
            }
        }
        return result;
    }
}
