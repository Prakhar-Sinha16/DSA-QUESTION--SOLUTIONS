gfg link => https://practice.geeksforgeeks.org/problems/longest-bitonic-subsequence0824/1

//QUES: Given an array of positive integers. Find the maximum length of Bitonic subsequence. 
// A subsequence of array is called Bitonic if it is first strictly increasing, then strictly decreasing.
// Example 1:
// Input: nums = [1, 2, 5, 3, 2]
// Output: 5
// Explanation: The sequence {1, 2, 5} is
// increasing and the sequence {3, 2} is 
// decreasing so merging both we will get 
// length 5.
// Example 2:

// Input: nums = [1, 11, 2, 10, 4, 5, 2, 1]
// Output: 6
// Explanation: The bitonic sequence 
// {1, 2, 10, 4, 2, 1} has length 6.
 

// Your Task:
// You don't need to read or print anything. Your task is to complete the function LongestBitonicSequence() which takes the array nums[] as input parameter and returns the maximum length of bitonic subsequence.
 
// Expected Time Complexity: O(n2)
// Expected Space Complexity: O(n)

// Constraints:
// 1 ≤ length of array ≤ 1000
// 1 ≤ arr[i] ≤ 1000000

//CODE:
class Solution{
    public int LongestBitonicSequence(int[] nums){
        // Code here
        int n = nums.length ;    
        int[]dp1 = new int[n];
        int[]dp2 = new int[n];
        dp1[0]=1 ;
        dp2[n-1]=1 ;
        for(int i=1;i<n ;i++){
            int max= 0;
            for(int j=i-1;j>=0;j--){
                if(nums[j] <nums[i]){
                    max = Math.max(max ,dp1[j] );
                }
            }
            dp1[i]= max +1 ;
        }
         for(int i=n-2;i>=0 ;i--){
            int max= 0;
            for(int j=i+1;j<n;j++){
                if(nums[j] <nums[i]){
                    max = Math.max(max ,dp2[j] );
                }
            }
            dp2[i]= max +1 ;
        }
        int ans =0;
        for(int i=0;i<n ;i++){
            ans = Math.max(ans , dp1[i]+dp2[i]-1 );
        }
        return ans ;
    }
}
