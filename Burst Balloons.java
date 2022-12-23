gfg link => https://practice.geeksforgeeks.org/problems/burst-balloons/1

//QUES: You are given N balloons, indexed from 0 to n - 1. Each balloon is painted with a number on it represented by an array arr. You are asked to brust all the balloons.
// If you brust the ith  balloon,, you will get arr[ i - 1 ] * arr[ i ] * arr[ i + 1] coins. If i - 1, or i + 1 goes out of bounds of the array, 
//consider it as if there is a balloon with a 1 painted on it.
// Return the maximum coins you can collect by brusting the balloons wisely.

// Example 1:

// Input:
// N = 4
// arr[ ] = {3, 1, 5, 8}
// Output: 167
// Explanation: 
// arr[ ] = {3, 1, 5, 8}  - - > {3, 5, 8} - - > {3, 8} - - > { 8} - -> { }
// coins = 3 *1 *5,      +      3*5*8     +   1*3*8   +  1*8*1   = 167
 
 

// Example 2:

// Input:
// N = 2
// arr[ ] = {1, 10}
// Output: 20
 

// Your Task:
// You don't need to read input or print anything. Your task is to complete the function maxCoins() which takes the array of integers arr and N as parameters and returns the maximum coin you can collect.

// Expected Time Complexity: O(N*N*N)
// Expected Auxiliary Space: O(N*N)

// Constraints:
// 1 ≤ N ≤ 300
// 0 ≤ arr [ i ]  ≤ 100

//CODE:
class Solution {
    public static int memoizationUtil(int start, int end, int[] nums, int[][] dp) {
		if (start > end) {
			return 0;
		}
		if (dp[start][end] != -1) {
			return dp[start][end];
		}
		int max = Integer.MIN_VALUE;
		for (int k = start; k <= end; k++) {
			int cost = nums[start - 1] * nums[k] * nums[end + 1] + memoizationUtil(start, k - 1, nums, dp)
					+ memoizationUtil(k + 1, end, nums, dp);
			max = Math.max(max, cost);
		}
		return dp[start][end] = max;
	}
    public static int memoization(int N, int[] arr){
        int[] nums = new int[arr.length + 2];
		nums[0] = 1;
		nums[arr.length + 1] = 1;
		for (int i = 0; i < arr.length; i++) {
			nums[i + 1] = arr[i];
		}
		int[][] dp = new int[N + 1][N + 1];
		for (int[] row : dp) {
			Arrays.fill(row, -1);
		}
		return memoizationUtil(1, N, nums, dp);
    }
	public static int tabulation(int N, int[] arr) {
		int[] nums = new int[N + 2];
		nums[0] = nums[N + 1] = 1;
		for (int i = 0; i < arr.length; i++) {
			nums[i + 1] = arr[i];
		}
		int[][] dp = new int[N + 2][N + 2];
		for (int i = N; i >= 1; i--) {
			for (int j = 1; j <= N; j++) {
				if (i > j) {
					continue;
				}
				int max = (int) -1e9;
				for (int k = i; k <= j; k++) {
					int cost = (nums[i - 1] * nums[k] * nums[j + 1]) + dp[i][k - 1] + dp[k + 1][j];
					max = Math.max(max, cost);
				}
				dp[i][j] = max;
			}
		}
		return dp[1][N];
	}
	
    public static int maxCoins(int N, int[] arr) {
        // return tabulation(N, arr);
        return memoization(N, arr);
    }
}
