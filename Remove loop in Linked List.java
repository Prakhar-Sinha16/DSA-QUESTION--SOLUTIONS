gfg link: https://practice.geeksforgeeks.org/problems/remove-loop-in-linked-list/1?page=1&category[]=Linked%20List&curated[]=1&sortBy=submissions

QUES:
Given a linked list of N nodes such that it may contain a loop.

A loop here means that the last node of the link list is connected to the node at position X(1-based index). If the link list does not 
have any loop, X=0.

Remove the loop from the linked list, if it is present, i.e. unlink the last node which is forming the loop.


Example 1:

Input:
N = 3
value[] = {1,3,4}
X = 2
Output: 1
Explanation: The link list looks like
1 -> 3 -> 4
     ^    |
     |____|    
A loop is present. If you remove it 
successfully, the answer will be 1. 

Example 2:

Input:
N = 4
value[] = {1,8,3,4}
X = 0
Output: 1
Explanation: The Linked list does not 
contains any loop. 

Example 3:

Input:
N = 4
value[] = {1,2,3,4}
X = 1
Output: 1
Explanation: The link list looks like 
1 -> 2 -> 3 -> 4
^              |
|______________|
A loop is present. 
If you remove it successfully, 
the answer will be 1. 

Your Task:
You don't need to read input or print anything. Your task is to complete the function removeLoop() which takes the head of the linked 
list as the input parameter. Simply remove the loop in the list (if present) without disconnecting any nodes from the list.
Note: The generated output will be 1 if your submitted code is correct.


Expected time complexity: O(N)
Expected auxiliary space: O(1)


Constraints:
1 ≤ N ≤ 10^4

CODE:
/*
class Node
{
    int data;
    Node next;
}
*/

class Solution
{
    //Function to remove a loop in the linked list.
    public static void removeLoop(Node head){
        // code here
        // remove the loop without losing any node
        HashSet<Node> set = new HashSet<>();
        removeLoopUtil(head,set);
    }
    
    static void removeLoopUtil(Node head, HashSet<Node> set){
        Node cur= head,prev=head;
        while(cur != null){
            if(set.contains(cur)){
                prev.next=null;
                break;
            }
            set.add(cur);
            prev=cur;
            cur=cur.next;
        }
    }
    
}
