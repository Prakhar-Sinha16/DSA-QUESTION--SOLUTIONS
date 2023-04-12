gfg link: https://practice.geeksforgeeks.org/problems/2a1c11024ceae36363fc405e07f2fa3e2f896ef0/1

QUES:
You are given an array of integers of size n where n being even.. You have to calculate the number of dominate pairs (i,j) . Where a pair is called dominant if 
( 0<=i<n/2, n/2<=j<n, arr[i]>=5*arr[j] ) these relation are fulfilled.  For example  in arr=[10,3,3,1] index i=0, j=3 form a dominating pair

Note : 0 based indexing is used  and n is even 

Example 1:

Input:
n=4
arr={10,2,2,1}
Output:
2
Explanation:
As we can see index i=0 and j=2 where
arr[0]>=5*arr[2] (10>=5*2)is fulfilled so
this forms a dominant pair and in same
manner index i=0 and j=3 forms dominant
pair.So total 2 dominant pairs.
Example 2:

Input:
n=6
arr={10,8,2,1,1,2}
Output:
5
Explanation:
As we can see index i=0 and j=3 where
arr[0]>=5*arr[3] (10>=5*1) is fulfilled so
this forms a dominant pair and in same
manner (0,4),(0,5),(1,3),(1,4) also form
dominant pair.So total 5 dominant pairs.
Your Task:
You don't need to read input or print anything. Your task is to complete the function dominantPairs() which takes an integer n and an array of integers arr 
respectively and returns the count of dominate pairs.

Expected Time Complexity: O(nlogn)
Expected Auxiliary Space: O(1)

Constraints:
1 <= n<= 10^4
-10^4<=arr[i]<= 10^4
The sum of n over all test cases won't exceed 10^6
  
CODE:
class Solution {
    public static int dominantPairs(int n, int[] arr) {
        // code here
        int i=0;
        int j=n/2;
        Arrays.sort(arr,0,j);
        Arrays.sort(arr,j,n);
        int ans=0;
        
        while(i<n/2 && j<n){
            if(arr[i]>=5*arr[j]){
                ans=ans+n/2-i;
                j++;
            }else{
                i++;
            }
        }
        return ans;
    }
}

//one more easy and nive approach:
        // int ans=0;
        // for(int i=0;i<n/2;i++){
        //     for(int j=n/2;j<n;j++){
        //         if(arr[i]>=5*arr[j]) ans++;
        //         else
        //         continue;
        //     }
        // }
        // return ans;
