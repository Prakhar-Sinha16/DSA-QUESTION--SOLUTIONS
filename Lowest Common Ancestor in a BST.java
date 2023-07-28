gfg link: https://practice.geeksforgeeks.org/problems/lowest-common-ancestor-in-a-bst/1

QUES:
Given a Binary Search Tree (with all values unique) and two node values n1 and n2 (n1!=n2). Find the Lowest Common Ancestors of the two 
nodes in the BST.

Example 1:

Input:
              5
            /   \
          4      6
         /        \
        3          7
                    \
                     8
n1 = 7, n2 = 8
Output: 7
Example 2:

Input:
     2
   /   \
  1     3
n1 = 1, n2 = 3
Output: 2
Your Task:
You don't need to read input or print anything. Your task is to complete the function LCA() which takes the root Node of the BST and two 
integer values n1 and n2 as inputs and returns the Lowest Common Ancestor of the Nodes with values n1 and n2 in the given BST. 

Expected Time Complexity: O(Height of the BST).
Expected Auxiliary Space: O(Height of the BST).

Constraints:
1 <= N <= 104

CODE:
class BST{   
    //Function to find the lowest common ancestor in a BST. 
	Node LCA(Node root, int n1, int n2){
        // code here.
        if(root == null) return null;
        if(root.data == n1 || root.data == n2) return root;
        
        Node left = LCA(root.left,n1,n2);
        Node right = LCA(root.right,n1,n2);
        
        if(left == null) return right;
        if(right == null) return left;
        
        return root;
    }
    
}
