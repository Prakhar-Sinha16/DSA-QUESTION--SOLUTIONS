gfg link: https://practice.geeksforgeeks.org/problems/given-a-linked-list-of-0s-1s-and-2s-sort-it/1

QUES:
Given a linked list of N nodes where nodes can contain values 0s, 1s, and 2s only. The task is to segregate 0s, 1s, and 2s linked list 
such that all zeros segregate to head side, 2s at the end of the linked list, and 1s in the mid of 0s and 2s.

Example 1:

Input:
N = 8
value[] = {1,2,2,1,2,0,2,2}
Output: 0 1 1 2 2 2 2 2
Explanation: All the 0s are segregated
to the left end of the linked list,
2s to the right end of the list, and
1s in between.
Example 2:

Input:
N = 4
value[] = {2,2,0,1}
Output: 0 1 2 2
Explanation: After arranging all the
0s,1s and 2s in the given format,
the output will be 0 1 2 2.
Your Task:
The task is to complete the function segregate() which segregates the nodes in the linked list as asked in the problem statement and 
returns the head of the modified linked list. The printing is done automatically by the driver code.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).

Constraints:
1 <= N <= 106

CODE:
class Solution{
    //Function to sort a linked list of 0s, 1s and 2s.
    static Node segregate(Node head){
        // add your code here
        int count0=0;
        int count1=0;
        int count2=0;
        Node cur=head;
        
        while(cur != null){
            if(cur.data == 0)count0++;
            else if(cur.data == 1)count1++;
            else count2++;
            
            cur = cur.next;
        }
        
        cur = head;
        
        for(int i=0; i<count0; i++){
            cur.data = 0;
            cur = cur.next;
        }
        for(int i=0; i<count1; i++){
            cur.data = 1;
            cur = cur.next;
        }
        for(int i=0; i<count2; i++){
            cur.data = 2;
            cur = cur.next;
        }
        return head;
    }
}
