gfg link: https://practice.geeksforgeeks.org/problems/optimal-strategy-for-a-game-1587115620/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article

QUES:
You are given an array A of size N. The array contains integers and is of even length. The elements of the array represent N coin of values
V1, V2, ....Vn. You play against an opponent in an alternating way.

In each turn, a player selects either the first or last coin from the row, removes it from the row permanently, and receives the value of 
the coin.

You need to determine the maximum possible amount of money you can win if you go first.
Note: Both the players are playing optimally.

Example 1:

Input:
N = 4
A[] = {5,3,7,10}
Output: 15
Explanation: The user collects maximum
value as 15(10 + 5)
Example 2:

Input:
N = 4
A[] = {8,15,3,7}
Output: 22
Explanation: The user collects maximum
value as 22(7 + 15)
Your Task:
Complete the function maximumAmount() which takes an array arr[] (represent values of N coins) and N as number of coins as a parameter and 
returns the maximum possible amount of money you can win if you go first.

Expected Time Complexity : O(N*N)
Expected Auxiliary Space: O(N*N)

Constraints:
2 <= N <= 103
1 <= Ai <= 106

CODE:
 class solve{
    //Function to find the maximum possible amount of money we can win.
    static long countMaximum(int a[], int n){
        // Your code here
        int i=0, j =a.length-1;
        int dp[][] = new int[n][n];
        
        for(int x[]: dp){
            Arrays.fill(x,-1);
        }
        optimalStratergy(a,i,j,dp);
        return dp[0][n-1];
    }
    
    static int optimalStratergy(int a[], int i, int j, int dp[][]){
        if(i+1 == j) return dp[i][j] =  Math.max(a[i], a[j]);
        
        if(dp[i][j] != -1) return dp[i][j];
        int left = a[i] + Math.min(optimalStratergy(a, i+2, j, dp), optimalStratergy(a, i+1, j-1,dp));
        
        int right = a[j] + Math.min(optimalStratergy(a,i+1, j-1,dp), optimalStratergy(a,i,j-2,dp));
        
        return dp[i][j] = Math.max(left, right);
    }
}                            
