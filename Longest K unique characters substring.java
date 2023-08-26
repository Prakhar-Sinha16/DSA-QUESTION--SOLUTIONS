gfg link: https://practice.geeksforgeeks.org/problems/longest-k-unique-characters-substring0853/1

QUES:
Given a string you need to print the size of the longest possible substring that has exactly K unique characters. If there is no possible substring then print -1.

Example 1:

Input:
S = "aabacbebebe", K = 3
Output: 
7
Explanation: 
"cbebebe" is the longest substring with 3 distinct characters.
Example 2:

Input: 
S = "aaaa", K = 2
Output: -1
Explanation: 
There's no substring with 2 distinct characters.
Your Task:
You don't need to read input or print anything. Your task is to complete the function longestKSubstr() which takes the string S and an integer K as input and returns the length of the longest substring with exactly K distinct characters. If there is no substring with exactly K distinct characters then return -1.

Expected Time Complexity: O(|S|).
Expected Auxiliary Space: O(|S|).

Constraints:
1 ≤ |S| ≤ 105
1 ≤ K ≤ 26
All characters are lowercase latin characters.

CODE:
class Solution {
    public int longestkSubstr(String s, int k) {
        // code here
        int st=0,n=s.length(),max=-1;
        Map<Character,Integer>map=new HashMap<>();
        for(int i=0;i<n;i++)
        {
            char ch=s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
            if(map.size()>k)
            {
                ch=s.charAt(st++);
                map.put(ch,map.get(ch)-1);
                if(map.get(ch)==0)map.remove(ch);
            }
            if(map.size()==k)max=i-st+1;
        }
        return max;
    }
}
