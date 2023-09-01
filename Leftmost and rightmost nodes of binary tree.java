gfg link: https://practice.geeksforgeeks.org/problems/leftmost-and-rightmost-nodes-of-binary-tree/1

QUES:
Given a Binary Tree of size N, Print the corner nodes ie- the node at the leftmost and rightmost of each level.

Example 1:

Input :
         1
       /  \
     2      3
    / \    / \
   4   5  6   7    
Output: 1 2 3 4 7
Explanation:
Corners at level 0: 1
Corners at level 1: 2 3
Corners at level 2: 4 7
Example 2:

Input:

        10
      /    \
     20     30
    / \  
   40  60
Output: 10 20 30 40 60
Your Task:  
You dont need to read input. Complete the function printCorner() which takes root node as input parameter and prints the corner nodes separated by spaces. The left corner should be printed before the right for each level starting from level 0.
Note: Don't print a new line after printing all the corner nodes.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(number of nodes in a level)

Constraints:
1 ≤ N ≤ 10^5

CODE:
class Tree{
    public static void printCorner(Node node){
        
        // add your code here
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        while(!q.isEmpty()){
            int size = q.size();
            
            // pop the first element in the current level
            Node first = q.poll();
            ans.add(first.data);
            if(first.left != null)
                q.add(first.left);
            if(first.right != null)
                q.add(first.right);
            
            // pop out the middle elements
            int k = 1;
            while(!q.isEmpty() && k <= size - 2){
                Node cur = q.poll();
                
                if(cur.left != null)
                    q.add(cur.left);
                if(cur.right != null)
                    q.add(cur.right);
                
                k++;
            }
            
            // pop the last element in the current level
            Node last = null;
            if(!q.isEmpty() && (size - k) > 0)
                last = q.poll();
            
            if(last != null){
                ans.add(last.data);
                if(last.left != null)
                    q.add(last.left);
                if(last.right != null)
                    q.add(last.right);
            }
        }
        
        for(Integer ele: ans)
            System.out.print(ele + " ");
    }
}
