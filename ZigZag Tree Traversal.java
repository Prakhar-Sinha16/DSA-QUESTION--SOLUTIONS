gfg link: https://practice.geeksforgeeks.org/problems/zigzag-tree-traversal/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article

QUES:

Given a Binary Tree. Find the Zig-Zag Level Order Traversal of the Binary Tree.

 

Example 1:

Input:
        1
      /   \
     2     3
    / \   /  \
   4   5 6    7
Output:
1 3 2 4 5 6 7
Example 2:

Input:
           7
        /     \
       9       7
     /  \     /   
    8    8   6     
   /  \
  10   9 
Output:
7 7 9 8 8 6 9 10 
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function zigZagTraversal() which takes the root node of the Binary Tree as its input and returns a list containing the node values as they appear in the Zig-Zag Level-Order Traversal of the Tree.

 

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).

 

Constraints:
1 <= N <= 104

CODE:
class GFG{
    //Function to store the zig zag order traversal of tree in a list.
	ArrayList<Integer> zigZagTraversal(Node root){
	    //Add your code here.
	    ArrayList<Integer> ans = new ArrayList<>();
	    Queue<Node> q = new ArrayDeque<>();
	    if(root == null) return ans;
	    
	    q.offer(root);
	    
	    int f =1;
	    
	    while(!q.isEmpty()){
	        ArrayList<Integer> temp = new ArrayList<>();
	        int size = q.size();
	        while(size-- > 0){
	            Node t = q.peek();
	            temp.add(t.data);
	            q.poll();
	            if(t.left != null) q.offer(t.left);
	            if(t.right != null) q.offer(t.right);
	        }
	        if(f % 2 == 0) Collections.reverse(temp);
	        for(int i=0; i<temp.size(); i++){
	            ans.add(temp.get(i));
	        }
	        f = 1-f;
	    }
	    return ans;
	}
}
