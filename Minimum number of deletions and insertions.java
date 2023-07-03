gfg link: https://practice.geeksforgeeks.org/problems/minimum-number-of-deletions-and-insertions0209/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article

QUES:
Given two strings str1 and str2. The task is to remove or insert the minimum number of characters from/in str1 so as to transform it into 
str2. It could be possible that the same character needs to be removed/deleted from one point of str1 and inserted to some another point.

Example 1:

Input: str1 = "heap", str2 = "pea"
Output: 3
Explanation: 2 deletions and 1 insertion
p and h deleted from heap. Then, p is 
inserted at the beginning One thing to 
note, though p was required yet it was 
removed/deleted first from its position 
and then it is inserted to some other 
position. Thus, p contributes one to the 
deletion_count and one to the 
insertion_count.
Example 2:

Input : str1 = "geeksforgeeks"
str2 = "geeks"
Output: 8
Explanation: 8 deletions
 

Your Task:
You don't need to read or print anything. Your task is to complete the function minOperations() which takes both strings as input parameter
and returns the minimum number of operation required.

Expected Time Complexity: O(|str1|*|str2|)
Expected Space Complexity: O(|str1|*|str2|)

Constraints:
1 ≤ |str1|, |str2| ≤ 1000
All the characters are lower case English alphabets

CODE:
class Solution{
	public int minOperations(String a, String b) { 
	    // Your code goes here
	    int m=a.length();
	    int n=b.length();
	    int dp[][] = new int[m+1][n+1];
	    int ans = lcsTabular(a,b,m,n,dp);
	    int result = (m+n-(2*ans));
	    return result;
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
