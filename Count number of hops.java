gfg link: https://practice.geeksforgeeks.org/problems/count-number-of-hops-1587115620/1

QUES:
A frog jumps either 1, 2, or 3 steps to go to the top. In how many ways can it reach the top of Nth step. As the answer will be large find the answer modulo 1000000007.

Example 1:

Input:
N = 1
Output: 1
Example 2:

Input:
N = 4
Output: 7
Explanation:Below are the 7 ways to reach
4
1 step + 1 step + 1 step + 1 step
1 step + 2 step + 1 step
2 step + 1 step + 1 step
1 step + 1 step + 2 step
2 step + 2 step
3 step + 1 step
1 step + 3 step
Your Task:
Your task is to complete the function countWays() which takes 1 argument(N) and returns the answer%(10^9 + 7).

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).

Constraints:
1 ≤ N ≤ 105

CODE:
class Solution{
    //Function to count the number of ways in which frog can reach the top.
    public static int mod = 1000000007;
    public static long fun(int n, long [] dp){
        if(n ==0) return 1;
        if(n<0) return 0;
        
        if(dp[n] != -1) return dp[n];
        long first = fun(n-1, dp);
        long second = fun(n-2, dp);
        long third = fun(n-3, dp);
        
        return dp[n] = (first + second + third)%mod;
    }
    //Function to count the number of ways in which frog can reach the top.
    static long countWays(int n)
    {
        long [] dp = new long[n+1];
        for(int i=0; i<dp.length; i++) dp[i] = -1;
        return fun(n, dp);
    }
    
}
