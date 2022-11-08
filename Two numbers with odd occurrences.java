gfg link=> https://practice.geeksforgeeks.org/problems/two-numbers-with-odd-occurrences5846/1

//QUES: Given an unsorted array, Arr[] of size N and that contains even number of occurrences for all numbers except two numbers. Find the two numbers in decreasing order which has odd occurrences.

// Example 1:

// Input:
// N = 8
// Arr = {4, 2, 4, 5, 2, 3, 3, 1}
// Output: {5, 1} 
// Explaination: 5 and 1 have odd occurrences.

// Example 2:

// Input:
// N = 8
// Arr = {1 7 5 7 5 4 7 4}
// Output: {7, 1}
// Explaination: 7 and 1 have odd occurrences.

// Your Task:
// You don't need to read input or print anything. Your task is to complete the function twoOddNum() which takes the array Arr[] and its size N as input parameters and returns the two numbers in decreasing order which have odd occurrences.


// Expected Time Complexity: O(N)
// Expected Auxiliary Space: O(1)


// Constraints:
// 2 ≤ N ≤ 106
// 1 ≤ Arri ≤ 1012

//CODE:
class Solution{
    public int[] twoOddNum(int a[], int N){
        // code here
        ArrayList<Integer>list=new ArrayList<>();
		Map<Integer,Integer> map = new HashMap<>();
		int[] ans= new int[2];
		for(int e : a){
			if(map.containsKey(e)) {
				int temp = map.get(e);
				map.put(e, temp+1);
			}else
			map.put(e, 1);
		}
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if((entry.getValue()%2)!=0) {
				list.add(entry.getKey());
			}
		}
		Collections.sort(list);
		ans[0]=list.get(1);
		ans[1]=list.get(0);
        return ans;
    }
}
