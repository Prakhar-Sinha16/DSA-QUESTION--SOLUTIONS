gfg link => https://practice.geeksforgeeks.org/problems/a-difference-of-values-and-indexes0302/1

//QUES: Given an unsorted array arr[ ] of size n, you need to find the maximum difference of absolute values of elements and indexes, i.e.,
//for i <= j, calculate maximum of | arr[ i ] - arr[ j ] | + | i - j |. 

// Example 1:

// Input : 
// n = 3
// arr[ ] = {1, 3, -1}
// Output: 5
// Explanation:
// Maximum difference comes from indexes 
// 1, 2 i.e | 3 - (-1) | + | 1 - 2 | = 5

// Example 2:

// Input : 
// n = 4
// arr[ ] = {5, 9, 2, 6} 
// Output:  8
// Explanation: 
// Maximum difference comes from indexes 
// 1, 2 i.e | 9 - 2 | + | 1 - 2 | = 8
 

// Your Task:
// This is a function problem. The input is already taken care of by the driver code. You only need to complete the function maxDistance() that takes an array (arr), sizeOfArray (n), and return the maximum difference as given in the question.  The driver code takes care of the printing.

// Expected Time Complexity: O(n).
// Expected Auxiliary Space: O(1).
 

// Constraints:
// 1 <= n <= 5*(10^5)
// -10^6 <= arr[ i ] <= 10^6

//CODE:
// Given an unsorted array arr[ ] of size n, you need to find the maximum difference of absolute values of elements and indexes, i.e., 
// for i <= j, calculate maximum of | arr[ i ] - arr[ j ] | + | i - j |. 

// Example 1:

// Input : 
// n = 3
// arr[ ] = {1, 3, -1}
// Output: 5
// Explanation:
// Maximum difference comes from indexes 
// 1, 2 i.e | 3 - (-1) | + | 1 - 2 | = 5

// Example 2:

// Input : 
// n = 4
// arr[ ] = {5, 9, 2, 6} 
// Output:  8
// Explanation: 
// Maximum difference comes from indexes 
// 1, 2 i.e | 9 - 2 | + | 1 - 2 | = 8
 

// Your Task:
// This is a function problem. The input is already taken care of by the driver code. You only need to complete the function maxDistance() that takes an array (arr), sizeOfArray (n), and return the maximum difference as given in the question.  The driver code takes care of the printing.

// Expected Time Complexity: O(n).
// Expected Auxiliary Space: O(1).
 

// Constraints:
// 1 <= n <= 5*(10^5)
// -10^6 <= arr[ i ] <= 10^6

//CODE:

//BRUTE FORCE APPROACH
// class Solution{
//     // Function for finding maximum and value pair
//     public static int maxDistance (int arr[], int n) {
        //THIS PROGRAM WILL GIVE TLE BECUSE IT'S A BRUTE FORCE APPROACH
        // int ans=0;
        // for(int i=0;i<n-1;i++){
        //     for(int j=i+1;j<n;j++){
        //         ans=Math.max(ans,Math.abs(arr[ i ] - arr[ j ])+(j-i));
        //     }
        // }
        // return ans;
//   }
// }

//OPTIMIZED APPROACH
class Solution{
    // Function for finding maximum and value pair
    public static int maxDistance (int arr[], int n) {
        //Complete the function
        
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        int max2=Integer.MIN_VALUE;
        int min2=Integer.MAX_VALUE;

        for(int i=0;i<n;i++){
            max=Math.max(max,arr[i]+i);
            min=Math.min(min,arr[i]+i);

            max2=Math.max(max2,arr[i]-i);
            min2=Math.min(min2,arr[i]-i);

        }
        return Math.max(max-min,max2-min2);
    }
    
    
}
