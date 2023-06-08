gfg link: https://practice.geeksforgeeks.org/problems/find-kth-permutation-0932/1

QUES:
Given two integers N (1<=N<=9) and K. Find the kth permutation sequence of first N natural numbers. Return the answer in string format.

Example 1:

Input: N = 4, K = 3
Output: 1324
Explanation: 
Permutations of first 4 natural numbers:
1234,1243,1324,1342,1423,1432.....
So the 3rd permutation is 1324. 
Example 2:

Input: N = 3, K = 5
Output: 312
Explanation: 
Permutations of first 3 natural numbers:
123,132,213,231,312,321.
So the 5th permutation is 312. 
Your Task:
You don't need to read input or print anything. Your task is to complete the function kthPermutation() which takes two integers N and K 
as input parameters and returns a string denoting the kth permutation.

Expected Time Complexity: O(N2)
Expected Auxiliary Space: O(N)

Constraints:
1 <= N <= 9
1 <= K <= N!
  
CODE:
class Solution {
    public static void fact(int n,int a[])
    {
        a[0]=1;
        for(int i=1;i<=n;i++)
        a[i]=a[i-1]*i;
    }
    public static String kthPermutation(int n,int k) {
        int fact[]=new int[n+1];
        ArrayList<Integer> adj=new ArrayList<>();
        for(int i=1;i<=n;i++)
        adj.add(i);
        fact(n,fact);
        String s1="";
        k-=1;
        while(n!=0)
        {
            s1+=adj.get(k/fact[n-1]);
            adj.remove(k/fact[n-1]);
            k=k%fact[n-1];
            n--;
        }
        return s1;
        // code here
    }
}
