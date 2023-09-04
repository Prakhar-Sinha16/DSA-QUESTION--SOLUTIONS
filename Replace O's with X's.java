gfg link: https://practice.geeksforgeeks.org/problems/replace-os-with-xs0052/1

QUES:
Given a matrix mat of size N x M where every element is either 'O' or 'X'. Replace all 'O' with 'X' that are surrounded by 'X'.

A 'O' (or a set of 'O') is considered to be surrounded by 'X' if there are 'X' at locations just below, just above, just left and just right of it.

Example 1:

Input: 
n = 5, m = 4
mat = {{'X', 'X', 'X', 'X'}, 
       {'X', 'O', 'X', 'X'}, 
       {'X', 'O', 'O', 'X'}, 
       {'X', 'O', 'X', 'X'}, 
       {'X', 'X', 'O', 'O'}}
Output: 
ans = {{'X', 'X', 'X', 'X'}, 
       {'X', 'X', 'X', 'X'}, 
       {'X', 'X', 'X', 'X'}, 
       {'X', 'X', 'X', 'X'}, 
       {'X', 'X', 'O', 'O'}}
Explanation: 
Following the rule the above matrix is the resultant matrix. 
Example 2:

 

Input: 
n = 5, m = 4
mat = {{'X', 'O', 'X', 'X'}, 
       {'X', 'O', 'X', 'X'}, 
       {'X', 'O', 'O', 'X'}, 
       {'X', 'O', 'X', 'X'}, 
       {'X', 'X', 'O', 'O'}}
Output: 
ans = {{'X', 'O', 'X', 'X'}, 
       {'X', 'O', 'X', 'X'}, 
       {'X', 'O', 'O', 'X'}, 
       {'X', 'O', 'X', 'X'}, 
       {'X', 'X', 'O', 'O'}}
Explanation: 
Following the rule the above matrix is the resultant matrix.
Your Task:
You do not need to read input or print anything. Your task is to complete the function fill() which takes N, M and mat as input parameters ad returns a 2D array representing the resultant matrix.

Expected Time Complexity: O(n*m)
Expected Auxiliary Space: O(n*m)

Constraints:
1 ≤ n, m ≤ 500

CODE:
class Solution{
    static void dfs(int row, int col, int[][] vis, char a[][], int delrow[], int delcol[])
    {
        vis[row][col] = 1;
        int n = a.length;
        int m = a[0].length;
        
        //check for Top , Right, Buttom, Left
        for(int i=0; i<4; i++)
        {
            int nrow = row + delrow[i];
            int ncol = col + delcol[i];
            if(nrow >=0 && nrow <n &&  ncol >=0 && ncol < m &&
            vis[nrow][ncol] == 0 && a[nrow][ncol] == 'O')
            {
                dfs(nrow, ncol, vis, a, delrow, delcol);
            }
        }
    }
    
    
    static char[][] fill(int n, int m, char a[][])
    {
        int delrow[] = {-1, 0, +1, 0};
        int delcol[] = {0, +1, 0, -1};
        int vis[][] = new int[n][m];
        
        // for first row and last row
        for(int j=0; j<m; j++)
        {
            // First Row
            if(vis[0][j] == 0 && a[0][j] == 'O')
            {
                dfs(0, j, vis, a, delrow, delcol);
            }
            
            // Last Row
            if(vis[n-1][j] == 0 && a[n-1][j] == 'O')
            {
                dfs(n-1, j, vis, a, delrow, delcol);
            }
        }
        
        // For first Col and Last Col
        
        for(int i=0; i<n; i++)
        {
            // First Col
            if(vis[i][0] == 0 && a[i][0] == 'O')
            {
                dfs(i, 0, vis, a, delrow, delcol);
            }
            
            // Last Col
            if(vis[i][m-1] == 0 && a[i][m-1] == 'O')
            {
                dfs(i, m-1, vis, a, delrow, delcol);
            }
        }
        
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<m; j++)
            {
                if(vis[i][j] == 0 && a[i][j] == 'O')
                {
                    a[i][j] = 'X';
                }
            }
        }
        return a;
    }
}
