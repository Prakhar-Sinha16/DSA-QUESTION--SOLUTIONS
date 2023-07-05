gfg link: https://practice.geeksforgeeks.org/problems/jump-game/1

QUES:
Given an positive integer N and a list of N integers A[]. Each element in the array denotes the maximum length of jump you can cover. 
Find out if you can make it to the last index if you start at the first index of the list.


Example 1:

Input:
N = 6
A[] = {1, 2, 0, 3, 0, 0} 
Output:
1
Explanation:
Jump 1 step from first index to
second index. Then jump 2 steps to reach 
4th index, and now jump 2 steps to reach
the end.
Example 2:

Input:
N = 3
A[] =  {1, 0, 2}
Output:
0
Explanation:
You can't reach the end of the array.

Your Task:
You don't need to read input or print anything. Your task is to complete the function canReach() which takes a Integer N and a list A of 
size N as input and returns 1 if the end of the array is reachable, else return 0.


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)


Constraints:
1 <= N <= 105
0 <= A[i] <= 105

CODE:
class Solution {
    static int canReach(int[] a, int n) {
        // code here
        int dp[] = new int[a.length];
        Arrays.fill(dp, -1);
        
        return minJumps(a,0,dp);
        
        //return dp[0];
    }
    
    static int minJumps(int a[], int i, int dp[]) {
        if (i >= a.length - 1)
            return 1;

        if (dp[i] != -1)
            return dp[i];

        if (a[i] == 0)
            return 0;

        for (int j = 1; j <= a[i]; j++) {
            if (minJumps(a, i + j, dp) == 1)
                return dp[i] = 1;
        }
        return dp[i] = 0;
    }
