This Question Was Asked In Google Interview!!!

Ques:
Minimum sum submatrix in a given 2D array
Given a 2D array, find the minimum sum submatrix in it.

Examples:  

Input : M[][] = {{1, 2, -1, -4, -20},
                 {-8, -3, 4, 2, 1},
                 {3, 8, 10, 1, 3},
                 {-4, -1, 1, 7, -6}}
Output : -26
Submatrix starting from (Top, Left): (0, 0)
and ending at (Bottom, Right): (1, 4) indexes.
The elements are of the submatrix are:
{ {1, 2, -1, -4, -20},
  {-8, -3, 4, 2, 1}  } having sum = -26

CODE:
import java.util.Arrays;
public class Main
{
	public static void main(String[] args) {
		int M[][] = {
		    {1, 2, -1, -4, -20},
		    {-8, -3, 4, 2, 1},
		    {3, 8, 10, 1, 3},
		    {-4, -1, 1, 7, -6}
		};
		int r = 4;
		int c = 5;
		System.out.print(minimumSumRectangle(r,c,M));
	}
	
	static int minimumSumRectangle(int r, int c, int M[][]){
	    int sum[] = new int[r];
	    int minSum = Integer.MAX_VALUE;
	    for(int cStart=0; cStart<c; cStart++){
	        Arrays.fill(sum,0);
	        for(int cEnd=cStart; cEnd<c; cEnd++){
	            for(int row=0; row<r; row++){
	                sum[row]=sum[row]+M[row][cEnd];
	            }
	            int curSum = kadens(sum);
	            minSum = Math.min(minSum, curSum);
	        }
	    }
	    return minSum;
	}
	
	static int kadens(int a[]){
	    int minSum=Integer.MAX_VALUE;
	    int curSum=0;
	    for(int i=0; i<a.length; i++){
	        curSum += a[i];
	        if(curSum < minSum){
	            minSum = curSum;
	        }
	        if(curSum > 0){
	            curSum=0;
	        }
	    }
	    return minSum;
	}
}
