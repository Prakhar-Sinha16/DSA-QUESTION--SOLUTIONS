gfg link: https://practice.geeksforgeeks.org/problems/longest-palindromic-subsequence-1612327878/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article

QUES:
Given a String, find the longest palindromic subsequence.

Example 1:

Input:
S = "bbabcbcab"
Output: 7
Explanation: Subsequence "babcbab" is the
longest subsequence which is also a palindrome.
Example 2:

Input: 
S = "abcd"
Output: 1
Explanation: "a", "b", "c" and "d" are
palindromic and all have a length 1.

Your Task:
You don't need to read input or print anything. Your task is to complete the function longestPalinSubseq() which takes the string S as 
input and returns an integer denoting the length of the longest palindromic subsequence of S.

Expected Time Complexity: O(|S|*|S|).
Expected Auxiliary Space: O(|S|*|S|).

Constraints:
1 ≤ |S| ≤ 1000

CODE:
class Solution{
    public int longestPalinSubseq(String a){
        //code here
        StringBuilder reversedStr = new StringBuilder();
        for (int i = a.length() - 1; i >= 0; i--) {
            reversedStr.append(a.charAt(i));
        }
        String b = reversedStr.toString();
        int m = a.length();
        int n = b.length();
        
        int dp[][] = new int[m+1][n+1];
        int ans = lcsTabular(a,b,m,n,dp);
        return ans;
    }
    
    public int lcsTabular(String a, String b, int m, int n, int dp[][]){
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(a.charAt(i-1) == b.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }
}
