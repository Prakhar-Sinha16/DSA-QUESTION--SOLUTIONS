gfg link => https://practice.geeksforgeeks.org/problems/base-equivalence1022/1
//QUES: Given a number (n) and no. of digits (m) to represent the number, we have to check if we can represent n using exactly m digits in any base from 2 to 32.

// Example 1:

// Input: n = 8, m = 2
// Output: Yes 
// Explanation: Possible in base 3 as 8 in base 3 is 22.  

// Example 2:

// Input: n = 8, m = 3
// Output: No
// Explanation: Not possible in any base. 

// Your Task:  
// You dont need to read input or print anything. Complete the function baseEquiv() which takes n and m as input parameter and returns "Yes" if its possible to represent the number else "No" without quotes..

// Expected Time Complexity: O(logN).
// Expected Auxiliary Space: O(1)

// Constraints:
// 1 <= n <=109
// 1 <= m <=32

//CODE:
class Solution{
    String baseEquiv(int n, int m){
        // code here
        //int i=2;
        for(int i=2;i<=32;i++){
            int digits = (int)(Math.log(n)/Math.log(i))+1;//to calculate the no. of digits we use this
            if(digits==m)return "Yes";
        }
        return "No";
    }
}
