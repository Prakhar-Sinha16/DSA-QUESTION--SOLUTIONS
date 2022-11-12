gfg link => https://practice.geeksforgeeks.org/problems/maximum-sub-string-after-at-most-k-changes3220/1

//QUES: We have a string s of length n, which contains only UPPERCASE characters and we have a number k (always less than n). We can make at most k changes in our string. In one change, you can replace any s[i] (0<= i < n) with any uppercase character (from 'A' to 'Z'). After k changes, find the maximum possible length of the sub-string which have all same characters.

// Example 1:

// Input: s = "ABAB", k = 2
// Output: 4
// Explanation: Change 2 'B' into 'A'. 
// Now s = "AAAA"

// Example:

// Input: s = "ADBD", k = 1
// Output: 3
// Explanation: Change 'B' into 'D'.
// Now s = "ADDD"

// Your Task:
// You don't need to read or print anything. Your task is to complete the function characterReplacement() which takes s and k as input parameters and returns the maximum length of sub-string after doing k changes.
 

// Expected Time Complexity: O(n)
// Expected Space Complexity: O(26)
 

// Constraints:
// 1 <= n <= 105
// 0 <= k < n

//CODE:
class Solution{
    public int characterReplacement(String s, int k){
        // code here
        int a[]=new int[26];
        int prev=0;
        int ans=0;
        for(int i=0;i<s.length();i++){
            a[s.charAt(i)-'A']++;
            int cur = find(a,k);
            if(cur == -1){
                a[s.charAt(prev)-'A']--;
                prev++;
            }else{
               ans = Math.max(ans,cur); 
            }
        }
        return ans;
    }
    int find(int a[],int k){
        int same=0;
        int diffrent=0;
        for(int i : a){
            if(i>same){
                diffrent+=same;
                same=i;
            }else{
                diffrent+=i;
            }
        }
        return diffrent<=k? same+diffrent : -1;
    }
}
