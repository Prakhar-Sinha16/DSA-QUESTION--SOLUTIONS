gfg link: https://practice.geeksforgeeks.org/problems/maximum-index3307/1

QUES:
Given an array arr[] of n positive integers. The task is to find the maximum of j - i subjected to the constraint of arr[i] <= arr[j].

Example 1:

Input:
n = 9
arr[] = {34, 8, 10, 3, 2, 80, 30, 33, 1}
Output: 
6
Explanation: 
In the given array arr[1] < arr[7]  satisfying 
the required condition (arr[i] <= arr[j])  thus 
giving the maximum difference of j - i which is
6(7-1).
Example 2:

Input:
N = 2
arr[] = {18, 17}
Output: 
0
Explanation: 
We can either take i and j as 0 and 0 
or we cantake 1 and 1 both give the same result 0.
Your Task:
Complete the function maxIndexDiff() which takes array arr and size n, as input parameters and returns an integer representing the answer.
You don't to print answer or take inputs. 

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)

Constraints:
1 ≤ N ≤ 106
0 ≤ Arr[i] ≤ 109

CODE:
class Solution {

    int maxIndexDiff(int a[], int n) {
        // code here
        int rightMax[] = new int[n];
        int leftMin[] = new int[n];
        
        rightMax[n-1] = a[n-1];
        for(int i=n-2; i>=0; i--){
            rightMax[i] = Math.max(rightMax[i+1], a[i]);
        }
        
        leftMin[0] = a[0];
        for(int i=1; i<n; i++){
            leftMin[i] = Math.min(leftMin[i-1], a[i]);
        }
        
        int i=0,j=0,ans=0;
        while(i<n && j<n){
            if(leftMin[i] <= rightMax[j]){
                ans = Math.max(ans, j-i);
                j++;
            }else{
                i++;
            }
        }
        return ans;
    }
}
