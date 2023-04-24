gfg link: https://practice.geeksforgeeks.org/problems/a520c08a8ea9b617be25c38b0fc2fe057e889253/1
QUES: Given an array where each element (arr[i]) represents the height of the tower. Find for each tower, the nearest possible tower that is shorter than it. 
You can look left or right on both sides.
Note : 

If two smaller towers are at the same distance, pick the smallest tower.

If two towers have the same height then we choose the one with a smaller index.

Example 1:

Input: 
arr[] = {1,3,2}
Output: 
{-1,0,0}
Explanation:
For 0th Index : no tower is smallest, so -1.
For 1st Index : For 3, here 1 & 2 both are 
small & at a same distance, so we will pick 1, 
beacuse it has smallest value, so 0(Index)
For 2nd Index : here 1 is smaller, so 0(Index)
So the final output will be which consistes 
Indexes are {-1,0,0}.
Example 2:

Input: 
arr[] = {4,8,3,5,3}
Output: 
{2,2,-1,2,-1}

Explanation: 
For 0th Index : here 3 is the smaller, so 2(Index) 
For 1st Index : For 8, here 4 & 3 both are
small & at a same distance, so we will pick 3, so 2(Index)
For 2nd Index : no tower is smallest, so -1.
For 3rd Index : For 5, here 3 & 3 both are
small & at a same distance, so we will pick 
3(2nd Index) because it smaller Index, so 2(Index)
For 4th Index : no tower is smallest, so -1.
So the final output will be which consistes
Indexes are {2,2,-1,2,-1}.
Your Task:
You don't need to read input or print anything. Your task is to complete the function nearestSmallerTower() which takes an array of heights of the towers as input 
parameter and returns an array of indexes of the nearest smaller tower. If there is no smaller tower on both sides then return -1 for that tower.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N) 

Constraints:
1 <= N <= 105
1 <= arr[i] <= 105
  
CODE:
class Solution{
	int [] nearestSmallestTower(int [] arr){
		//Write your code here
		int n = arr.length;
        int[] left = new int[n];    // Array to store the index of the nearest smaller tower on the left
        int[] right = new int[n];   // Array to store the index of the nearest smaller tower on the right
        Arrays.fill(left, -1);      // Initialize all elements of the 'left' array to -1
        Arrays.fill(right, -1);     // Initialize all elements of the 'right' array to -1

        Stack<Integer> stack = new Stack<>();  // Create a stack to store the indices of towers
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                // Pop elements from the stack until the top element is smaller than the current tower
                stack.pop();    
            }
            if (!stack.isEmpty()) {
                // The index of the nearest smaller tower on the left is the top element of the stack
                left[i] = stack.peek(); 
            }
            stack.push(i);  // Push the index of the current tower onto the stack
        }

        stack.clear();  // Clear the stack for re-use
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                // Pop elements from the stack until the top element is smaller than the current tower
                stack.pop();    
            }
            if (!stack.isEmpty()) {
                // The index of the nearest smaller tower on the right is the top element of the stack
                right[i] = stack.peek();    
            }
            stack.push(i);  // Push the index of the current tower onto the stack
        }

        int[] result = new int[n];  // Array to store the final result
        for (int i = 0; i < n; i++) {
             // Distance between the current tower and the nearest smaller tower on the left
            int leftDist = left[i] == -1 ? Integer.MAX_VALUE : i - left[i]; 
            // Distance between the current tower and the nearest smaller tower on the right
            int rightDist = right[i] == -1 ? Integer.MAX_VALUE : right[i] - i;    
            /* If the nearest smaller tower on the left is closer or has equal distance but is 
            smaller or equal in height, set it as the result*/
            if (leftDist < rightDist || (leftDist == rightDist && left[i] != -1 && arr[left[i]] <= arr[right[i]])) {
                result[i] = left[i];    
            } else 
            /* If the nearest smaller tower on the right is closer or has equal distance but is 
            smaller in height, set it as the result*/
            
            if (leftDist > rightDist || (leftDist == rightDist && right[i] != -1 && arr[right[i]] < arr[left[i]])) {
                result[i] = right[i];   
            } else {
                result[i] = -1; // If there is no smaller tower on both sides, set the result as -1
            }
        }
        return result;  // Return the final result array

	}
}
