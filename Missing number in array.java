gfg link: https://practice.geeksforgeeks.org/problems/missing-number-in-array1416/1?page=1&sortBy=submissions

QUES:
Given an array of size N-1 such that it only contains distinct integers in the range of 1 to N. Find the missing element.

Example 1:

Input:
N = 5
A[] = {1,2,3,5}
Output: 4
Example 2:

Input:
N = 10
A[] = {6,1,2,8,3,4,7,10,5}
Output: 9

Your Task :
You don't need to read input or print anything. Complete the function MissingNumber() that takes array and N as input  parameters and 
returns the value of the missing number.


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)


Constraints:
1 ≤ N ≤ 106
1 ≤ A[i] ≤ 106

CODE:
class Solution {
    int missingNumber(int a[], int n) {
        // Your Code Here
        Arrays.sort(a);
        int ans=0;
        try{
            for(int i=0; i<n; i++){
                if(a[i] != i+1){
                    ans=i+1;
                    break;
                }
            }
        }catch(ArrayIndexOutOfBoundsException e){
            ans=n;
        }
        return ans;
    }
}
