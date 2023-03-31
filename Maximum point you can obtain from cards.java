gfg link: https://practice.geeksforgeeks.org/problems/maximum-point-you-can-obtain-from-cards/1

There are several cards arranged in a row, and each has an associated number of points. The points are given in the integer array cardPoints of size N.
In one step, you can take one card from beginning or from the end of the row. You have to take exactly k cards.
Your score is the sum of the points of the cards you have taken.
Given the integer array cardPoints, and its size N and the integer k, return the maximum score you can obtain.

Example 1:

Input:
N = 7
k = 3
cardPoints[ ] = {1, 2, 3, 4, 5, 6, 1}
Output: 12
Explanation: After the first step, your score will always be 1. However, choosing the rightmost card first will maximize your total score. The optimal strategy is to take the cards on the right, giving a final score of 1 + 6 + 5 = 12.
 

Example 2:

Input:
N = 5
k = 5
arr[ ] = {8, 6, 2, 4, 5}
Output: 25
Explanation: You have to take all the cards. Your score is the sum of points of all cards.
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function maxScore() which takes the array of integers cardPoints , an integer N and k as parameters and returns a maximum score.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ N ≤ 105
1 ≤ k ≤ N
1 ≤ cardPointsi  ≤ 105
  
CODE:
class Solution {
    static long maxScore(int a[], int N, int k) {
        // code here
        int total=0;
        for(int i=0;i<k;i++){
            total += a[i];
        }
        
        int best=total;
        for(int i=k-1,j=a.length-1;i>=0;i--,j--){
            total = total + a[j] - a[i];
            best = Math.max(total, best);
        }
        return best;
    }
}
