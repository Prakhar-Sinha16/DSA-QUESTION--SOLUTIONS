gfg link: https://practice.geeksforgeeks.org/problems/union-of-two-linked-list/1

QUES:
Given two linked lists, your task is to complete the function makeUnion(), that returns the union list of two linked lists. This union 
list should include all the distinct elements only and it should be sorted in ascending order.

Example 1:

Input:
L1 = 9->6->4->2->3->8
L2 = 1->2->8->6->2
Output: 
1 2 3 4 6 8 9
Explaination: 
All the distinct numbers from two lists, when sorted forms the list in the output. 
Example 2:

Input:
L1 = 1->5->1->2->2->5
L2 = 4->5->6->7->1
Output: 
1 2 4 5 6 7
Explaination: 
All the distinct numbers from two lists, when sorted forms the list in the output.
Your Task:
The task is to complete the function makeUnion() which makes the union of the given two lists and returns the head of the new list.

Expected Time Complexity: O((N+M)*Log(N+M))
Expected Auxiliary Space: O(N+M)

Constraints:
1<=N,M<=104

CODE:
class Sol
{
	public static Node findUnion(Node head1,Node head2)
	{
	    //Add your code here.
	    Set<Integer> set = new TreeSet<>();

        // Traverse the first list and add elements to the set
        Node curr1 = head1;
        while (curr1 != null) {
            set.add(curr1.data);
            curr1 = curr1.next;
        }

        // Traverse the second list and add elements to the set
        Node curr2 = head2;
        while (curr2 != null) {
            set.add(curr2.data);
            curr2 = curr2.next;
        }

        // Create a new linked list using the elements from the set
        Node dummy = new Node(0);
        Node curr = dummy;
        for (int num : set) {
            curr.next = new Node(num);
            curr = curr.next;
        }

        return dummy.next;
	}
}
