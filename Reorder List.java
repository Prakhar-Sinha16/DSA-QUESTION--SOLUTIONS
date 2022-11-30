gfg link => https://practice.geeksforgeeks.org/problems/reorder-list/1

//QUES: Given a singly linked list: A0→A1→...→An-2→An-1, reorder it to: A0→An-1→A1→An-2→A2→An-3→...
// For example: Given 1->2->3->4->5 its reorder is 1->5->2->4->3.

// Note: It is recommended do this in-place without altering the node's values.

// Example 1:

// Input:
// LinkedList: 1->2->3
// Output: 1 3 2
// Explanation:
// Here n=3, so the correct
// order is A0→A2→A1
// Example 2:

// Input:
// Explanation: 1->7->3->4
// Output: 1 4 7 3
// Explanation:
// Here n=4, so the correct
// order is A0→A3→A1→A2
// Your Task:
// The task is to complete the function reorderList() which should reorder the list as required. The reorder list is automatically printed by the driver's code.

// Note: Try to solve without using any auxilliary space.

// Expected Time Complexity: O(N)
// Expected Auxiliary Space: O(1)

// Constraints:
// 1 <= N <= 5*105
// 1 <= A[ i ] <= 105

//CODE:
/* Following is the Linked list node structure */

/*class Node
{
    int data;
    Node next;
    Node(int d) {
        data = d;
        next = null;
    }
}*/

class Solution {
    Node reorderlist(Node head) {
        // Your code here
        if(head.next == null)return head;
        Node prev=null;
        Node fast=head;
        Node slow=head;
        while(fast!=null && fast.next!=null){
            prev=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        prev.next=null;
        Node reverseHead = reverseHalf(slow);
        Node startHead=head;
        while(startHead != null){
            Node startNext=startHead.next;
            Node reverseNext=reverseHead.next;
            startHead.next=reverseHead;
            if(startNext!=null)reverseHead.next=startNext;
            startHead=startNext;
            reverseHead=reverseNext;
        }
        return head;
    }
    
    Node reverseHalf(Node head){
        Node prev=null;
        while(head!=null){
            Node next = head.next;
            head.next=prev;
            prev=head;
            head=next;
        }
        return prev;
    }
}
