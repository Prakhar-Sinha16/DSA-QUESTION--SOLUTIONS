gfg link: https://practice.geeksforgeeks.org/problems/9b61b8efbb030aed799055f776629dbf1287fbae/1

QUES:
Chhota Bheem wants to eat the maximum number of ladoos in Dholakpur on Independence Day. The houses in Dholakpur are arranged in the form of a binary tree and have ladoos the same as their house number. Chhota Bheem is standing at his home initially. 
Find the maximum ladoos he can eat if he can go to houses within a maximum distance k from his house. The number of ladoos at his home should also be included in the sum.

Note: Every house has distinct ladoos in it. 
Example 1:

Input:
                   1
                 /    \
                2      9
               /      /  \
              4      5     7
            /   \         /  \
           8     19     20    11
          /     /  \
         30   40   50
home = 9, K = 1
Output:
22
Explanation:
Initially Bheem at 9, so sum = 9
In 2nd move he went to 5, sum=9+5=14
In 3rd move he went to 7, sum=14+7=21
In 4th move he went to 1, sum=21+1=22
So within K distance bheem can get 22 ladoos.  
Example 2:

Input:
                   1
                 /    \
                2      9
               /      /  \
              4      5     7
            /   \         /  \
           8     19     20    11
          /     /  \
         30   40   50
home = 40, K = 2
Output:
113
Explanation:
Initially Bheem at 40, so sum = 40
In 2nd move he went to 19, sum=40+19=59
In 3rd move he went to 4, sum=59+4=63
In 4th move he went to 50, sum=63+50=113
So within K distance bheem can get 113 ladoos.
Your Task:
You don't need to read input or print anything. Complete the function ladoos() which takes the root of the tree, home, and K  as input parameters and returns the maximum number of ladoos he can eat.

Expected Time Complexity: O(N), where N is no. of nodes
Expected Space Complexity: O(1)

Constraints:
1 ≤ N, Home ≤ 105
1 ≤ K ≤ 20
  
CODE:
class Solution{
    static Node search(Node root,int home)
    {
        if(root==null)return null;
        if(root.data==home) return root;
        
        Node l=search(root.left,home);
        if(l!=null)return l;
        Node r=search(root.right,home);
        return r;
    }
    static void CreateConnection(Node root,HashMap<Node,Node> parent,Node p)
    {
        if(root==null)return;
        
        parent.put(root,p);//Key-> Root Value-> Parent
        
        CreateConnection(root.left,parent,root); // traversing left BT
        CreateConnection(root.right,parent,root);// traversing right BT
    }
    static int ladoos(Node root, int home, int k)
    {
        // Your code goes here
        
        //getting address for home
        Node target = search(root,home);
        
        //HashMap for storing Node and its parent
        HashMap<Node,Node> parent= new HashMap<>();
        
        CreateConnection(root,parent,null);
        
        //Creating a visited HashSet for checking
        HashSet<Node> visited= new HashSet<>();
        
        int Sum=0;
        
        //Using BFS
        Queue<Node>q= new LinkedList<>();
        q.add(target);
        visited.add(target);
        while(q.size()>0)
        {
            int size=q.size();
            
            for(int i=0;i<size;i++)
            {
                Node temp= q.poll();
                Sum+=temp.data;
                
                if(temp.left!=null && !visited.contains(temp.left)) //left SubTree
                {
                    q.add(temp.left);
                    visited.add(temp.left);
                }
                if(temp.right!=null && !visited.contains(temp.right)) //right SubTree
                {
                    q.add(temp.right);
                    visited.add(temp.right);
                }
                if(parent.get(temp)!=null &&!visited.contains(parent.get(temp)))
                {
                    q.add(parent.get(temp));
                    visited.add(parent.get(temp));
                }
            }
            k--;
            if(k<0)break;
        }
        
        return Sum;
    }
}
