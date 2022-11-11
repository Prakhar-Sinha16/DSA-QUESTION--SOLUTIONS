gfg link => https://practice.geeksforgeeks.org/problems/primes-sum5827/1

//QUES: Given a number N. Find if it can be expressed as sum of two prime numbers.

// Example 1:

// Input: N = 34
// Output: "Yes" 
// Explanation: 34 can be expressed as 
// sum of two prime numbers.
// Example 2:

// Input: N = 23
// Output: "No"
// Explanation: 23 cannnot be expressed as
// sum of two prime numbers. 

// Your Task:  
// You dont need to read input or print anything. Complete the function isSumOfTwo() which takes N as input parameter and returns "Yes" if can be expressed as sum of two prime numbers. else return "No".

// Expected Time Complexity: O(N*sqrt(N))
// Expected Auxiliary Space: O(1)

// Constraints:
// 1 <= N <= 105

//CODE:
class Solution {
    static String isSumOfTwo(int n){
        // code here
        if(n<=3) return "No";
        for(int i=2;i<=n/2;i++){
            if(isPrime(i)&& isPrime(n-i)) return "Yes";
        }
        return "No";
    }
    
    static boolean isPrime(int n){
        //if(n<=1) return false;
        if(n==2) return true;
        if(n%2==0) return false;
        for(int i=3; i*i<=n;i++){
            if(n%i==0) return false;
        }
        return true;
    }
}
