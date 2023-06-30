gfg link: https://practice.geeksforgeeks.org/problems/is-binary-number-multiple-of-30654/1

QUES:
Given a number in its binary form find if the given binary number is a multiple of 3. It is recommended to finish the task using one 
traversal of input binary number.

Example 1:

Input: S = "0011"
Output: 1
Explanation: "0011" is 3, which is divisible by 3.
Example 2:

Input: S = "100"
Output: 0
Explanation: "100"'s decimal equivalent is 4, which is not divisible by 3.
Your Task:  
You don't need to read input or print anything. Your task is to complete the function isDivisible() which takes the string s as inputs and 
returns 1 if the given number is divisible by 3 otherwise 0.

Expected Time Complexity: O(|S|)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ |S| ≤ 105

CODE:
class Solution {
    int isDivisible(String s) {
        // code here
        int sum = 0;
        int x=1;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '1'){
                if(i%2 == 1){
                    sum += 1; 
                }else{
                    sum +=2;
                }
            }
        }
        
        return sum%3 == 0 ? 1:0;
    }
}
