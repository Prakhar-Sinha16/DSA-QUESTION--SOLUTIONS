gfg link => https://practice.geeksforgeeks.org/problems/count-of-subarrays5922/1

//QUES: Given an array of N positive integers  Arr1, Arr2 ............ Arrn. The value of each contiguous subarray of given array is the maximum element present in that subarray. The task is to return the number of subarrays having value strictly greater than K.

// Example 1:

// Input:
// N = 3, K = 2
// Arr[] = {3, 2, 1}
// Output: 3
// Explanation: The subarrays having value
// strictly greater than K are: [3], [3, 2]
// and [3, 2, 1]. Thus there are 3 such
// subarrays.
// Example 2:

// Input:
// N = 4, K = 1
// Arr[] = {1, 2, 3, 4}
// Output: 9
// Explanation: There are 9 subarrays having
// value strictly greater than K.
// Your Task:
// Complete the function countSubarray() which takes an array arr, two integers n, k, as input parameters and returns an integer denoting the answer. You don't to print answer or take inputs.

// Expected Time Complexity: O(N)
// Expected Auxiliary Space: O(1)

// Constraints:
// 1 <= N <= 105
// 1 <= Arr[i] <= 105

//CODE:
class Solution {

    long countSubarray(int arr[], int n, int k) {

        // code here
        long ans=0;
        int recent=-1;
        for(int i=0;i<n;i++){
            if(arr[i]>k){
                ans++;
                int left=i-(recent+1);
                int right=n-1-i;
                ans+=left;
                ans+=right;
                ans+=(left*right);
                recent=i;
            }
        }
        return ans;
    }
}
