gfg link: https://practice.geeksforgeeks.org/problems/maximum-rectangular-area-in-a-histogram-1587115620/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article

QUES:
Find the largest rectangular area possible in a given histogram where the largest rectangle can be made of a number of contiguous bars. For simplicity, assume that all bars have the same width and the width is 1 unit, there will be N bars height of each bar will be given by the array arr.

Example 1:

Input:
N = 7
arr[] = {6,2,5,4,5,1,6}
Output: 12
Explanation: 


Example 2:

Input:
N = 8
arr[] = {7 2 8 9 1 3 6 5}
Output: 16
Explanation: Maximum size of the histogram 
will be 8  and there will be 2 consecutive 
histogram. And hence the area of the 
histogram will be 8x2 = 16.
Your Task:
The task is to complete the function getMaxArea() which takes the array arr[] and its size N as inputs and finds the largest rectangular area possible and returns the answer.

Expected Time Complxity : O(N)
Expected Auxilliary Space : O(N)

Constraints:
1 ≤ N ≤ 106
0 ≤ arr[i] ≤ 1012
  
CODE:

//OPTIMIZED CODE
class Solution
{
    //Function to find largest rectangular area possible in a given histogram.
    static long[] previousSmaller(long a[]) {
		long ans[] = new long[a.length];
		ArrayDeque<Integer> stack = new ArrayDeque<>();
		for(int i=0; i<a.length;i++) {
			long e = a[i];
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
	static long[]nextSmaller(long a[]) {
		long ans[] = new long[a.length];
		ArrayDeque<Integer> stack = new ArrayDeque<>();
		for(int i=a.length-1; i>=0;i--) {
			long e = a[i];
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
    public static long getMaxArea(long a[], long n) 
    {
        // your code here
        long ps[] = previousSmaller(a);
		long ns[] = nextSmaller(a);
		
		long max=0;
		for(int i=0; i<a.length;i++) {
			long width = ns[i]-ps[i]-1;
			long curArea = width * a[i];
			max = Math.max(max, curArea);
		}
		return max;
        
    }      
}

//BRUTEFORCE CODE
static int maximumAreaInHistogram(int a[]) {
		int n =a.length;
		int max=0;
		for(int i=0; i<n;i++) {
			int l=i, r=i;
			while(l>=0 && a[l]>=a[i]) l--;
			while(r<n && a[r]>=a[i]) r++;
			
			int width = r-l-1;
			int curArea = a[i] * width;
			max = Math.max(max, curArea);
		}
		return max;
	}
