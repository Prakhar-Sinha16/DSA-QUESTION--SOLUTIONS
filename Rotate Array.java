gfg link: https://practice.geeksforgeeks.org/problems/rotate-array-by-n-elements-1587115621/1?page=3&sortBy=submissions

QUES:
Given an unsorted array arr[] of size N. Rotate the array to the left (counter-clockwise direction) by D steps, where D is a positive 
integer. 

 

Example 1:

Input:
N = 5, D = 2
arr[] = {1,2,3,4,5}
Output: 3 4 5 1 2
Explanation: 1 2 3 4 5  when rotated
by 2 elements, it becomes 3 4 5 1 2.
Example 2:

Input:
N = 10, D = 3
arr[] = {2,4,6,8,10,12,14,16,18,20}
Output: 8 10 12 14 16 18 20 2 4 6
Explanation: 2 4 6 8 10 12 14 16 18 20 
when rotated by 3 elements, it becomes 
8 10 12 14 16 18 20 2 4 6.
 

Your Task:
Complete the function rotateArr() which takes the array, D and N as input parameters and rotates the array by D elements. The array must 
be modified in-place without using extra space. 

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

Constraints:
1 <= N <= 106
1 <= D <= 106
0 <= arr[i] <= 105

CODE:
class Solution{
    //Function to rotate an array by d elements in counter-clockwise direction. 
    static void rotateArr(int arr[], int d, int n){
        // add your code here
        // Calculate the effective rotation amount
        d = d % n;
        
        // Create a temporary array to store the rotated elements
        int[] temp = new int[d];
        
        // Store the first d elements in the temporary array
        System.arraycopy(arr, 0, temp, 0, d);
        
        // Shift the remaining elements to the left by d positions
        System.arraycopy(arr, d, arr, 0, n - d);
        
        // Copy the elements from the temporary array to the end of the original array
        System.arraycopy(temp, 0, arr, n - d, d);
    }
}
