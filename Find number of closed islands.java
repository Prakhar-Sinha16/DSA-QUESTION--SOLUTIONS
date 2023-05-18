gfg link: https://practice.geeksforgeeks.org/problems/find-number-of-closed-islands/1

QUES:
Given a binary matrix mat[][] of dimensions NxM such that 1 denotes land and 0 denotes water. Find the number of closed islands in the 
given matrix.

Note: A closed island is a group of 1s surrounded by only 0s on all the boundaries (except diagonals). In simple words, a closed island 
is an island whose none of the 1s lie on the edges of the matrix.

Example 1:

Input:
N = 5, M = 8
mat[][] = {{0, 0, 0, 0, 0, 0, 0, 1}, 
           {0, 1, 1, 1, 1, 0, 0, 1}, 
           {0, 1, 0, 1, 0, 0, 0, 1}, 
           {0, 1, 1, 1, 1, 0, 1, 0}, 
           {1, 0, 0, 0, 0, 1, 0, 1}}
Output:
2
Explanation:
mat[][] = {{0, 0, 0, 0, 0, 0, 0, 1}, 
           {0, 1, 1, 1, 1, 0, 0, 1}, 
           {0, 1, 0, 1, 0, 0, 0, 1}, 
           {0, 1, 1, 1, 1, 0, 1, 0}, 
           {1, 0, 0, 0, 0, 1, 0, 1}} 
There are 2 closed islands. The islands in dark are closed because they are completely surrounded by 0s (water). There are two more 
islands in the last column of the matrix, but they are not completely surrounded by 0s. Hence they are not closed islands. 
Example 2:

Input:
N = 3, M = 3
mat[][] = {{1, 0, 0},
           {0, 1, 0},
           {0, 0, 1}}
Output: 
1
Explanation:
mat[][] = {{1, 0, 0},
          {0, 1, 0},
          {0, 0, 1}}
There is just a one closed island.
Your task:
You dont need to read input or print anything. Your task is to complete the function closedIslands() which takes two integers N and M, 
and a 2D binary matrix mat as input parameters and returns the number of closed islands.

Expected Time Complexity: O(N*M)
Expected Auxiliary Space: O(N*M)

Constraints:
1 ≤ N,M ≤ 500
  
CODE:
class Pair{
    int i;
    int j;
    
    Pair(int i, int j){
        this.i=i;
        this.j=j;
    }
}
class Solution
{
    public int closedIslands(int[][] matrix, int N, int M)
    {
        boolean[][] visited = new boolean[N][M];
        Queue<Pair> qq = new LinkedList<>();
        
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
               if(i==0 || i==N-1 || j==0 || j==M-1){
                   if(matrix[i][j]==1){
                       qq.add(new Pair(i,j));
                       visited[i][j]=true;
                   }
               }
            }
        }
        
        bfs(visited,matrix,qq,N,M);
        
        int count =0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(matrix[i][j]==1 && visited[i][j]==false){
                    Queue<Pair> tq = new LinkedList<>();
                    visited[i][j]=true;
                    tq.add(new Pair(i,j));
                    bfs(visited,matrix,tq,N,M);
                    count++;
                }
            }
        }
        return count;
    }
    
    public void bfs(boolean[][] visited,int[][] matrix, Queue<Pair> qq,int N,int M){
        
        
        int[] r={-1,0,1,0};
        int[] c={0,1,0,-1};
        while(!qq.isEmpty()){
            
            Pair p= qq.poll();
            for(int k=0;k<4;k++){
                int inew= p.i+r[k];
                int jnew= p.j+c[k];
                
                if(inew>=0 && inew<N && jnew>=0 && jnew<M && visited[inew][jnew]==false && matrix[inew][jnew]==1){
                    visited[inew][jnew]=true;
                    qq.add(new Pair(inew,jnew));
                }
            }
       }
    }
}
