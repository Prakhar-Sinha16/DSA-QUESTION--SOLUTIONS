gfg link: https://practice.geeksforgeeks.org/problems/32dc957908c2eb8beeeaeedf81f37df20d37c308/1

QUES:
Given a string, S.The string can contain small case English letters or '?'. You can replace '?' with any small English letter. Now if it is 
possible to make the string S a palindrome after replacing all '?' then find the palindromic string with a minimum ascii sum of the 
absolute difference of adjacent characters. Otherwise, return -1.

Example 1:

Input: S = a???c??c????
Output: 4
Explanation:
We can see that we can make the string
palindrome. Now to get minimum ascii sum we should
replace all the '?' between 'a' and 'c' with
'b' and all the '?' between two 'c' with 'c'.
So after replacing all the '?' the string: 
abbbccccbbba.
The sum of differences of adjacent characters is 4.   
Example 2:

Input: S = a???c??c???c
Output: -1
Explanation:
It is not possible to make the string palindrome.
Your Task:
You don't need to read input or print anything. Your task is to complete the function minimumSum() which takes a string S input 
parameter and returns an integer denoting the sum of differences of adjacent characters. If it is not possible to make string palindrome,
return -1. 

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

Constraints:
1 <= |S| <= 105

CODE:
class Solution {
    public static int minimumSum(String s) {
        // code here
        char d[] = s.toCharArray();
         int n=s.length();
        int i=0,j=n-1;
        int count=0;
        char prev='$';
        while(i<j)
        {
            if(d[i]!='?' && d[j]!='?' && d[i]!=d[j]) return -1;
            else if(d[i]=='?' && d[j]!='?') 
            {
                // s[i]=s[j];
                if(prev!='$') count+=Math.abs(d[j]-prev);
                prev=d[j];
            }
            else if(d[i]!='?' && d[j]=='?') 
            {
                // s[j]=s[i];
                if(prev!='$') count+=Math.abs(d[i]-prev);
                prev=d[i];    
            }
            else if(d[i]==d[j] && d[i]!='?')
            {
                if(prev!='$') count+=Math.abs(d[i]-prev);
                prev=d[i];  
            }
            i++;j--;
        }
        return 2*count;
    }
}
