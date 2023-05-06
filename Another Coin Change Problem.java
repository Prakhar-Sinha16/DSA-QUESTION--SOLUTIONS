gfg link: https://practice.geeksforgeeks.org/problems/09b910559335521654aa2909f86f893447d8f5ba/1

QUES:
Given three integers n, k, target, and an array of coins of size n. Find if it is possible to make a change of target cents by using an infinite supply of each coin 
but the total number of coins used must be exactly equal to k.

Example 1:

Input:
n = 5, k = 3, target = 11
coins = {1, 10, 5, 8, 6}

Output: 
1

Explanation: 
2 coins of 5 and 1 coins of 1 can be used 
to make change of 11 i.e. 11 => 5+5+1.
Example 2:

Input:
n = 3, k = 5, target = 25
coins = {7, 2, 4}

Output:
1

Explanation:
3 coins 7, 2 coins of 2 can be used to
make change of 25 i.e. 25 => 7+7+7+2+2.
Your Task:
This is a function problem. You only need to complete the function makeChanges() that 3 integers n, k, target, and an array coins as parameters and return True or 
False.

Expected Time Complexity: O(n*k*target)
Expected Space Complexity: O(k*target)

Constraints:
1 <= n, k, coins[i] <= 100
1 <= target <= 1000
  
CODE:
class Solution {
    public static boolean makeChanges(int N, int K, int target, int[] coins) {
        // code here
        
        Boolean[][] dp= new Boolean[target+1][K+1];
        
        for(int i=0;i<target+1;i++) Arrays.fill(dp[i],null);

        dp[0][0]=true;
        
        return makeChangesReal(N,K,target,coins,dp);
        
    }
    
    public static boolean makeChangesReal(int N, int K, int target, int[] coins,Boolean[][] dp) {
        
        if(K==0 && target==0) return true;
        
        if(K<=0 || target <=0) return false;
        
        boolean ans=false;
        for(int i=0;i<N;i++){
            if(target>=coins[i] && (K-1) >=0){
                if(dp[target-coins[i]][K-1]!=null) ans= ans || dp[target-coins[i]][K-1];
                else ans = ans || makeChangesReal(N,K-1,target-coins[i],coins,dp); 
            }
            
        }
        dp[target][K]= ans;
        
        return ans;
    }
}
