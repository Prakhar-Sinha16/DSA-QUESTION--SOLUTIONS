gfg link: https://practice.geeksforgeeks.org/problems/5877fde1c8e1029658845cd4bc94066ac1d4b09b/1

QUES:
You are given an array arr of n integers. For each index i, you have to find the sum of all integers present in the array with a value less than arr[i].

Example 1:

Input:
n = 3
arr = {1, 2, 3}
Output:
0 1 3
Explanation:
For 1, there are no elements lesser than itself.
For 2, only 1 is lesser than 2.
And for 3, 1 and 2 are lesser than 3, so the sum is 3.
Example 2:

Input:
n = 2
arr = {4, 4}
Output:
0 0
Explanation:
For 4, there are no elements lesser than itself. 
For 4, there are no elements lesser than itself.
There are no smaller elements than 4.
Your Task:
You don't need to read input or print anything. Your task is to complete the function smallerSum() which takes an integer n and an array arr and returns an array of 
length n , the answer for every index.

Expected Time Complexity:O(n log n)
Expected Space Complexity:O(n)

Constraints:
1 <= n <= 105
0 <= arr[i] <= 109
  
CODE:
class Solution{
    public long[] smallerSum(int n,int a[]){
        long ans[] = new long[n];
        long sum = 0;
        int b[] = a.clone(); //This will copy array a[] to array b[]
        HashMap<Integer,Long> map = new HashMap<>();
        Arrays.sort(b);
        for(int i=0;i<n;i++){
            if(!map.containsKey(b[i])){
                map.put(b[i], sum);
            }
            sum = sum + b[i];
        }

        for(int i=0;i<n;i++){
            ans[i] = map.get(a[i]);
        }
        return ans;
    }
}
