gfg link: https://practice.geeksforgeeks.org/batch/gts-1/track/GTS-ARRAY/problem/next-permutation5226\

QUES:
Implement the next permutation, which rearranges the list of numbers into Lexicographically next greater permutation of list of numbers. If such arrangement is not possible, it must be rearranged to the lowest possible order i.e. sorted in an ascending order. You are given an list of numbers arr[ ] of size N.

Example 1:

Input: N = 6
arr = {1, 2, 3, 6, 5, 4}
Output: {1, 2, 4, 3, 5, 6}
Explaination: The next permutation of the 
given array is {1, 2, 4, 3, 5, 6}.
Example 2:

Input: N = 3
arr = {3, 2, 1}
Output: {1, 2, 3}
Explaination: As arr[] is the last 
permutation. So, the next permutation 
is the lowest one.
Your Task:
You do not need to read input or print anything. Your task is to complete the function nextPermutation() which takes N and arr[ ] as input parameters and returns a list of numbers containing the next permutation.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ N ≤ 10000

CODE:
class Solution{
    static List<Integer> nextPermutation(int n, int a[]){
        // code here
        ArrayList<Integer> dupli = new ArrayList<>();
        for(int e : a){
            dupli.add(e);
        }
        int ind=-1;
        
        for(int i=n-2; i>=0; i--){
            if(dupli.get(i) < dupli.get(i+1)){
                ind = i;
                break;
            }
        }
        
        if(ind == -1){
            Collections.reverse(dupli);
            return dupli;
        }
        
        for(int i=n-1; i>ind; i--){
            if(dupli.get(i) > dupli.get(ind)){
                int temp = dupli.get(i);
                dupli.set(i, dupli.get(ind));
                dupli.set(ind, temp);
                break;
            }
        }
        List<Integer> sublist = dupli.subList(ind + 1, n);
        Collections.reverse(sublist);
        return dupli;
    }
}
