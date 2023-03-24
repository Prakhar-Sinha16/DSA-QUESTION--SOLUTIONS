gfg link => https://practice.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article


Given an undirected graph with V vertices and E edges, check whether it contains any cycle or not. Graph is in the form of adjacency list where adj[i] contains all the nodes ith node is having edge with.

Example 1:

Input:  
V = 5, E = 5
adj = {{1}, {0, 2, 4}, {1, 3}, {2, 4}, {1, 3}} 
Output: 1
Explanation: 

1->2->3->4->1 is a cycle.
Example 2:

Input: 
V = 4, E = 2
adj = {{}, {2}, {1, 3}, {2}}
Output: 0
Explanation: 

No cycle in the graph.
 

Your Task:
You don't need to read or print anything. Your task is to complete the function isCycle() which takes V denoting the number of vertices and adjacency list as input parameters and returns a boolean value denoting if the undirected graph contains any cycle or not, return 1 if a cycle is present else return 0.

NOTE: The adjacency list denotes the edges of the graph where edges[i] stores all other vertices to which ith vertex is connected.

 

Expected Time Complexity: O(V + E)
Expected Space Complexity: O(V)


 

Constraints:
1 ≤ V, E ≤ 105
  
  
  CODE:
class Solution {
    
        public boolean isCycle(int v, ArrayList<ArrayList<Integer>> adj) {
            boolean vis[] = new boolean[v];
            for(int i=0; i<v; i++){
                if(!vis[i]){
                    if(dfs(i,adj,vis,-1)){
                        return true;
                    }
                }
            }
            return false;
        }
        
        public boolean dfs(int src, ArrayList<ArrayList<Integer>> adj, boolean vis[], int parent){
            vis[src]=true;
            for(Integer neighbor : adj.get(src)){
                if(!vis[neighbor]){
                    if(dfs(neighbor,adj,vis, src)) return true;
                }
                else if(parent != neighbor) return true;
            }
            return false;
        }
}
