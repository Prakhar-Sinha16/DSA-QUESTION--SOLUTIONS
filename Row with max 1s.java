gfg link: https://practice.geeksforgeeks.org/batch/gts-1/track/GTS-MATRIX/problem/row-with-max-1s0023

QUES:
Given a boolean 2D array of n x m dimensions where each row is sorted. Find the 0-based index of the first row that has the maximum number of 1's.

Example 1:

Input: 
N = 4 , M = 4
Arr[][] = {{0, 1, 1, 1},
           {0, 0, 1, 1},
           {1, 1, 1, 1},
           {0, 0, 0, 0}}
Output: 2
Explanation: Row 2 contains 4 1's (0-based
indexing).

Example 2:

Input: 
N = 2, M = 2
Arr[][] = {{0, 0}, {1, 1}}
Output: 1
Explanation: Row 1 contains 2 1's (0-based
indexing).

Your Task:  
You don't need to read input or print anything. Your task is to complete the function rowWithMax1s() which takes the array of booleans arr[][], n and m as input parameters and returns the 0-based index of the first row that has the most number of 1s. If no such row exists, return -1.
 

Expected Time Complexity: O(N+M)
Expected Auxiliary Space: O(1)


Constraints:
1 ≤ N, M ≤ 103
0 ≤ Arr[i][j] ≤ 1 

CODE:
class Solution {
    int firstOccurence(int a[], int n, int key){
        int l=0, r=n-1;
        int ans =n;
        while(l <= r){
            int mid = (l+r)/2;
            if(a[mid] >= key){
                ans = mid;
                r = mid-1;
            }
            else l=mid+1;
        }
        return ans;
    }
    int rowWithMax1s(int a[][], int n, int m) {
        // code here
        int cnt_max =0;
        int index = -1;
        for(int i=0; i<n; i++){
            int cnt_one = m - firstOccurence(a[i],m,1);
            if(cnt_one > cnt_max){
                cnt_max = cnt_one;
                index =i;
            }
        }
        return index;
    }
}
