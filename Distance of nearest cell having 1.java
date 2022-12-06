gfg link => https://practice.geeksforgeeks.org/problems/distance-of-nearest-cell-having-1-1587115620/1

//QUES: Given a binary grid of n*m. Find the distance of the nearest 1 in the grid for each cell.
// The distance is calculated as |i1  - i2| + |j1 - j2|, where i1, j1 are the row number and column number of the current cell, and i2, j2 are the row number 
//and column number of the nearest cell having value 1.

// Example 1:

// Input: grid = {{0,1,1,0},{1,1,0,0},{0,0,1,1}}
// Output: {{1,0,0,1},{0,0,1,1},{1,1,0,0}}
// Explanation: The grid is-
// 0 1 1 0 
// 1 1 0 0 
// 0 0 1 1 
// 0's at (0,0), (0,3), (1,2), (1,3), (2,0) and
// (2,1) are at a distance of 1 from 1's at (0,1),
// (0,2), (0,2), (2,3), (1,0) and (1,1)
// respectively.


// Example 2:

// Input: grid = {{1,0,1},{1,1,0},{1,0,0}}
// Output: {{0,1,0},{0,0,1},{0,1,2}}
// Explanation: The grid is-
// 1 0 1
// 1 1 0
// 1 0 0
// 0's at (0,1), (1,2), (2,1) and (2,2) are at a 
// distance of 1, 1, 1 and 2 from 1's at (0,0),
// (0,2), (2,0) and (1,1) respectively.

// Yout Task:
// You don't need to read or print anything, Your task is to complete the function nearest() which takes the grid as an input parameter and returns a matrix of 
//the same dimensions where the value at index (i, j) in the resultant matrix signifies the minimum distance of 1 in the matrix from grid[i][j].
 

// Expected Time Complexity: O(n*m)
// Expected Auxiliary Space: O(n*m)

// Constraints:
// 1 ≤ n, m ≤ 500

//CODE: 
class Solution{
    //Function to find distance of nearest 1 in the grid for each cell.
    public static boolean isValid(int i, int j, int n, int m, int[][]ans){
        if(i<0 || j<0 || i>=n || j>=m || ans[i][j]!=-1)return false;
        return true;
    }
    public int[][] nearest(int[][] grid){
        // Code here
        int n=grid.length;
        int m=grid[0].length;
        int [][]ans = new int[n][m];
        ArrayDeque<int[]> q = new ArrayDeque<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 1){
                    q.add(new int[]{i,j});
                    ans[i][j]=0;
                }else{
                    ans[i][j]=-1;
                }
            }
        }
        while(q.size()>0){
            int s = q.size();
            while(s-- > 0){
                int[]p=q.pop();
                int i=p[0];
                int j=p[1];
                if(isValid(i+1,j,n,m,ans)) {
                    q.add(new int[]{i+1,j});
                    ans[i+1][j]=ans[i][j]+1;
                }
                if(isValid(i,j+1,n,m,ans)) {
                    q.add(new int[]{i,j+1});
                    ans[i][j+1]=ans[i][j]+1;
                }
                if(isValid(i-1,j,n,m,ans)) {
                    q.add(new int[]{i-1,j});
                    ans[i-1][j]=ans[i][j]+1;
                }
                if(isValid(i,j-1,n,m,ans)) {
                    q.add(new int[]{i,j-1});
                    ans[i][j-1]=ans[i][j]+1;
                }
            }
        }
        return ans;
    }
}
