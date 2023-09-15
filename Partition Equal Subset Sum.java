gfg link: https://practice.geeksforgeeks.org/problems/subset-sum-problem2014/1

QUES:
Given an array arr[] of size N, check if it can be partitioned into two parts such that the sum of elements in both parts is the same.

Example 1:

Input: N = 4
arr = {1, 5, 11, 5}
Output: YES
Explanation: 
The two parts are {1, 5, 5} and {11}.
Example 2:

Input: N = 3
arr = {1, 3, 5}
Output: NO
Explanation: This array can never be 
partitioned into two such parts.
Your Task:
You do not need to read input or print anything. Your task is to complete the function equalPartition() which takes the value N and the array as input parameters and returns 1 if the partition is possible. Otherwise, returns 0.

Expected Time Complexity: O(N*sum of elements)
Expected Auxiliary Space: O(N*sum of elements)

Constraints:
1 ≤ N ≤ 100
1 ≤ arr[i] ≤ 1000
N*sum of elements ≤ 5*106

CODE:
class Solution{
    static int equalPartition(int N, int arr[]){
        // code here
        int sum = 0;
        for(int i=0; i<N; i++) {
            sum += arr[i];
        }
        
        if(sum %2 == 1) return 0;
        
        sum /= 2;
        boolean[] dp = new boolean[sum+1];
        return (subset(arr, sum, N-1, dp) == true) ? 1:0;
    }
    
    static boolean subset(int[] arr, int sum , int N, boolean[] dp) {
        if(sum == 0) return true;
        if(N <= 0) return false;
        if(sum < 0) return false;
        
        if(dp[sum] == true) return false;
        
        return dp[sum] = subset(arr, sum-arr[N-1], N-1, dp) || subset(arr, sum, N-1, dp);
    }
}
