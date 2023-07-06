gfg link: https://practice.geeksforgeeks.org/problems/maximum-sum-increasing-subsequence4749/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article

QUES:
Given an array of n positive integers. Find the sum of the maximum sum subsequence of the given array such that the integers in the 
subsequence are sorted in strictly increasing order i.e. a strictly increasing subsequence. 

Example 1:

Input: N = 5, arr[] = {1, 101, 2, 3, 100} 
Output: 106
Explanation:The maximum sum of a
increasing sequence is obtained from
{1, 2, 3, 100}
Example 2:

Input: N = 3, arr[] = {1, 2, 3}
Output: 6
Explanation:The maximum sum of a
increasing sequence is obtained from
{1, 2, 3}

Your Task:  
You don't need to read input or print anything. Complete the function maxSumIS() which takes N and array arr as input parameters and 
returns the maximum value.


Expected Time Complexity: O(N2)
Expected Auxiliary Space: O(N)


Constraints:
1 ≤ N ≤ 103
1 ≤ arr[i] ≤ 105

CODE:
class Solution{
	public int maxSumIS(int a[], int n)  {  
	    //code here.
	    int dp[] = new int [n+1];
	    
	    dp[0] = a[0];
	    for(int i=1; i<n; i++){
	        dp[i] = a[i];
	        for(int j=0; j<i; j++){
	            if(a[i] > a[j]){
	                dp[i] = Math.max(dp[i], dp[j]+a[i]);
	            }
	        }
	    }
	    
	    int max=0;
        for(int e : dp){
            max = Math.max(max, e);
        }
        return max;
	}  
}
