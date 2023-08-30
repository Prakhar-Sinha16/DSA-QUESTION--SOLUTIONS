gfg link: https://practice.geeksforgeeks.org/problems/delete-a-node-in-single-linked-list/1

QUES:
Given a singly linked list and an integer x.Delete xth node from the singly linked list.

Example 1:

Input: 1 -> 3 -> 4 
       x = 3
Output: 1 -> 3
Explanation:
After deleting the node at 3rd
position (1-base indexing), the
linked list is as 1 -> 3. 
Example 2:

Input: 1 -> 5 -> 2 -> 9 
x = 2
Output: 1 -> 2 -> 9
Explanation: 
After deleting the node at 2nd
position (1-based indexing), the
linked list is as 1 -> 2 -> 9.
Your task: Your task is to complete the method deleteNode() which takes two arguments: the address of the head of the linked list and an integer x. The function returns the head of the modified linked list.

Constraints:
2 <= N <= 105
1 <= x <= N

CODE:
class GfG{
    Node deleteNode(Node head, int x){
	// Your code here
	    if(head==null || head.next==null) {
			return head;
		}
		
		//Node prevNode = head;
		Node currNode = head;
		if(x==1){
	        head = head.next;
	    }
		for(int i=1;i<x-1;i++) {
		    //prevNode = prevNode.next;
		    currNode = currNode.next;
		}
		// for any middle node
	    if(currNode.next != null){
	        currNode.next = currNode.next.next;
	    }
		//for the last node
	    else{
	        currNode.next = null;
	    }  
        return head;
    }
}
