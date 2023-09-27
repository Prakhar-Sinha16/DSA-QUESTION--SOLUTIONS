gfg link: https://practice.geeksforgeeks.org/problems/find-the-closest-pair-from-two-arrays4215/1

QUES:
Given two sorted arrays arr and brr and a number x, find the pair whose sum is closest to x and the pair has an element from each array. In the case of multiple closest pairs return any one of them.

Note: Can return the two numbers in any manner.

Example 1:

Input: N-4, M-4

arr[1-(1, 4, 5, 7)

brr[1-(10, 20, 30, 40)

X-32

Output:

1,30

Explanation:

The closest pair whose sum is closest to 32 is (1, 30) = 31.

Example 2:

Input: N- 4, M-4 arr[1-(1,4,5,7) brrl] (10, 20, 30, 40) X = 50

Output: 7,40

Explanation:

The closest pair whose sum is closest to 50 is (7, 40) = 47.

CODE:
class Solution{
    // Function for finding maximum and value pair
    public static ArrayList<Integer> printClosest (int arr[], int brr[], int n, int m, int x) {
        // code here
        int min = Integer.MAX_VALUE;
        int i = 0;
        int j = m - 1;
        int a = -1, b = -1;
        while(i<n && j>=0){
            int sum = arr[i] + brr[j];
            int diff = Math.abs(x - sum);
            if(diff < min){
                min = diff;
                a = arr[i];
                b = brr[j];
            }
            if(sum > x)
            j--;
            else if(sum < x)
            i++;
            else
            break;
        }
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(a);
        ans.add(b);
        return ans;
    }
}
