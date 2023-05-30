gfg link: https://practice.geeksforgeeks.org/problems/frequency-game/1

QUES:
Given an array A of size N. The elements of the array consist of positive integers. You have to find the largest element with minimum 
frequency.

Example 1:

Input: 
5
2 2 5 50 1
Output:
50
Explanation :
All elements are having frequency 1 except 2.
50 is the maximum element with minimum frequency.
Example 2:

Input:
4
3 3 5 5
Output:
5
Explanation:
Both 3 and 5 have the same frequency, so 5 should be returned.
User Task:
Your task is to complete the provided function LargButMinFreq(A, n) which accepts array A and n. Hence you have to return the largest 
element with minimum frequency.

Expected Time Complexity: O(N)
Expected Space Complexity: O(N)

Constraints:
1 <= N <= 105
1 <= A[i] <= 106
  
CODE:
class Solution {
    public static int LargButMinFreq(int arr[], int n) {
        HashMap<Integer, Integer> map=new HashMap<>();
        int minFreqCount=Integer.MAX_VALUE;
        int maxNumber=0;
        for(int ele:arr)map.put(ele,map.getOrDefault(ele,0)+1);
        for(int key:map.keySet()){
            int freq=map.get(key);
            if(freq<minFreqCount || (freq==minFreqCount&&maxNumber<key)){
                minFreqCount=freq;
                maxNumber=key;
            }
        }
        return maxNumber;
    }
}
