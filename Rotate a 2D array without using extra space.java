gfg link: https://practice.geeksforgeeks.org/problems/rotate-a-2d-array-without-using-extra-space1004/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article

QUES:
Given a N x N 2D matrix Arr representing an image. Rotate the image by 90 degrees (anti-clockwise). You need to do this in place. Note 
that if you end up using an additional array, you will only receive partial score.

Example 1:

Input:
N = 3
Arr[][] = {{1,  2,  3}
           {4,  5,  6}
           {7,  8,  9}}
Output:
 3  6  9 
 2  5  8 
 1  4  7 
Explanation: The given matrix is rotated
by 90 degree in anti-clockwise direction.
Example 2:

Input:
N = 4
Arr[][] = {{1,  2,  3,  4}
           {5,  6,  7,  8}
           {9, 10, 11, 12}
           {13, 14, 15, 16}}
Output:
 4  8 12 16 
 3  7 11 15 
 2  6 10 14 
 1  5  9 13
Explanation: The given matrix is rotated
by 90 degree in anti-clockwise direction.
Your Task:  
You don't need to read input or print anything. Your task is to complete the function rotate() which takes the 2D array of integers arr 
and n as parameters and returns void. You need to change the array itself.

Expected Time Complexity: O(N*N)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ N ≤ 1000
1 ≤ Arr[i][j] ≤ 1000
  
CODE:
class Solution {
    void rotateMatrix(int a[][], int n) {
        // code here
        transposeOfMatrix(a);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int swap = a[j][i];
                a[j][i] = a[n - j - 1][i];
                a[n - j - 1][i] = swap;
            }
        }
    }
    void transposeOfMatrix(int a[][]) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j < a.length; j++) {
                int swap = a[i][j];
                a[i][j] = a[j][i];
                a[j][i] = swap;
            }
        }
    }
}
