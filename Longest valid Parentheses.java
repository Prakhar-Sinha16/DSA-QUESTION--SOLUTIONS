gfg link: https://practice.geeksforgeeks.org/batch/gts-1/track/gts-stacks-and-queues/problem/longest-valid-parentheses5657

QUES:
Given a string S consisting of opening and closing parenthesis '(' and ')'. Find length of the longest valid parenthesis substring.

A parenthesis string is valid if:

For every opening parenthesis, there is a closing parenthesis.
Opening parenthesis must be closed in the correct order.
Example 1:

Input: S = ((()
Output: 2
Explaination: The longest valid 
parenthesis substring is "()".
Example 2:

Input: S = )()())
Output: 4
Explaination: The longest valid 
parenthesis substring is "()()".
Your Task:
You do not need to read input or print anything. Your task is to complete the function maxLength() which takes string S as input parameter and returns the length of the maximum valid parenthesis substring.

Expected Time Complexity: O(|S|)
Expected Auxiliary Space: O(|S|)

Constraints:
1 ≤ |S| ≤ 105  

CODE:
class Solution{
    static int maxLength(String s){
        // code here
        Stack<Integer> stack = new Stack<>();
        stack.push(-1); // Initialize with -1 as the starting index for the valid substring
        int max_length = 0;

        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);

            if (cur == '(') {
                stack.push(i); // Push the index of the opening parenthesis
            } else {
                // Pop the last unmatched opening parenthesis
                if (!stack.isEmpty()) {
                    stack.pop();
                }

                // Check the length of the current valid parenthesis substring
                if (!stack.isEmpty()) {
                    max_length = Math.max(max_length, i - stack.peek());
                } else {
                    stack.push(i); // If the stack is empty, push the current index as the starting index for the next valid substring
                }
            }
        }

        return max_length;
    }
}
