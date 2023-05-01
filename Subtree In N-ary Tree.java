gfg link: 

QUES:
Given the root of a n-ary tree find the number of duplicate subtrees in the n-ary tree. Two trees are duplicates if they have the same structure with the same node 
values.

Example 1:

Input:
1 N 2 2 3 N 4 N 4 4 3 N N N N N

Output: 
2
Explanation: 
[4], [3] are duplicate subtree.
Example 2:

Input:
1 N 2 3 N 4 5 6 N N N N

Output: 
0
Explanation: 
No duplicate subtree found.
Your Task:
You don't need to read input or print anything. Your task is to complete the function duplicateSubtreeNaryTree() which takes the root of the n-ary tree as input and 
returns an integer value as a number of duplicate subtrees.

Expected Time Complexity: O(n), n is the total no of nodes
Expected Space Complexity: O(n2)

Constraints:
   1 <= n < 103
   1 <= node.key< 103
     
 CODE:
class Solution{
    HashMap<String,Integer> map = new HashMap<>();
    int ans=0;
    public int duplicateSubtreeNaryTree(Node root){
       helper(root);
       return ans;
    }
    
    public String helper(Node root){
        if(root==null)
            return "#";
        
        StringBuilder sb = new StringBuilder();
        sb.append(String.valueOf(root.data)+"#");
        
        for(Node neg : root.children){
            String temp=helper(neg);
            sb.append(temp);
        }
        
        String result=sb.toString();
        
        if(map.containsKey(result)==true){
            if(map.get(result)==1)ans++;
            map.put(result,map.get(result)+1);
        }
        else
            map.put(result,1);
        
        return result;
    }
    
}
