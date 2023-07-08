gfg link: https://practice.geeksforgeeks.org/problems/find-triplets-with-zero-sum/1

QUES:

Menu


Find triplets with zero sum
BasicAccuracy: 25.81%Submissions: 262K+Points: 1
POTD July Placement Special : All POTD in the month of July are based on popular interview questions. Solve every day to ace the upcoming Placement Season !
Given an array arr[] of n integers. Check whether it contains a triplet that sums up to zero. 

Note: Return 1, if there is at least one triplet following the condition else return 0.

Example 1:

Input: n = 5, arr[] = {0, -1, 2, -3, 1}
Output: 1
Explanation: 0, -1 and 1 forms a triplet
with sum equal to 0.
Example 2:

Input: n = 3, arr[] = {1, 2, 3}
Output: 0
Explanation: No triplet with zero sum exists. 

Your Task:
You don't need to read input or print anything. Your task is to complete the boolean function findTriplets() which takes the array arr[] and the size of the array (n) as inputs and print 1 if the function returns true else print 0 if the function returns false. 

Expected Time Complexity: O(n2)
Expected Auxiliary Space: O(1)

Constrains:
1 <= n <= 104
-106 <= Ai <= 106

CODE:
class Solution{
    // arr[]: input array
    // n: size of the array
    //Function to find triplets with zero sum.
	public boolean findTriplets(int a[] , int n){
        //add code here.
        Arrays.sort(a);
        for(int i=0; i<n-2; i++){
            if(twoSum(a,-a[i],i+1)) return true;
        }
        return false;
    }
    
    public boolean twoSum(int a[], int x, int i){
        int j = a.length-1;
        
        while(i < j){
            int curSum = a[i] + a[j];
            
            if(curSum == x) return true;
            
            else if(x > curSum) i++;
            
            else j--;
        }
        return false;
    }
}
