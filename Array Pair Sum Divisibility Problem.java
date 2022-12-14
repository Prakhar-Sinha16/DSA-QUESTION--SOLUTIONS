gfg link => https://practice.geeksforgeeks.org/problems/array-pair-sum-divisibility-problem3257/1

//QUES: Given an array of integers and a number k, write a function that returns true if given array can be divided into pairs such that sum of every pair is divisible by k.
 

// Example 1 :

// Input : arr = [9, 5, 7, 3], k = 6
// Output: True
// Explanation: {(9, 3), (5, 7)} is a 
// possible solution. 9 + 3 = 12 is divisible
// by 6 and 7 + 5 = 12 is also divisible by 6.

// Example 2:

// Input : arr = [2, 4, 1, 3], k = 4
// Output: False
// Explanation: There is no possible solution.
 

// Your Task:
// You don't need to read or print anything. Your task is to complete the function canPair() which takes array and k as input parameter and returns true if array can be divided into pairs such that sum of every pair is divisible by k otherwise returns false.
 

// Expected Time Complexity: O(n)
// Expected Space Complexity : O(n)
 

// Constraints:
// 1 <= length of array <= 10^5
// 1 <= elements of array <= 10^5
// 1 <= k <= 10^5

//CODE:
class Solution {
    public boolean canPair(int[] nums, int k) {
        // Code here
        if(nums==null)
           return false;
         int n=nums.length;
         if(n<2||(n&1)!=0)
           return false;
         
        int mem[] = new int[k];

        for(int x : nums)
            mem[x%k]++;

        if((mem[0]&1)!=0)
            return false;

        for(int i=1; i<=k/2; i++)
            if(mem[i]!=mem[k-i]) 
                return false;

        return true;
    }
}
