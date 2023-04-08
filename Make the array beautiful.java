gfg link: https://practice.geeksforgeeks.org/problems/badefd58bace4f2ca25267ccfe0c9dc844415e90/1

QUES:
Given an array of negative and non-negative integers. You have to make the array beautiful. An array is beautiful if two adjacent integers, arr[i] and arr[i+1] are either negative or non-negative. And you can do the following operation any number of times until the array becomes beautiful.

If two adjacent integers are different i.e. one of them is negative and other is non-negative, remove them.
Return the beautiful array after performing the above operation.

Note:An empty array is also a beautiful array. There can be many adjacent integers which are different as stated above. So remove different adjacent integers as described above from left to right.

Example 1:

Input: 4 2 -2 1
Output: 4 1
Explanation: As at indices 1 and 2 , 2 and -2 have
different sign, they are removed. And the  the final
array is: 4 1.
Example 2:

Input: 2 -2 1 -1
Output: []
Explanation: As at indices 0 and 1, 2 and -2 have
different sign, so they are removed. Now the array
is 1 -1.Now 1 and -1 are also removed as they have
different sign. So the final array is empty. 
Your Task:
You don't need to read input or print anything. Your task is to complete the function makeBeautiful() which takes an array as an input parameter and returns an array.

Expected Time Complexity: O(N)
Expected Space Complexity: O(N)


Constraints:
1 <= size of the array <= 105
-105 <= arr[i] <= 105

CODE:
class Solution {
    public static ArrayList<Integer> makeBeautiful(int[] arr) {
        // code here
        Stack<Integer> stack = new Stack<>();
        
        // Iterate over the input array
        for(int num : arr) {
            // If the stack is empty, push the integer onto the stack
            if(stack.empty()) {
                stack.push(num);
            } else {
                // If the integer has a different sign than the top of the stack, pop the top element
                if((stack.peek() >= 0 && num < 0) || (stack.peek() < 0 && num >= 0)) {
                    stack.pop();
                } else {
                    // Otherwise, push the integer onto the stack
                    stack.push(num);
                }
            }
        }
        
        // Create a new ArrayList to store the result
        ArrayList<Integer> result = new ArrayList<>();
        
        // Pop the elements from the stack and add them to the result ArrayList
        while(!stack.empty()) {
            result.add(stack.peek());
            stack.pop();
        }
        
        // Reverse the order of the elements in the result ArrayList
        Collections.reverse(result);
        
        // Return the result ArrayList
        return result;
    }
}
