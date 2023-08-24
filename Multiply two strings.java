gfg link: https://practice.geeksforgeeks.org/problems/multiply-two-strings/1

QUES:
Given two numbers as strings s1 and s2. Calculate their Product.

Note: The numbers can be negative and You are not allowed to use any built-in function or convert the strings to integers. There can be zeros in the begining of the numbers.

Example 1:

Input:
s1 = "0033"
s2 = "2"
Output:
66
Example 2:

Input:
s1 = "11"
s2 = "23"
Output:
253
Your Task: You don't need to read input or print anything. Your task is to complete the function multiplyStrings() which takes two strings s1 and s2 as input and returns their product as a string.

Expected Time Complexity: O(n1* n2)
Expected Auxiliary Space: O(n1 + n2); where n1 and n2 are sizes of strings s1 and s2 respectively.

Constraints:
1 ≤ length of s1 and s2 ≤ 103

CODE:
class Solution{
    public String multiplyStrings(String s1,String s2){
        //code here.
        boolean negative = false;
        if (s1.charAt(0) == '-') {
            negative = !negative;
            s1 = s1.substring(1);
        }
        if (s2.charAt(0) == '-') {
            negative = !negative;
            s2 = s2.substring(1);
        }
        
        int len1 = s1.length();
        int len2 = s2.length();
        int[] result = new int[len1 + len2];
        
        for (int i = len1 - 1; i >= 0; i--) {
            int digit1 = s1.charAt(i) - '0';
            int carry = 0;
            for (int j = len2 - 1; j >= 0; j--) {
                int digit2 = s2.charAt(j) - '0';
                int product = (digit1 * digit2) + carry + result[i + j + 1];
                carry = product / 10;
                result[i + j + 1] = product % 10;
            }
            result[i] += carry;
        }
        
        StringBuilder sb = new StringBuilder();
        for (int num : result) {
            sb.append(num);
        }
        
        // Remove leading zeros
        while (sb.length() > 0 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        
        if (negative && sb.length() > 0) {
            sb.insert(0, '-');
        }
        
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
