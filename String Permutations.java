gfg link: https://practice.geeksforgeeks.org/problems/permutations-of-a-given-string-1587115620/1

QUES:
Given a string S. The task is to find all permutations (need not be different) of a given string.

Example 1:

Input:
S = AAA
Output: AAA AAA AAA AAA AAA AAA
Explanation: There are total 6 permutations, as given in the output.
Example 2:

Input:
S = ABSG
Output: ABGS ABSG AGBS AGSB ASBG ASGB
BAGS BASG BGAS BGSA BSAG BSGA GABS
GASB GBAS GBSA GSAB GSBA SABG SAGB
SBAG SBGA SGAB SGBA
Explanation: There are total 24 permutations, as given in the output.
Your Task:
This is a function problem. You only need to complete the function permutation that takes S as parameter and returns the list of permutations in lexicographically increasing order. The newline is automatically added by driver code.

Constraints:
1 ≤ size of string ≤ 5

Expected Time Complexity: O(N * N!), N = length of string.
Expected Auxiliary Space: O(1)

CODE:
class Solution
{
    public ArrayList<String> permutation(String S)
    {
        //Your code here
        ArrayList<String>a=new ArrayList<>();
        String perm="";
        if(S.length()==0)
        return a;
        permutation(a,S,perm);
        Collections.sort(a);
        return a;
    }
    public void permutation(ArrayList<String>a,String S,String perm)
    {
        if(S.length()==0)
        {
           a.add(perm);
            return;
        }
        for(int i=0;i<S.length();i++)
        {
            char ch=S.charAt(i);
            String str=S.substring(0,i)+S.substring(i+1);
            permutation(a,str,perm+ch);
        }
    }
	   
}
