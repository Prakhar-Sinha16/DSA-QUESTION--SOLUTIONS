gfg link => https://practice.geeksforgeeks.org/problems/sequence-fun5018/1

// Ques: Sequence Fun
// EasyAccuracy: 21.77%Submissions: 1939 Points: 2
// You have a sequence 2,5,16,65,........Given an integer n as input . You have to find the value at nth position in the sequence.
 

// Example 1:

// Input: n = 4
// Output: 65
// Example 2:

// Input: n = 10
// Output: 9864101
 

// Your Task:

// You don't need to read or print anything, Your task is to complete the function NthTerm() which takes n as input parameter and retruns value at nth position of the given sequence modulo 109 + 7.
 

// Expected Time Compelxity:  O(n)
// Expected Space Complexity: O(1)
 

// Constraints:

// 1 <= n <= 104

//CODE:
class Solution{
    public int NthTerm(int n){
        // code here
        long ans=2;
        int mod=1000000007;
        if(n==1) return (int)ans;
        for(int i=2;i<=n;i++){
           ans = (((ans*i)%mod)+1)%mod;
        }
        return (int)ans;
    }
}
