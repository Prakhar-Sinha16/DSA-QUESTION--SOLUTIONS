gfg link: https://practice.geeksforgeeks.org/problems/1132bd8ee92072cd31441858402641d6800fa6b3/1

QUES:
You are given a number N. Find the total number of setbits in the numbers from 1 to N. 

Example 1:

Input: N = 3
Output: 4
Explaination: 
1 -> 01, 2 -> 10 and 3 -> 11. 
So total 4 setbits.
Example 2:

Input: N = 4
Output: 5
Explaination: 1 -> 01, 2 -> 10, 3 -> 11 
and 4 -> 100. So total 5 setbits.
Your Task:
You do not need to read input or print anything. Your task is to complete the function countBits() which takes N as input parameter and 
returns the total number of setbits upto N.

Expected Time Complexity: O(1)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ N ≤ 109
  
CODE:
class Solution {
    public static long countBits(long N) {
        // code here
        long count=0;
        for(long i=1;i<=N;i++)
        {
            count += Long.bitCount(i);
        }
        return count;
    }
}
