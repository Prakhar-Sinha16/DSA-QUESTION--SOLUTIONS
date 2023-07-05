gfg link: https://practice.geeksforgeeks.org/problems/edit-distance3702/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article

QUES:
Given two strings s and t. Return the minimum number of operations required to convert s to t.
The possible operations are permitted:

Insert a character at any position of the string.
Remove any character from the string.
Replace any character from the string with any other character.
 

Example 1:

Input: 
s = "geek", t = "gesek"
Output: 1
Explanation: One operation is required 
inserting 's' between two 'e's of s.
Example 2:

Input : 
s = "gfg", t = "gfg"
Output: 
0
Explanation: Both strings are same.
 

Your Task:
You don't need to read or print anything. Your task is to complete the function editDistance() which takes strings s and t as input 
parameters and returns the minimum number of operation to convert the string s to string t. 


Expected Time Complexity: O(|s|*|t|)
Expected Space Complexity: O(|s|*|t|)


Constraints:
1 ≤ Length of both strings ≤ 100
Both the strings are in lowercase.

CODE:
class Solution {
    public int editDistance(String s1, String s2) {
        // Code here
        int n=s1.length();
        int m=s2.length();
        int dp[][] = new int [n+1][m+1];
        return editDistTabular(s1,s2,n,m,dp);
    }
    public int editDistTabular(String s1, String s2, int m, int n, int dp[][]){
        for(int i=0; i<=n; i++){
            dp[0][i] = i;
        }
        for(int i=0; i<=m; i++){
            dp[i][0] = i;
        }
        
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.min(Math.min(
                        dp[i-1][j],
                        dp[i][j-1]),
                        dp[i-1][j-1])+1;
                }
            }
        }
        return dp[m][n];
    }
}
