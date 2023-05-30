gfg link: https://practice.geeksforgeeks.org/problems/word-search/1

QUES:
Given a 2D board of letters and a word. Check if the word exists in the board. The word can be constructed from letters of adjacent 
cells only. ie - horizontal or vertical neighbors. The same letter cell can not be used more than once.

Example 1:

Input: board = {{a,g,b,c},{q,e,e,l},{g,b,k,s}},
word = "geeks"
Output: 1
Explanation: The board is-
a g b c
q e e l
g b k s
The letters which are used to make the
"geeks" are colored.
Example 2:

Input: board = {{a,b,c,e},{s,f,c,s},{a,d,e,e}},
word = "sabfs"
Output: 0
Explanation: The board is-
a b c e
s f c s
a d e e
Same letter can not be used twice hence ans is 0
Your Task:
You don't need to read or print anything. Your task is to complete the function isWordExist() which takes board and word as input 
parameter and returns boolean value true if word can be found otherwise returns false.

Expected Time Complexity: O(N * M * 4L) where N = No. of rows in board, M = No. of columns in board, L = Length of word
Expected Space Compelxity: O(L), L is length of word.

Constraints:
1 ≤ N, M ≤ 100
1 ≤ L ≤ N*M

CODE:
class Solution
{
    public boolean isWordExist(char[][] board, String word)
    {
        // Code here
        boolean [][] isVisited = new boolean [board.length][board[0].length];
        
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(word.charAt(0) == board[i][j]){
                  if(isWordPresent(board, 0, word, i, j, isVisited)) return true;
                }
            }
        }
        return false;
    }
    
    
    //Apply DFS
    public boolean isWordPresent(char[][]board, int index, String word, int row, int column, boolean [][]isVisited){
        if(index == word.length()) return true;
        
        if(row < 0 || column < 0 || row >= board.length || column >= board[0].length) return false;
        
        if(word.charAt(index) == board[row][column]){
            if(isVisited[row][column] == true) return false;
            else isVisited[row][column] = true;
        }
        else{
            return false;
        }
        
        boolean isFound = isWordPresent(board, index+1, word, row-1, column, isVisited) ||
            isWordPresent(board, index+1, word, row+1, column, isVisited) ||
            isWordPresent(board, index+1, word, row, column+1, isVisited) ||
            isWordPresent(board, index+1, word, row, column-1, isVisited);
            
        return isFound;
    }
}
