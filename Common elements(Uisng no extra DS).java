gfg link: https://practice.geeksforgeeks.org/problems/common-elements1132/1?page=2&sortBy=submissions

QUES:
Given three arrays sorted in increasing order. Find the elements that are common in all three arrays.
Note: can you take care of the duplicates without using any additional Data Structure?

Example 1:

Input:
n1 = 6; A = {1, 5, 10, 20, 40, 80}
n2 = 5; B = {6, 7, 20, 80, 100}
n3 = 8; C = {3, 4, 15, 20, 30, 70, 80, 120}
Output: 20 80
Explanation: 20 and 80 are the only
common elements in A, B and C.
 

Your Task:  
You don't need to read input or print anything. Your task is to complete the function commonElements() which take the 3 arrays A[], B[], C[] and their respective sizes n1, n2 and n3 as inputs and returns an array containing the common element present in all the 3 arrays in sorted order. 
If there are no such elements return an empty array. In this case the output will be printed as -1.

 

Expected Time Complexity: O(n1 + n2 + n3)
Expected Auxiliary Space: O(n1 + n2 + n3)

 

Constraints:
1 <= n1, n2, n3 <= 10^5
The array elements can be both positive or negative integers.

CODE:
class Solution{
    ArrayList<Integer> commonElements(int a[], int b[], int c[], int n1, int n2, int n3) {
        // code here 
        ArrayList<Integer> ans = new ArrayList<>();
    
        int i = 0, j = 0, k = 0;
        
        while (i < n1 && j < n2 && k < n3) {
            if (a[i] == b[j] && b[j] == c[k]) {
                ans.add(a[i]);
                int currentElement = a[i];
                while (i < n1 && a[i] == currentElement) i++;
                while (j < n2 && b[j] == currentElement) j++;
                while (k < n3 && c[k] == currentElement) k++;
            } else if (a[i] <= b[j] && a[i] <= c[k]) {
                i++;
            } else if (b[j] <= a[i] && b[j] <= c[k]) {
                j++;
            } else {
                k++;
            }
        }
        
        return ans;
    }
}