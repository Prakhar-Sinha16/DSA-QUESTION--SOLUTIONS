GFG LINK => https://practice.geeksforgeeks.org/problems/absolute-list-sorting/1

//QUES: Given a linked list of N nodes, sorted in ascending order based on the absolute values of its data,i.e. negative values are considered as positive ones. 
//Sort the linked list in ascending order according to the actual values, and consider negative numbers as negative and positive numbers as positive.


// Example 1:

// Input: 
// List: 1, -2, -3, 4, -5
// Output: 
// List: -5, -3, -2, 1, 4
// Explanation: 
// Actual sorted order of {1, -2, -3, 4, -5}
// is {-5, -3, -2, 1, 4}
 

// Example 2:

// Input: 
// List: 5, -10
// Output: 
// List: -10, 5
// Explanation:
// Actual sorted order of {5, -10}
// is {5, 10}
 

// Your Task:
// You don't need to read or print anyhting. Your Task is to comple the function sortList() which takes the head of the Linked List as input parameter and sort the list in ascending order and return the head pointer of the sorted list.

 

// Expected Time Complexity: O(N)
// Expected Space Complexity: O(1)


// Constraints
// 1 ≤  N  ≤ 10^5
// -10^5 ≤  node.data ≤ 10^5

//CODE:
/* The structure of the node of the Linked List is
class Node
{
   int data;
   Node next;
   Node(int d) {data = d; next = null; }
 }
*/

class Solution
{
	Node sortList(Node head) {
		// Your code here
		ArrayList<Integer> result = new ArrayList<>();
		while(head!=null){
		    result.add(head.data);
		    head = head.next;
		}
		Collections.sort(result);
		Node cur = new Node(0);
		Node cur1 = cur;
		for(int i : result){
		    cur.next=new Node(i);
		    cur=cur.next;
		}
		return cur1.next;
	}
}
