gfg link: https://practice.geeksforgeeks.org/problems/number-of-coins1824/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article

QUES:
Given a value V and array coins[] of size M, the task is to make the change for V cents, given that you have an infinite supply of each of 
coins{coins1, coins2, ..., coinsm} valued coins. Find the minimum number of coins to make the change. If not possible to make change then 
return -1.


Example 1:

Input: V = 30, M = 3, coins[] = {25, 10, 5}
Output: 2
Explanation: Use one 25 cent coin
and one 5 cent coin
Example 2:
Input: V = 11, M = 4,coins[] = {9, 6, 5, 1} 
Output: 2 
Explanation: Use one 6 cent coin
and one 5 cent coin

Your Task:  
You don't need to read input or print anything. Complete the function minCoins() which takes V, M and array coins as input parameters and 
returns the answer.

Expected Time Complexity: O(V*M)
Expected Auxiliary Space: O(V)

Constraints:
1 ≤ V*M ≤ 106
All array elements are distinct

CODE:
class Solution{

	public int minCoins(int coins[], int M, int n) { 
	    // Your code goes here
	    int dp[] = new int[n+1];
	    Arrays.fill(dp,-1);
	    dp[0] = 0;
	    minCoins(coins,n,dp);
	    return dp[n];
	}
	
	public int minCoins(int a[], int n, int dp[]){
        if(n < 0) return Integer.MAX_VALUE;
        if(dp[n] != -1)return dp[n];
        int min = Integer.MAX_VALUE;
        for(int i=0; i<a.length; i++){
            int result = minCoins(a, n - a[i], dp);
            if (result >= 0 && result < min)
                min = result + 1;
        }
        dp[n] = (min == Integer.MAX_VALUE) ? -1 : min;
        return dp[n];
    }
}
