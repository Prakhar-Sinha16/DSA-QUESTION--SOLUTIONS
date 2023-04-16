gfg link: https://practice.geeksforgeeks.org/problems/max-rectangle/1

QUES:
Given a binary matrix M of size n X m. Find the maximum area of a rectangle formed only of 1s in the given matrix.

Example 1:

Input:
n = 4, m = 4
M[][] = {{0 1 1 0},
         {1 1 1 1},
         {1 1 1 1},
         {1 1 0 0}}
Output: 8
Explanation: For the above test case the
matrix will look like
0 1 1 0
1 1 1 1
1 1 1 1
1 1 0 0
the max size rectangle is 
1 1 1 1
1 1 1 1
and area is 4 *2 = 8.
Your Task: 
Your task is to complete the function maxArea which returns the maximum size rectangle area in a binary-sub-matrix with all 1’s. The function takes 3 arguments the 
first argument is the Matrix M[ ] [ ] and the next two are two integers n and m which denotes the size of the matrix M. 

Expected Time Complexity : O(n*m)
Expected Auixiliary Space : O(m)

Constraints:
1<=n,m<=1000
0<=M[][]<=1

Note:The Input/Ouput format and Example given are used for system's internal purpose, and should be used by a user for Expected Output only. As it is a function 
problem, hence a user should not read any input from stdin/console. The task is to complete the function specified, and not to write the full code.
  
CODE:
class Solution {
    public int maxArea(int a[][], int n, int m) {
        // add code here.
        int b[] = new int[a[0].length]; 
		int max=0;
		
		for(int i=0; i<a.length;i++) {
			for(int j=0; j<b.length;j++) {
				if(a[i][j] == 0) {
					b[j]=0;
				}else {
					b[j]++;
				}
			}
			int cur = maximumAreaHistogramOptimized(b);
			max = Math.max(max, cur);
		}
		return max;
    }
    static int[] previousSmaller(int a[]) {
		int ans[] = new int[a.length];
		ArrayDeque<Integer> stack = new ArrayDeque<>();
		for(int i=0;i<a.length;i++) {
			int e = a[i];
			while(!stack.isEmpty() && a[stack.peek()] >= e) {
				stack.pop();
			}
			if(stack.isEmpty()) {
				ans[i] = -1;
			}else {
				ans[i] = stack.peek();
			}
			stack.push(i);
		}
		return ans;
	}
	static int[] nextSmaller(int a[]) {
		int ans[] = new int[a.length];
		ArrayDeque<Integer> stack = new ArrayDeque<>();
		for(int i=a.length-1;i>=0;i--) {
			int e = a[i];
			while(!stack.isEmpty() && a[stack.peek()] >= e) {
				stack.pop();
			}
			if(stack.isEmpty()) {
				ans[i] = a.length;
			}else {
				ans[i] = stack.peek();
			}
			stack.push(i);
		}
		return ans;
	}
	static int maximumAreaHistogramOptimized(int a[]){
		int ps[] = previousSmaller(a);
		int ns[] = nextSmaller(a);
		
		int max=0;
		for(int i=0; i<a.length;i++) {
			int width = ns[i]-ps[i]-1;
			int curArea = width * a[i];
			max = Math.max(max, curArea);
		}
		return max;
	}
	
}
