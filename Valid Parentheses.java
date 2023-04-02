LeetCode link: https://leetcode.com/problems/valid-parentheses/submissions/926637497/

QUES:
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.
 

Example 1:

Input: s = "()"
Output: true
Example 2:

Input: s = "()[]{}"
Output: true
Example 3:

Input: s = "(]"
Output: false
 

Constraints:

1 <= s.length <= 104
s consists of parentheses only '()[]{}'
  
CODE:
class Solution {
    public boolean isValid(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for(int i=0;i<s.length();i++){
            char cur = s.charAt(i);
            if(cur == '(' || cur == '{' || cur == '['){
                stack.push(cur);
                continue;
            }
            if(stack.isEmpty()) return false;
            char top = 'a';
            switch(cur){
                case '}':
                    top = stack.pop();
                    if(top != '{')return false;
                    break;
                case ')':
                    top = stack.pop();
                    if(top != '(') return false;
                    break;
                case ']':
                    top = stack.pop();
                    if(top != '[') return false;
                    break;
            }
        }
        return stack.isEmpty();
    }
}
