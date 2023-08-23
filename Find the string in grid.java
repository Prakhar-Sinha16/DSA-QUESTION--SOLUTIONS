gfg link: https://practice.geeksforgeeks.org/problems/find-the-string-in-grid0111/1

QUES:
Given a 2D grid of n*m of characters and a word, find all occurrences of given word in grid. A word can be matched in all 8 directions at any point. Word is said to be found in a direction if all characters match in this direction (not in zig-zag form). The 8 directions are, horizontally left, horizontally right, vertically up, vertically down, and 4 diagonal directions.

Note: The returning list should be lexicographically smallest. If the word can be found in multiple directions starting from the same coordinates, the list should contain the coordinates only once. 

Example 1:

Input: 
grid = {{a,b,c},{d,r,f},{g,h,i}},
word = "abc"
Output: 
{{0,0}}
Explanation: 
From (0,0) we can find "abc" in horizontally right direction.
Example 2:

Input: 
grid = {{a,b,a,b},{a,b,e,b},{e,b,e,b}}
word = "abe"
Output: 
{{0,0},{0,2},{1,0}}
Explanation: 
From (0,0) we can find "abe" in right-down diagonal. 
From (0,2) we can find "abe" in left-down diagonal. 
From (1,0) we can find "abe" in horizontally right direction.
Your Task:
You don't need to read or print anything, Your task is to complete the function searchWord() which takes grid and word as input parameters and returns a list containing the positions from where the word originates in any direction. If there is no such position then returns an empty list.

Expected Time Complexity: O(n*m*k) where k is constant
Expected Space Complexity: O(1)

Constraints:
1 <= n <= m <= 50
1 <= |word| <= 15

CODE:
class Solution
{
    public int[][] searchWord(char[][] grid, String word)
    {
        // Code here
        int[] arr = {0,1,2,3,4,5,6,7,8};
        ArrayList<ArrayList<Integer>> li = new ArrayList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==word.charAt(0)){
                    for(int k=1;k<arr.length;k++){
                        if(dfs(i,j,word,grid,li,0,k)){
                            ArrayList<Integer> l = new ArrayList<>(Arrays.asList(i,j));
                            li.add(l);
                            break;
                        }
                    }
                }
            }
        }
        int[][] ret = new int[li.size()][2];
        for(int i=0;i<li.size();i++){
            int[] x =  {li.get(i).get(0),li.get(i).get(1)};
            ret[i] = x;
        }
        return ret;
    }
    public boolean dfs(int i,int j,String word,char[][] grid,ArrayList<ArrayList<Integer>> li,int index,int dir){
         if(index==word.length()) return true;
        if(i<0 || j<0 || i>=grid.length || j>=grid[i].length|| grid[i][j]!=word.charAt(index)){
            return false;
        }
        boolean a=false,b=false,c=false,d=false,e=false,f=false,g=false,h=false;
        
        if(dir==1){
             a = dfs(i+1,j,word,grid,li,index+1,dir);
        }
        if(dir==2){
             b = dfs(i-1,j,word,grid,li,index+1,dir);   
        }
        
        if(dir==3){
            c = dfs(i,j+1,word,grid,li,index+1,dir); 
        }
        
        if(dir==4){
             d = dfs(i,j-1,word,grid,li,index+1,dir);
        }
        if(dir==5){
              e = dfs(i+1,j+1,word,grid,li,index+1,dir);              
        }
        
        if(dir==6){
             f = dfs(i+1,j-1,word,grid,li,index+1,dir);
        }
        
        if(dir==7){
              g = dfs(i-1,j+1,word,grid,li,index+1,dir);
        }
        
        if(dir==8){
              h = dfs(i-1,j-1,word,grid,li,index+1,dir);
        }

        return a||b||c||d||e||f||g||h;
 
    }
}
