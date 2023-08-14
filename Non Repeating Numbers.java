gfg link: https://practice.geeksforgeeks.org/problems/finding-the-numbers0215/1

QUES:
Given an array A containing 2*N+2 positive numbers, out of which 2*N numbers exist in pairs whereas the other two number occur exactly once and are distinct. Find the other two numbers. Return in increasing order.

Example 1:

Input: 
N = 2
arr[] = {1, 2, 3, 2, 1, 4}
Output:
3 4 
Explanation:
3 and 4 occur exactly once.
Example 2:

Input:
N = 1
arr[] = {2, 1, 3, 2}
Output:
1 3
Explanation:
1 3 occur exactly once.
Your Task:
You do not need to read or print anything. Your task is to complete the function singleNumber() which takes the array as input parameter and returns a list of two numbers which occur exactly once in the array. The list must be in ascending order.

Expected Time Complexity: O(N)
Expected Space Complexity: O(1)

Constraints:
1 <= length of array <= 106 
1 <= Elements in array <= 5 * 106

CODE:
class Solution{
    public int[] singleNumber(int[] nums){
        // Code here
        int xor = 0;
        for (int num : nums) {
            xor ^= num; // XOR of all elements in the array
        }
    
        // Find the rightmost set bit in the XOR result
        int rightmostSetBit = xor & -xor;
    
        int num1 = 0;
        int num2 = 0;
    
        // Divide the numbers into two groups based on the rightmost set bit
        for (int num : nums) {
            if ((num & rightmostSetBit) == 0) {
                num1 ^= num;
            } else {
                num2 ^= num;
            }
        }
    
        return new int[]{Math.min(num1, num2), Math.max(num1, num2)};
    }
}
