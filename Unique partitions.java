gfg link => https://practice.geeksforgeeks.org/problems/unique-partitions1041/1

//QUES: Given a positive integer n, generate all possible unique ways to represent n as sum of positive integers.

// Note: The generated output is printed without partitions. Each partition must be in decreasing order. Printing of all the partitions is done in reverse sorted order. 

// Example 1:

// Input: n = 3
// Output: 3 2 1 1 1 1
// Explanation: For n = 3, 
// {3}, {2, 1} and {1, 1, 1}.
 
// Example 2:

// Input: n = 4 
// Output: 4 3 1 2 2 2 1 1 1 1 1 1
// Explanation: For n = 4, 
// {4}, {3, 1}, {2, 2}, {2, 1, 1}, {1, 1, 1, 1}.

// Your Task:
// You don't need to read or print anything. Your task is to complete the function UniquePartitions() which takes n as input parameter and returns a list of all possible combinations in lexicographically decreasing order. 
 
// Expected Time Complexity: O(2^n)
// Expected Space Complexity: O(n)

// Constraints:
// 1 <= n <= 25

//CODE:
class Solution{
    public ArrayList<ArrayList<Integer>> UniquePartitions(int n){
        // Code here
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        util(n,n,ans,temp);
        return ans;
    }
    public void util(int n,int m,ArrayList<ArrayList<Integer>>ans,ArrayList<Integer>temp){
        if(n==0){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i=m;i>=1;i--){
            if(n-i>=0){
                temp.add(i);
                util(n-i,i,ans,temp);
                temp.remove((Integer)i);
            }
        }
    }
}
