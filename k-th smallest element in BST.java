gfg link => https://practice.geeksforgeeks.org/problems/find-k-th-smallest-element-in-bst/1

//QUES: 
// Given a BST and an integer K. Find the Kth Smallest element in the BST using O(1) extra space. 

// Example 1:

// Input:
//       2
//     /   \
//    1     3
// K = 2
// Output: 2
// Explanation: 2 is the 2nd smallest element in the BST

// Example 2:

// Input:
//         2
//       /  \
//      1    3
// K = 5
// Output: -1
// Explanation: There is no 5th smallest element in the BST as the size of BST is 3
 

// Your Task:
// You don't need to read input or print anything. Your task is to complete the function KthSmallestElement() which takes the root of the BST and integer K as inputs and return the Kth smallest element in the BST, if no such element exists return -1.

// Expected Time Complexity: O(N).
// Expected Auxiliary Space: O(1).

// Constraints:
// 1<=Number of nodes<=100000
  
  //CODE:
  // User function Template for Java

// class Node
// {
//     int data;
//     Node left, right;

//           public Node(int d)
//     {
//         data = d;
//         left = right = null;
//     }
// }

class Solution {
    // Return the Kth smallest element in the given BST
    public int KthSmallestElement(Node root, int k) {
        // Write your code here
        ArrayList<Integer>al = new ArrayList<>();
        InOrder(root,al);
        if(k>al.size()) return -1;
        int ans = al.get(k-1);
        return ans;
    }
    
    void InOrder(Node root,ArrayList<Integer>al){
        if(root == null) return;
        InOrder(root.left,al);
        al.add(root.data);
        InOrder(root.right,al);
    }
}
