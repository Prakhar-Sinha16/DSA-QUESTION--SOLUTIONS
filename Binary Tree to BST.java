gfg link: https://practice.geeksforgeeks.org/problems/binary-tree-to-bst/1

QUES:
Given a Binary Tree, convert it to Binary Search Tree in such a way that keeps the original structure of Binary Tree intact.
 Example 1:

Input:
      1
    /   \
   2     3
Output: 
1 2 3
Explanation:
The converted BST will be 
      2
    /   \
   1     3

Example 2:

Input:
          1
       /    \
     2       3
   /        
 4       
Output: 
1 2 3 4
Explanation:
The converted BST will be

        3
      /   \
    2     4
  /
 1
Your Task:
You don't need to read input or print anything. Your task is to complete the function binaryTreeToBST() which takes the root of the Binary tree as input and returns the root of the BST. The driver code will print inorder traversal of the converted BST.

Expected Time Complexity: O(NLogN).
Expected Auxiliary Space: O(N).

Constraints:
1 <= Number of nodes <= 105

CODE:
/*Structure of the node class is
class Node
{
    int data;
    Node left, right;
    Node(int item){
        data = item;
        left = right = null;
    }
} */


class Solution
{
    // The given root is the root of the Binary Tree
    // Return the root of the generated BST
    Node binaryTreeToBST(Node root){
       // Your code here
       Node rt=null;
       ArrayList<Integer>ar=new ArrayList<>();
       inorder(root,ar);
       Collections.sort(ar);
       for(Integer i:ar)
       {
           System.out.print(i+" ");
       }
       return rt;
    }
    public static void inorder(Node root,ArrayList<Integer>ar)
    {
       if(root==null)
       {
           return;
       }
       else 
       {
           ar.add(root.data);
           inorder(root.left,ar);
           inorder(root.right,ar);
       }
    }
}
