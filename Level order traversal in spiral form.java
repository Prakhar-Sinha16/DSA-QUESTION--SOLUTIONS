gfg link: https://practice.geeksforgeeks.org/problems/level-order-traversal-in-spiral-form/1

QUES:
Given a binary tree and the task is to find the spiral order traversal of the tree.

Spiral order Traversal mean: Starting from level 0 for root node, for all the even levels we print the node's value from right to left and
for all the odd levels we print the node's value from left to right. 

For below tree, function should return 1, 2, 3, 4, 5, 6, 7.


 
 

Example 1:

Input:
      1
    /   \
   3     2
Output:1 3 2

Example 2:

Input:
           10
         /     \
        20     30
      /    \
    40     60
Output: 10 20 30 60 40 
Your Task:
The task is to complete the function findSpiral() which takes root node as input parameter and returns the elements in spiral form of 
level order traversal as a list. The newline is automatically appended by the driver code.
Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).

Constraints:
1 <= Number of nodes <= 105
0 <= Data of a node <= 105

CODE:
class Spiral{
    //Function to return a list containing the level order 
    //traversal in spiral form.	
    ArrayList<Integer> findSpiral(Node root) {
        // Your code here
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null) return ans;

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        boolean reverseLevel = true;

        while (!q.isEmpty()) {
            int size = q.size();
            ArrayList<Integer> levelNodes = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                Node cur = q.poll();
                levelNodes.add(cur.data);

                if (cur.left != null) {
                    q.add(cur.left);
                }
                if (cur.right != null) {
                    q.add(cur.right);
                }
            }

            if (reverseLevel) {
                for (int i = levelNodes.size() - 1; i >= 0; i--) {
                    ans.add(levelNodes.get(i));
                }
            } else {
                for (int i = 0; i < levelNodes.size(); i++) {
                    ans.add(levelNodes.get(i));
                }
            }

            reverseLevel = !reverseLevel;
        }

        return ans;
    }
}
