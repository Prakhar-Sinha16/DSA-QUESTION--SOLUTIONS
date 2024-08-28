Difficulty: Hard
QUES: Given an array arr[] of N elements and a number K., split the given array into K subarrays such that the maximum subarray sum achievable out of K subarrays formed is minimum possible. Find that possible subarray sum.

Example 1:

Input:
N = 4, K = 3
arr[] = {1, 2, 3, 4}
Output: 4
Explanation:
Optimal Split is {1, 2}, {3}, {4}.
Maximum sum of all subarrays is 4,
which is minimum possible for 3 splits. 
Example 2:

Input:
N = 3, K = 2
A[] = {1, 1, 2}
Output:
2
Explanation:
Splitting the array as {1,1} and {2} is optimal.
This results in a maximum sum subarray of 2.
Your Task:
You do not have to take any input or print anything. The task is to complete the function splitArray() which returns the maximum sum subarray after splitting the array into K subarrays such that maximum sum subarray is minimum possible.

Expected Time Complexity: O(N*log(sum(arr))).
Expected Auxiliary Space: O(1).

Constraints:
1 ≤ N ≤ 105
1 ≤ K ≤ N
1 ≤ arr[i] ≤ 104

CODE:

//This could be one approach by using PriorityQueue
import java.util.*;
public class Main
{
	public static void main(String[] args) {
	    int a[] = {1,1,2};
	    int k=2;
		System.out.println(splitArray(a,k));
	}
	static int splitArray(int[] a , int k) {
        // code here
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<k; i++){
            pq.offer(0);
        }
        Arrays.sort(a);
        for(int i=a.length-1; i>=0; i--){
            int cur = a[i];
            int top = pq.poll();
            int toAdd = cur + top;
            pq.offer(toAdd);
        }
        int max = -1;
        for(int e : pq){
            max = Math.max(max, e);
        }
        return max;
    }
}
