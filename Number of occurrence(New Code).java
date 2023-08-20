gfg link: https://practice.geeksforgeeks.org/problems/number-of-occurrence2259/1

QUES:

Given a sorted array Arr of size N and a number X, you need to find the number of occurrences of X in Arr.

Example 1:

Input:
N = 7, X = 2
Arr[] = {1, 1, 2, 2, 2, 2, 3}
Output: 4
Explanation: 2 occurs 4 times in the
given array.
Example 2:

Input:
N = 7, X = 4
Arr[] = {1, 1, 2, 2, 2, 2, 3}
Output: 0
Explanation: 4 is not present in the
given array.
Your Task:
You don't need to read input or print anything. Your task is to complete the function count() which takes the array of integers arr, n, and x as parameters and returns an integer denoting the answer.
If x is not present in the array (arr) then return 0.

Expected Time Complexity: O(logN)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ N ≤ 105
1 ≤ Arr[i] ≤ 106
1 ≤ X ≤ 106

CODE:
class Solution {
    int LeftOccurence(int a[], int key){
        int l=0 , r=a.length-1;
        int ans = -1;
        while(l <= r){
            int mid = (l+r)/2;
            if(a[mid] == key){
                ans = mid;
                r=mid-1;
            }
            else if(key > a[mid]) l=mid+1;
            else r=mid-1;
        }
        return ans;
    }
    int RightOccurence(int a[], int key){
        int l=0 , r=a.length-1;
        int ans = -1;
        while(l <= r){
            int mid = (l+r)/2;
            if(a[mid] == key){
                ans = mid;
                l=mid+1;
            }
            else if(key > a[mid]) l=mid+1;
            else r=mid-1;
        }
        return ans;
    }
    int count(int[] a, int n, int x) {
        // code here
        int leftIndex = LeftOccurence(a, x);
        if (leftIndex == -1) {
            return 0; // Element not present in the array
        }
        
        int rightIndex = RightOccurence(a, x);
        
        return rightIndex - leftIndex + 1;
    }
}
