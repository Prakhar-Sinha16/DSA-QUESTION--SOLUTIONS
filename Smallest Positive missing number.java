gfg link: https://practice.geeksforgeeks.org/problems/smallest-positive-missing-number-1587115621/1

QUES:
You are given an array arr[] of N integers including 0. The task is to find the smallest positive number missing from the array.

Example 1:

Input:
N = 5
arr[] = {1,2,3,4,5}
Output: 6
Explanation: Smallest positive missing 
number is 6.
Example 2:

Input:
N = 5
arr[] = {0,-10,1,3,-20}
Output: 2
Explanation: Smallest positive missing 
number is 2.
Your Task:
The task is to complete the function missingNumber() which returns the smallest positive missing number in the array.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).

Constraints:
1 <= N <= 106
-106 <= arr[i] <= 106

CODE:
class Solution
{
    //Function to find the smallest positive number missing from the array.
    static int missingNumber(int arr[], int size)
    {
        // Your code here
        Arrays.sort(arr);
        int i = 0;
        int temp = 1;
        while (i < size) {
            if (arr[i] > temp ) return temp;
            else if (arr[i] == temp) {
                temp++;
            }
            i++;
        }
        return temp;
    }
}
