gfg link: https://practice.geeksforgeeks.org/problems/longest-increasing-subsequence-1587115620/1

Ques:
Given an array of integers, find the length of the longest (strictly) increasing subsequence from the given array.

Example 1:

Input:
N = 16
A = {0,8,4,12,2,10,6,14,1,9,5,13,3,11,7,15}
Output: 
6
Explanation:
There are more than one LIS in this array. One such Longest increasing subsequence is {0,2,6,9,13,15}.
Example 2:

Input:
N = 6
A[] = {5,8,3,7,9,1}
Output: 
3
Explanation:
There are more than one LIS in this array.  One such Longest increasing subsequence is {5,7,9}.
Your Task:
Complete the function longestSubsequence() which takes the input array and its size as input parameters and returns the length of the longest increasing subsequence.

Expected Time Complexity : O( N*log(N) )
Expected Auxiliary Space: O(N)

Constraints:
1 ≤ N ≤ 104
0 ≤ A[i] ≤ 106

CODE:
class Solution 
{
    static int binarySearch(int l, int h, int[] ans, int num)
    {
        while(l <= h)
        {
            int mid = (h-l)/2+l;
            if(ans[mid] == num)
            return mid;
            else if(ans[mid] > num)
            h = mid-1;
            else
            l = mid+1;
        }
        return l;
    }
   static int longestSubsequence(int n, int a[])
    {
        int ans[] = new int[n];
        Arrays.fill(ans, -1);
        int high = 0;
        ans[0] = a[0];
        for(int i=1; i<n; i++)
        {
            int index = binarySearch(0, high, ans, a[i]);
            if(index > high)
            high = index;
            ans[index] = a[i];
        }
        return high+1;
    }
} 
