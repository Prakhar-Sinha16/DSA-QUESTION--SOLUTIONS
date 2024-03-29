gfg link: https://practice.geeksforgeeks.org/problems/arranging-the-array1131/1

QUES:
You are given an array of size N. Rearrange the given array in-place such that all the negative numbers occur before all non-negative 
numbers.
(Maintain the order of all -ve and non-negative numbers as given in the original array).

Example 1:

Input:
N = 4
Arr[] = {-3, 3, -2, 2}
Output:
-3 -2 3 2
Explanation:
In the given array, negative numbers
are -3, -2 and non-negative numbers are 3, 2. 
Example 2:

Input:
N = 4
Arr[] = {-3, 1, 0, -2}
Output:
-3 -2 1 0
Explanation:
In the given array, negative numbers
are -3, -2 and non-negative numbers are 1, 0.
Your Task:  
You don't need to read input or print anything. Your task is to complete the function Rearrange() which takes the array Arr[] and its 
size N as inputs and returns the array after rearranging with spaces between the elements of the array.

Expected Time Complexity: O(N. Log(N))
Expected Auxiliary Space: O(Log(N))

Constraints:
1 ≤ N ≤ 105
-109 ≤ Elements of array ≤ 109
  
CODE:
class Solution {
    
    public void Rearrange(int a[], int n)
    {
        // Your code goes here
        ArrayList<Integer> a1 = new ArrayList<>();
        ArrayList<Integer> a2 = new ArrayList<>();
        
        for(int i=0; i<a.length; i++){
            if(a[i] < 0) a1.add(a[i]);
            else a2.add(a[i]);
        }
        
        for(int i=0; i<a1.size(); i++){
            a[i]=a1.get(i);
        }
        for(int i=a1.size(); i<a1.size()+a2.size(); i++){
            a[i]=a2.get(i-a1.size());
        }
    }
}
