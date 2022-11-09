gfg link=> https://practice.geeksforgeeks.org/problems/minimum-sum-partition3317/1

//QUES: Given an array arr of size n containing non-negative integers, the task is to divide it into two sets S1 and S2 such that the absolute difference between their sums is minimum and find the minimum difference

// Example 1:

// Input: N = 4, arr[] = {1, 6, 11, 5} 
// Output: 1
// Explanation: 
// Subset1 = {1, 5, 6}, sum of Subset1 = 12 
// Subset2 = {11}, sum of Subset2 = 11   
// Example 2:
// Input: N = 2, arr[] = {1, 4}
// Output: 3
// Explanation: 
// Subset1 = {1}, sum of Subset1 = 1
// Subset2 = {4}, sum of Subset2 = 4

// Your Task:  
// You don't need to read input or print anything. Complete the function minDifference() which takes N and array arr as input parameters and returns the integer value


// Expected Time Complexity: O(N*|sum of array elements|)
// Expected Auxiliary Space: O(N*|sum of array elements|)


// Constraints:
// 1 ≤ N*|sum of array elements| ≤ 106
// 0 < arr[i] <= 105

//CODE:
class Solution{

	public int minDifference(int a[], int n) { 
	    // Your code goes here
	    Map<String,Integer> map = new HashMap<>();
	    return dfs(a,n-1,0,0,map);
	}
	int dfs(int a[],int n,int s1,int s2,Map<String,Integer>map){
	    if(n<0)return Math.abs(s1-s2);
	    
	    String k = n+","+s1;
	    if(!map.containsKey(k)){
	        int first=dfs(a,n-1,s1+a[n],s2,map);
	        int sec=dfs(a,n-1,s1,s2+a[n],map);
	        map.put(k,Math.min(first,sec));
	    }
	    return map.get(k);
	}
}
