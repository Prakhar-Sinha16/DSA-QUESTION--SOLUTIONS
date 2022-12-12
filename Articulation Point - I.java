gfg link => https://practice.geeksforgeeks.org/problems/articulation-point-1/1

//QUES: Given an undirected connected graph with V vertices and adjacency list adj. You are required to find all the vertices removing which 
//(and edges through it) disconnects the graph into 2 or more components.
// Note: Indexing is zero-based i.e nodes numbering from (0 to V-1). There might be loops present in the graph.

// Example 1:

// Input:

// Output:{1,4}
// Explanation: Removing the vertex 1 will
// discconect the graph as-

// Removing the vertex 4 will disconnect the
// graph as-

// Your Task:
// You don't need to read or print anything. Your task is to complete the function articulationPoints() which takes V and adj as input parameters and returns a list containing all the vertices removing which turn the graph into two or more disconnected components in sorted order. If there are no such vertices then returns a list containing -1.
 
// Expected Time Complexity: O(V + E)
// Expected Auxiliary Space: O(V)
 
// Constraints:
// 1 ≤ V ≤ 105

//CODE:

class Solution
{
    //Function to return Breadth First Traversal of given graph

 private void dfs(int node,int parent,boolean vis[],int tin[],int low[],
   ArrayList<ArrayList<Integer>> adj,int timer, ArrayList<Integer> a){
       vis[node]=true;
       tin[node]=low[node]=timer++;
       int child=0;
       for(Integer x:adj.get(node)){
           if(x==parent)
               continue;
           if(!vis[x]){
               dfs(x,node,vis,tin,low,adj,timer,a);
               low[node]=Math.min(low[node],low[x]);
               if(low[x]>=tin[node] && parent!=-1){
                   if(!a.contains(node))
                       a.add(node);
               }
               child++;//if there is dfs  call for multiple childs we take note of it
           }else if(vis[x] && x!=parent){
               low[node]=Math.min(low[node],tin[x]);
           }
       }
       if(parent ==-1 && child>1){//if the starting node has more than 1 components
       //that are not connceted to each other
           a.add(node);
       }
   }
   public ArrayList<Integer> articulationPoints(int V,ArrayList<ArrayList<Integer>> adj)
   {
       // Code here
       boolean vis[]=new boolean[V];
       int low[]=new int[V];
       int tin[]=new int[V];
       int timer=0;
       ArrayList<Integer> a=new ArrayList<Integer>();
       for(int i=0;i<V;i++){
           if(!vis[i]){
               dfs(i,-1,vis,tin,low,adj,timer,a);
           }
       }
       if(a.size()==0)
           {
               a.add(-1);
               return a;
           }
       Collections.sort(a);
       //a.remove(a.get(0));
       return a;
   }
}
