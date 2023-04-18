gfg link: https://practice.geeksforgeeks.org/problems/d064cc0468a5c2bb7817ecd7c1bc59ce25e23613/1

QUES:
Given a binary tree and a target, find the number of node in the minimum sub-tree with the given sum equal to the target which is also a binary search tree.

Example 1:

Input:
           13
         /    \
       5       23
      / \      / \
     N   17   N   N
         /
        16
Target: 38
Output: 3
Explanation: 5,17,16 is the smallest subtree
with length 3.
 

Example 2:

Input:
             7
           /   \
          N    23
             /   \
            10    23
           /  \   / \
          N   17 N   N
Target: 73
Output: -1
Explanation: No subtree is bst for the given target.
Your Task:  
You don't need to read input or print anything. Your task is to complete the function minSubtreeSumBST() which takes the tree root and target as input parameters which
is a binary Tree and returns the length of the minimum subtree having a sum equal to the target but which is a binary search tree.

Expected Time Complexity: O(N), where N is no. of nodes
Expected Space Complexity: O(h), where h is the height of the tree

Constraints:
1 <= N <= 10^5

CODE:
/*

Definition for Binary Tree Node
class Node
{
    int data;
    Node left;
    Node right;

    Node(int data)
    {
        this.data = data;
        left = null;
        right = null;
    }
}
*/


class Solution {
    static int ans = Integer.MAX_VALUE; //track of the minimum size of the subtree
    
    public static int minSubtreeSumBST(int target, Node root) {
        ans = Integer.MAX_VALUE; // reset the inctance variable
        find(target, root); // find the minimum size of the subtree
        return ans == Integer.MAX_VALUE ? -1 : ans; // if ans is still Integer.MAX_VALUE, it means no subtree was found
    }
    
    public static void find(int target, Node root) {
        if (root == null) return; // base case
        
        int sum = sum(root); // calculate the sum of the current subtree
        if (sum == target && isBST(root)) { // if the sum is equal to target and the current subtree is a BST
            ans = Math.min(ans, size(root)); // update the global variable with the minimum size
        }
        
        find(target, root.left); // recursively find in left subtree
        find(target, root.right); // recursively find in right subtree
    }
    
    private static int sum(Node root) { // helper method to calculate the sum of a subtree
        if (root == null) return 0;
        return root.data + sum(root.left) + sum(root.right);
    }
    
    private static int size(Node root) { // helper method to calculate the size of a subtree
        if (root == null) return 0;
        return 1 + size(root.left) + size(root.right);
    }
    
    private static boolean isBST(Node root) { // helper method to check if a subtree is a BST
        return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    private static boolean isBSTUtil(Node node, int min, int max) { // utility method for checking if a subtree is a BST
        if (node == null) return true;
        
        if (node.data < min || node.data > max) return false;
        
        return isBSTUtil(node.left, min, node.data - 1)
            && isBSTUtil(node.right, node.data + 1, max);
    }
}
