gfg link: https://practice.geeksforgeeks.org/problems/leaf-under-budget/1

QUES:
Given a binary tree and a budget. Assume you are at the root of the tree(level 1), you need to maximise the count of leaf nodes you can visit in your budget if the cost of visiting a leaf node is equal to the level of that leaf node.

Example 1:

Input: 
                  10
                /    \
               8      2
             /      /   \
            3      3     6
                    \
                     4
and budget = 8
Output: 2
Explanation:
Cost For visiting Leaf Node 3: 3
Cost For visiting Leaf Node 4: 4
Cost For visiting Leaf Node 6: 3
In budget 8 one can visit Max 2 Leaf Nodes.
Example 2:

Input: 
         1
       /   \
      2     3
     / \   / \
    4   5 6   7
and budget = 5
Output: 1
Explanation: We can only visit either node 4 or 5.
Your Task:

You don't need to read input or print anything. Your task is to complete the function getCount() which takes root node of the tree and a integer denoting the budget as input parameters and returns an integer denoting the count of visited leaf nodes of the tree.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)

Constraints:
1<=N<=105
1<=budget<=104

CODE:
class Solution{
    public int getCount(Node node, int bud){
        //code here
         int nodeVisitCount=0;
        int exp=0;
        if(node==null){
            return nodeVisitCount;
        }
        Queue<Node>q=new LinkedList<>();
        q.add(node);
        int level=0;
        while(q.isEmpty()==false){
            int n=q.size();
            level+=1;
            for(int i=1;i<=n;i++){
                Node curr=q.poll();
                if(curr.left==null && curr.right==null){
                exp+=level;
                    if(exp<=bud){
                        nodeVisitCount+=1;
                    }
                }
                if(curr.left!=null){
                q.add(curr.left);
                }
                if(curr.right!=null){
                q.add(curr.right);
                }
            }
        }
        return nodeVisitCount;
    }
}
