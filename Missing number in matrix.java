gfg link => https://practice.geeksforgeeks.org/problems/missing-number-in-matrix5316/1

//  QUES: Given a matrix of size n x n such that it has only one 0, Find the positive number (greater than zero) to be placed in place of the 0 such that sum of the numbers in every row, column and two diagonals become equal. If no such number exists, return -1.

// Note: Diagonals should be only of the form matrix[i][i] and matrix[i][n-i-1]. n is always greater than 1.
 

// Example 1:

// Input: matrix = {{5, 5}, {5, 0}}
// Output: 5
// Explanation: The matrix is
// 5 5
// 5 0
// Therefore If we place 5 instead of 0, all
// the element of matrix will become 5. 
// Therefore row 5+5=10, column 5+5=10 and 
// diagonal 5+5=10, all are equal.
// Example 2:

// Input: matrix = {{1, 2, 0}, {3, 1, 2}, 
// {2, 3, 1}}
// Output: -1
// Explanation: It is not possible to insert 
// an element in place of 0 so that the 
// condition is satisfied.thus result is -1. 

// Your Task:
// You don't need to read or print anyhting. Your task is to complete the function MissingNo() which takes the matrix as input parameter and returns the number which should be placed in place of 0 such that the condition gets satisfied. If not possible return -1.
 

// Expected Time Complexity: O(n * n)
// Expected Space Complexity: O(2 * n)
 

// Constraints:
// 2 <= n <= 1000
// 1 <= elements in the matrix <= 10^9

//CODE:
class Solution
{
    public long  MissingNo(int[][] matrix)
    {
        // code here
        int row = -1;
        int col = -1;
        long sum = 0;
        long msum = 0;
        long mdsltr = 0;
        long mdsrtl = 0;
        boolean flag = false;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    row = i;
                    col = j;
                    break;
                }
            }
        }
        for(int i = 0; i < matrix.length; i++){
            if(i != row){
                for(int j = 0; j < matrix[0].length; j++){
                    sum += (long)matrix[i][j];
                }
                break;
            }
        }
        for(int j = 0; j < matrix[0].length; j++){
            if(j != col){
                msum += matrix[row][j];
            }
        }
        long val = (sum - msum);
        if(val > Integer.MAX_VALUE){
            flag = true;
        }
        for(int i = 0; i < matrix.length; i++){
            long ms = 0;
            for(int j = 0; j < matrix[0].length; j++){
                if(i == row && j == col){
                    ms += val;
                    continue;
                }
                ms += matrix[i][j];
            }
            if(ms != sum){
                return -1;
            }
        }
        for(int j = 0; j < matrix[0].length; j++){
            long ms = 0;
            for(int i = 0; i < matrix.length; i++){
                if(i == row && j == col){
                    ms += val;
                    continue;
                }
                ms += matrix[i][j];
            }
            if(ms != sum){
                return -1;
            }
        }
        for(int i = 0, j=0; i < matrix.length && j < matrix[0].length; i++, j++){
            if(i == row && j == col){
                    mdsltr += val;
                    continue;
                }
            mdsltr += matrix[i][j];
        }
        if(mdsltr != sum){
            return -1;
        }
        for(int i = 0, j=matrix[0].length - 1; i < matrix.length && j >=0; i++, j--){
            if(i == row && j == col){
                    mdsrtl += val;
                    continue;
                }
            mdsrtl += matrix[i][j];
        }
        if(mdsrtl != sum){
            return -1;
        }
        if(flag == true){
            return val;
        }
        return val <= 0? -1: val;
    }
}
