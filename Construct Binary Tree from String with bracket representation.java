gfg link => https://practice.geeksforgeeks.org/problems/construct-binary-tree-from-string-with-bracket-representation/1

//QUES: Construct a binary tree from a string consisting of parenthesis and integers. The whole input represents a binary tree. It contains an integer followed by zero, 
//one or two pairs of parenthesis. The integer represents the roots value and a pair of parenthesis contains a child binary tree with the same structure. 
//Always start to construct the left child node of the parent first if it exists.

// Example 1:

// Input: "1(2)(3)" 
// Output: 2 1 3
// Explanation:
//            1
//           / \
//          2   3
// Explanation: first pair of parenthesis contains 
// left subtree and second one contains the right 
// subtree. Inorder of above tree is "2 1 3".
// Example 2:

// Input: "4(2(3)(1))(6(5))"
// Output: 3 2 1 4 5 6
// Explanation:
//            4
//          /   \
//         2     6
//        / \   / 
//       3   1 5   
// Your Task:
// You don't need to read input or print anything. Your task is to complete the function treeFromString() which takes a string str as input parameter and returns the root node of the tree.


// Expected Time Complexity: O(N)
// Expected Auxiliary Space: O(N)


// Constraints:
// 1 <= |str| <= 105

//CODE:

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
    public static Node treeFromString(String s) {
        // code here
        int idx[]=new int []{0};
        return dfs(idx,s);
    }
    
    static Node dfs(int[] idx, String s){
        
        if(idx[0]>=s.length() || s.charAt(idx[0])==')'){
            return null;
        }
        
        int num=0;
        while(idx[0]<s.length() && Character.isDigit(s.charAt(idx[0]))){
            num = num*10+(s.charAt(idx[0])-'0');
            idx[0]++;
        }
        
        Node head = new Node(num);
        if(idx[0]<s.length() && s.charAt(idx[0])=='('){
            idx[0]++;
            head.left=dfs(idx,s);
        }
        
        if(idx[0]<s.length() && s.charAt(idx[0])=='('){
            idx[0]++;
            head.right=dfs(idx,s);
        }
        idx[0]++;
        return head;
    }    
}
