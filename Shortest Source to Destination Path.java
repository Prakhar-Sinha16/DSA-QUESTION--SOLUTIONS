gfg link: https://practice.geeksforgeeks.org/problems/shortest-source-to-destination-path3544/1

QUES:
Given a 2D binary matrix A(0-based index) of dimensions NxM. Find the minimum number of steps required to reach from (0,0) to (X, Y).
Note: You can only move left, right, up and down, and only through cells that contain 1.

Example 1:

Input:
N=3, M=4
A=[[1,0,0,0], 
   [1,1,0,1],
   [0,1,1,1]]
X=2, Y=3 
Output:
5
Explanation:
The shortest path is as follows:
(0,0)->(1,0)->(1,1)->(2,1)->(2,2)->(2,3).
Example 2:

Input:
N=3, M=4
A=[[1,1,1,1],
   [0,0,0,1],
   [0,0,0,1]]
X=0, Y=3
Output:
3
Explanation:
The shortest path is as follows:
(0,0)->(0,1)->(0,2)->(0,3).
Your Task:
You don't need to read input or print anything. Your task is to complete the function shortestDistance() which takes the integer N, M, X, Y, and the 2D binary matrix A as input parameters and returns the minimum number of steps required to go from (0,0) to (X, Y).If it is impossible to go from (0,0) to (X, Y),then function returns -1. If value of the cell (0,0) is 0 (i.e  A[0][0]=0) then return -1.

Expected Time Complexity:O(N*M)
Expected Auxillary Space:O(N*M)

Constraints:
1 <= N,M <= 250
0 <= X < N
0 <= Y < M
0 <= A[i][j] <= 1

CODE:
class Pair{  //pair to store distance,i and j of the matrix
    int first,second,third;
    Pair(int dis,int a,int b){
        first=dis;
        second=a;
        third=b;
    }
}

class Solution {
    int shortestDistance(int N, int M, int A[][], int X, int Y) {
        // code here
        //BFS traversal of A using Queue
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(0,0,0)); //we start from first position where dis=0,i=0 and j=0
        int ti[]={0,-1,1,0}; // both ti[] and tj[] will be used to check left,right,up and down from current position
        int tj[]={1,0,0,-1}; // for example for ti[0]=0 and tj[0]=1 we will check on the right side and for ti[1]=-1 and tj[1]=0 we will check ont he above
        while(!q.isEmpty()){
            Pair temp=q.poll();
            int dis=temp.first,i=temp.second,j=temp.third;
            if(i==X && j==Y) return dis; //if we find x and y we return the dis
            for(int k=0;k<4;k++){
                int newi=i+ti[k],newj=j+tj[k]; 
                if(newi>=0 && newj>=0 && newi<N && newj<M && A[newi][newj]==1){ //here we are checking so that the positions don't go out of bounds and the next position we are checking is 1
                    A[newi][newj]=0; //making the position zero so we do not traverse throug it again
                    q.add(new Pair(dis+1,newi,newj)); // incrementing the distance and adding the new newj and newi positions
                }
            }
        }
        return -1;
    }
};
