gfg link: https://www.geeksforgeeks.org/problems/maximum-sum-rectangle2948/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=practice_card

QUES:
Maximum sum Rectangle
Difficulty: Medium
Given a 2D matrix M of dimensions RxC. Find the maximum sum submatrix in it.

Example 1:

Input:
R=4
C=5
M=[[1,2,-1,-4,-20],
[-8,-3,4,2,1],
[3,8,10,1,3],
[-4,-1,1,7,-6]]
Output:
29
Explanation:
The matrix is as follows and the
blue rectangle denotes the maximum sum
rectangle.
Thumbnail
Example 2:

Input:
R=2
C=2
M=[[-1,-2],[-3,-4]]
Output:
-1
Explanation:
Taking only the first cell is the 
optimal choice.

Your Task:
You don't need to read input or print anything. Your task is to complete the function maximumSumRectangle() which takes the number R, C, and the 2D matrix M as input parameters and returns the maximum sum submatrix.


Expected Time Complexity:O(R*R*C)
Expected Auxillary Space:O(R*C)
 

Constraints:
1<=R,C<=500
-1000<=M[i][j]<=1000

CODE:
class Solution {
    int maximumSumRectangle(int r, int c, int M[][]) {
        // code here
        int sum[] = new int[r];
        int maxSum=Integer.MIN_VALUE;
        for(int cStart=0;cStart<c;cStart++){
            Arrays.fill(sum,0);
            for(int cEnd=cStart; cEnd<c;cEnd++){
                for(int row=0;row<r;row++){
                    sum[row] = sum[row]+M[row][cEnd];
                }
                int curSum = Kadens(sum);
                maxSum = Math.max(curSum,maxSum);
            }
        }
        return maxSum;
    }
    
    public static int Kadens(int a[]){
        int maxSum=Integer.MIN_VALUE;
        int curSum=0;
        
        for(int i=0;i<a.length;i++){
            curSum += a[i];
            if(curSum > maxSum){
                maxSum=curSum;
            }
            if(curSum<0){
                curSum=0;
            }
        }
        return maxSum;
    }
};
