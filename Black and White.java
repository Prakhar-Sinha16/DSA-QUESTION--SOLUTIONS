gfg link => https://practice.geeksforgeeks.org/problems/black-and-white-1587115620/1

//QUES: Given the chessboard dimensions. Find out the number of ways we can place a black and a white Knight on this chessboard such that they cannot attack each other.

// Note:
// The knights have to be placed on different squares. A knight can move two squares horizontally and one square vertically (L shaped), or two squares vertically and 
// one square horizontally (L shaped). The knights attack each other if one can reach the other in one move.

// Example 1:

// Input:
// N = 2, M = 2
// Output: 12 
// Explanation: There are 12 ways we can place a black and a white Knight on this chessboard such that they cannot attack each other.

// Example 2:

// Input:
// N = 2, M = 3
// Output: 26
// Explanation: There are 26 ways we can place a black and a white Knight on this chessboard such that they cannot attack each other.
// Your Task:
// Your task is to complete the function numOfWays() which takes the chessboard dimensions N and M as inputs and returns the number of ways we can place 2 Knights on this chessboard such that they cannot attack each other. Since this number can be very large, return it modulo 109+7.

// Expected Time Complexity: O(N*M).
// Expected Auxiliary Space: O(1).

// Constraints:
// 1 <= N * M <= 105

//CODE:
class BlackAndWhite{
    //Function to find out the number of ways we can place a black and a 
    //white Knight on this chessboard such that they cannot attack each other.
    static long numOfWays(int n, int m){
        // add your code here
        long ans=0;
        long mod=1000000007;
        int dir[][]=new int[][]{{1,2},{-1,2},{1,-2},{-1,-2},{2,1},{-2,1},{2,-1},{-2,-1}};
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                long cur = n*m;
                long pos = 1L;
                for(int k=0;k<dir.length;k++)
                {
                    int x=i+dir[k][0];
                    int y=j+dir[k][1];
                    
                    if(valid(x,y,n,m))
                        pos++;
                }
                cur-=pos;
                ans=(ans+cur)%mod;
            }
        }
        return ans%mod;
    }
    
     public static boolean valid(int x,int y,int N,int M){
        if(x<0||y<0||x>=N||y>=M) return false;
        return true;
    }
}
