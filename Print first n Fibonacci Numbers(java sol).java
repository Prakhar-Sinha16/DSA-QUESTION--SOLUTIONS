gfg link: https://practice.geeksforgeeks.org/problems/print-first-n-fibonacci-numbers1002/1

QUES:
Given a number N, find the first N Fibonacci numbers. The first two number of the series are 1 and 1.

Example 1:

Input:
N = 5
Output: 1 1 2 3 5
Example 2:

Input:
N = 7
Output: 1 1 2 3 5 8 13
Your Task:
Your task is to complete printFibb() which takes single argument N and returns a list of first N Fibonacci numbers.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).
Note: This space is used to store and return the answer for printing purpose.

Constraints:
1<= N <=84

CODE:

class Solution{
    //Function to return list containing first n fibonacci numbers.
    public static long[] printFibb(int n) {
        //Your code here
        long a[] = new long[n];
        
        if(n == 0){
            a[0] = 0;
            return a;
        }
        if(n == 1){
            a[0] = 1;
            return a;
        }
        
        if(n >= 2){
            a[0] = 1;
            a[1] = 1;
        }
        for(int i=2; i<n; i++){
            a[i] = a[i-1] + a[i-2];
        }
        return a;
    }
}
