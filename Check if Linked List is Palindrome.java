gfg link https://practice.geeksforgeeks.org/problems/check-if-linked-list-is-pallindrome/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article

QUES:
Given a singly linked list of size N of integers. The task is to check if the given linked list is palindrome or not.

Example 1:

Input:
N = 3
value[] = {1,2,1}
Output: 1
Explanation: The given linked list is
1 2 1 , which is a palindrome and
Hence, the output is 1.
Example 2:

Input:
N = 4
value[] = {1,2,3,4}
Output: 0
Explanation: The given linked list
is 1 2 3 4 , which is not a palindrome
and Hence, the output is 0.
Your Task:
The task is to complete the function isPalindrome() which takes head as reference as the only parameter and returns true or false if 
linked list is palindrome or not respectively.

Expected Time Complexity: O(N)
Expected Auxialliary Space Usage: O(1)  (ie, you should not use the recursive stack space as well)

Constraints:
1 <= N <= 105
  
CODE:
/* Structure of class Node is
class Node
{
	int data;
	Node next;
	
	Node(int d)
	{
		data = d;
		next = null;
	}
}*/

class Solution{
    //Function to check whether the list is palindrome.
    boolean isPalindrome(Node head)  {
        //Your code here
        if(head == null || head.next == null) return true;
        
        Node mid = FindMiddleLL(head);
        Node rev = reverseLL(mid);
        
        Node left = head;
        Node right = rev;
        while(right!=null){
            if(left.data != right.data) return false;
            left = left.next;
            right = right.next;
        }
        return true;
    }    
    
    Node FindMiddleLL(Node head){
        Node slow = head;
        Node fast = head;
        
        while(fast!=null && fast.next!=null){
            slow= slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    
    Node reverseLL(Node head){
        Node cur = head;
        Node prev = null;
        
        while(cur!=null){
            Node temp=cur.next;
            cur.next=prev;
            prev=cur;
            cur=temp;
        }
        return prev;
    }
}
