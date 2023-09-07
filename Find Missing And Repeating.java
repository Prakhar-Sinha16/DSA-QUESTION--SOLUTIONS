gfg link: https://practice.geeksforgeeks.org/problems/find-missing-and-repeating2512/1?page=2&sortBy=submissions

QUES:
Given an unsorted array Arr of size N of positive integers. One number 'A' from set {1, 2,....,N} is missing and one number 'B' occurs twice in array. Find these two numbers.

Example 1:

Input:
N = 2
Arr[] = {2, 2}
Output: 2 1
Explanation: Repeating number is 2 and 
smallest positive missing number is 1.
Example 2:

Input:
N = 3
Arr[] = {1, 3, 3}
Output: 3 2
Explanation: Repeating number is 3 and 
smallest positive missing number is 2.
Your Task:
You don't need to read input or print anything. Your task is to complete the function findTwoElement() which takes the array of integers arr and n as parameters and returns an array of integers of size 2 denoting the answer ( The first index contains B and second index contains A.)

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

Constraints:
2 ≤ N ≤ 105
1 ≤ Arr[i] ≤ N

CODE:
class Solve {
    int[] findTwoElement(int arr[], int n) {
        // code here
        int[] result = new int[2];
        
        // Cyclic Sort
        int i = 0;
        while (i < n) {
            if (arr[i] != arr[arr[i] - 1]) {
                // Swap arr[i] with arr[arr[i]-1]
                int temp = arr[i]; 
                arr[i] = arr[temp - 1];
                arr[temp - 1] = temp;
            } else {
                i++;
            }
        }
        
        for (i = 0; i < n; i++) {
            if (arr[i] != i + 1) {
                result[0] = arr[i]; // Repeating number
                result[1] = i + 1;   // Missing number
                break;
            }
        }
        
        return result;
    }
}
