gfg link: 

QUES:
Given two numbers n and x, find out the total number of ways n can be expressed as the sum of the Xth power of unique natural numbers. 
As the total number of ways can be very large, so return the number of ways modulo 109 + 7. 

Example 1:

Input: 
n = 10, x = 2
Output: 
1 
Explanation: 
10 = 12 + 32, Hence total 1 possibility. 
Example 2:

Input: 
n = 100, x = 2
Output: 
3
Explanation: 
100 = 102 
62 + 82 and 12 + 32 + 42 + 52 + 72 
Hence total 3 possibilities. 
Your Task:  
You don't need to read input or print anything. Complete the function numOfWays() which takes n and x as input parameters and returns 
the total number of ways n can be expressed as the sum of xth power of unique natural numbers.

Expected Time Complexity: O(n2logn)
Expected Auxiliary Space: O(n)

Constraints:
1 <= n <= 103
1 <= x <= 5
  
CODE:
class Solution
{   static long M = 1000000007l;
    public static int numOfWays(int targetSum, int pow){
        long[][] dp = new long[targetSum + 1][targetSum+1];
        for(int i = 0 ; i <= targetSum ; i++){
            dp[i][0] = 1;
        }
        for(int i = 1 ; i <= targetSum ; i++){
            for(int j = 1 ; j <= targetSum ; j++){
                long cur = power(i , pow);
                long count = 0;
                count += dp[i-1][j];
                if(j - cur >= 0){
                    count += dp[i-1][j-(int)cur];
                }
                dp[i][j] = (count % M);
            }
        }
        return (int)dp[targetSum][targetSum];
    }
    private static long power(long base  , int power){
        if(power == 0) return 1;
        if(power == 1) return base;
        if(power % 2 == 0){
            return power(base * base , power / 2);
        }else{
            return base * power(base * base , power / 2);
        }
    }
    
}
