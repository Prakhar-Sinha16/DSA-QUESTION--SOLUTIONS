gfg link: https://practice.geeksforgeeks.org/problems/least-prime-factor5216/1

QUES:
Given a number N, find the least prime factors for all numbers from 1 to N.  The least prime factor of an integer X is the smallest 
prime number that divides it.
Note :

1 needs to be printed for 1.
You need to return an array/vector/list of size N+1 and need to use 1-based indexing to store the answer for each number.
Example 1:

Input: N = 6
Output: [0, 1, 2, 3, 2, 5, 2] 
Explanation: least prime factor of 1 = 1,
least prime factor of 2 = 2,
least prime factor of 3 = 3,
least prime factor of 4 = 2,
least prime factor of 5 = 5,
least prime factor of 6 = 2.
So answer is[1, 2, 3, 2, 5, 2]. 
Example 2:

Input: N = 4
Output: [0, 1, 2, 3, 2]
Explanation: least prime factor of 1 = 1,
least prime factor of 2 = 2,
least prime factor of 3 = 3,
least prime factor of 4 = 2.
So answer is[1, 2, 3, 2]. 
Your Task:  
You don't need to read input or print anything. Complete the function leastPrimeFactor() which takes N as input parameter and returns a 
list of integers containing all the least prime factors of each number from 1 to N.

Expected Time Complexity: O(NlogN)
Expected Auxiliary Space: O(N)

Constraints:
2<= n <=105

CODE:
class Solution
{
    public int[] leastPrimeFactor(int n)
    {
        // code here
        int [] leastPrime = new int[n+1];
        leastPrime[0] = 0;
        leastPrime[1] = 1;
        for(int i=2; i<=n; i++){
            if(leastPrime[i] == 0){
                int ind=1;
                int j=i;
                while(j*ind <= n){
                    j = j*ind;
                    ind++;
                    if(leastPrime[j] == 0) leastPrime[j] = i;
                    j= i;
                }
            }
        }
        return leastPrime;
    }
}
