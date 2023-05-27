gfg link: https://practice.geeksforgeeks.org/problems/modify-linked-list-1-0546/1

QUES:
Given a singly linked list containing N nodes. Modify the Linked list as follows:

1. Modify the value of the first half nodes such that 1st node's new value is equal to the value of the last node minus the first node's 
current value, 2nd node's new value is equal to the second last nodes value minus 2nd nodes current value, likewise for first half nodes.

2. Replace the second half of nodes with the initial values of the first half nodes(values before modifying the nodes).
3. If N is odd then the value of the middle node remains unchanged.

Example 1:

Input:
N = 5
linked list = 10 -> 4 -> 5 -> 3 -> 6
Output:
-4 -1 5 4 10
Explanation:
For first half nodes modified list will be:
-4 -> -1 -> 5 -> 3 -> 6
For second half nodes modified list will be:
-4 -> -1 -> 5 -> 4 -> 10
Example 2:

Input:
N = 6
linked list = 2 -> 9 -> 8 -> 12 -> 7 -> 10
Output:
8 -2 4 8 9 2
Explanation:
After modifying the linked list as required,
we have a new linked list containing the elements as
8 -> -2 -> 4 -> 8 -> 9 -> 2.
YourTask:
The task is to complete the function modifyTheList() which should modify the list as required.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

Constraints:
1 <= N <= 105
-105  <= Node->data <= 105
  
CODE:
class Solution{
    public static Node modifyTheList(Node head){
        
        Node slow = head;
        Node fast = head;
        while(fast.next!= null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        Node temp = slow.next;
        slow.next = null;
        Node head2 = reverseLL(temp);
        Node cur1 = head;
        Node cur2 = head2;
        while(cur1 != null && cur2 != null){
          cur2.data = cur2.data - cur1.data;
          cur1 = cur1.next;
          cur2 = cur2.next;
        }
        head2 = reverseLL(head2);
        slow.next = head2;
        return reverseLL(head);
    }
    public static Node reverseLL(Node head){
        if(head == null && head.next == null)return head;
        Node prev = null, cur = head;
        while(cur != null){
            Node temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }
}
