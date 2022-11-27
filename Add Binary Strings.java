gfg link => https://practice.geeksforgeeks.org/problems/add-binary-strings3805/1

//QUES: Given two binary strings A and B consisting of only 0s and 1s. Find the resultant string after adding the two Binary Strings.
// Note: The input strings may contain leading zeros but the output string should not have any leading zeros.

// Example 1:

// Input:
// A = "1101", B = "111"
// Output: 10100
// Explanation:
//  1101
// + 111
// 10100
// Example 2:

// Input: 
// A = "10", B = "01"
// Output: 11
// Explanation: 
//   10
// + 01
//   11

// Your Task:
// You don't need to read input or print anything. Your task is to complete the function addBinary() which takes 2 binary string A and B and returns a binary string denoting the addition of both the strings.

// Expected Time Complexity: O(max(|A|, |B|)).
// Expected Auxiliary Space: O(max(|A|, |B|)) (for output string).

// Constraints:
// 1 ≤ |A|, |B| ≤ 106

//CODE 1:
        // This code will run when you have contrains withing Integer limit
        int a = Integer.parseInt(A,2); //we have written here 2 because it is in binary otherwise bydefault it has base 10
        int b = Integer.parseInt(B,2);
        int c = a+b;
        return Integer.toBinaryString(c);

//CODE 2:
        //This will run for all the constraints
class Solution {
    String addBinary(String A, String B) {
        int i=A.length()-1;
        int j=B.length()-1;
        int carry=0;
        StringBuilder sb = new StringBuilder();
        while(i>=0 || j>=0){
            int a= i>=0?A.charAt(i)-'0':0;
            int b= j>=0?B.charAt(j)-'0':0;
            int total=a+b+carry;
            if(total==0){
                carry=0;
                sb.append('0');
            }
            else if(total==1){
                carry=0;
                sb.append('1');
            }
            else if(total==2){
                carry=1;
                sb.append('0');
            }
            else if(total==3){
                carry=1;
                sb.append('1');
            }
            i--;
            j--;
        }
        if(carry==1) sb.append('1');
        while(sb.charAt(sb.length()-1)=='0')sb.setLength(sb.length()-1);
        return sb.reverse().toString();
    }
}
