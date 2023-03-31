gfg link : https://practice.geeksforgeeks.org/problems/search-in-a-rotated-array4618/1?page=2&curated[]=1&sortBy=submissions

QUES:
Given a sorted and rotated array A of N distinct elements which is rotated at some point, and given an element key. The task is to find the index of the given element key in the array A. The whole array A is given as the range to search.

Example 1:

Input:
N = 9
A[] = {5, 6, 7, 8, 9, 10, 1, 2, 3}
key = 10
l = 0 , h = 8
Output:
5
Explanation: 10 is found at index 5.
Example 2:

Input:
N = 4
A[] = {3, 5, 1, 2}
key = 6
l = 0 , h = 3
Output:
-1
Explanation: There is no element that has value 6.
Your Task:
Complete the function search() which takes an array arr[] and start, end index of the array and the K as input parameters, and returns the answer.

Can you solve it in expected time complexity?

Expected Time Complexity: O(log N).
Expected Auxiliary Space: O(1).

Constraints:
1 ≤ N ≤ 107
0 ≤ A[i] ≤ 108
1 ≤ key ≤ 108
  
CODE:
class Solution
{
    int search(int a[], int l, int r, int key)
    {
        // l: The starting index
        // h: The ending index, you have to search the key in this range
        // Complete this function
        l=0;
        r=a.length-1;
        while(l<=r){
            int mid= (l+r)/2;
            if(a[mid]==key)return mid;
            if(a[l] <= a[mid]){
                if(key >= a[l] && key < a[mid]){
                    r=mid-1;
                }else{
                    l=mid+1;
                }
            }else{
                if(key > a[mid] && key <= a[r]){
                    l=mid+1;
                }else{
                    r=mid-1;
                }
            }
        }
        return -1;
    }
}
