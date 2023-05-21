gfg link: https://practice.geeksforgeeks.org/problems/add-two-numbers-represented-by-linked-lists/1?page=1&category[]=Linked%20List&curated[]=1&sortBy=submissions

QUES:
Given two decimal numbers represented by two linked lists of size N and M respectively. The task is to return a linked list that 
represents the sum of these two numbers.

For example, the number 190 will be represented by the linked list, 1->9->0->null, similarly 25 by 2->5->null. Sum of these two numbers 
is 190 + 25 = 215, which will be represented by 2->1->5->null. You are required to return the head of the linked list 2->1->5->null.

Example 1:

Input:
N = 2
valueN[] = {4,5}
M = 3
valueM[] = {3,4,5}
Output: 3 9 0  
Explanation: For the given two linked
list (4 5) and (3 4 5), after adding
the two linked list resultant linked
list will be (3 9 0).
Example 2:

Input:
N = 2
valueN[] = {6,3}
M = 1
valueM[] = {7}
Output: 7 0
Explanation: For the given two linked
list (6 3) and (7), after adding the
two linked list resultant linked list
will be (7 0).
Your Task:
The task is to complete the function addTwoLists() which has node reference of both the linked lists and returns the head of the sum list.   

Expected Time Complexity: O(N+M)
Expected Auxiliary Space: O(Max(N,M)) for the resultant list.

Constraints:
1 <= N, M <= 5000
  
CODE:
/* node for linked list

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

*/

class Solution{
    //Function to add two numbers represented by linked list.
    static Node addTwoLists(Node first, Node second){
        // code here
        // return head of sum list
        first = reverseLL(first);
        second = reverseLL(second);
        int p = 0;
        int sum=0;
        Node dummy= new Node(-1);
        Node temp = dummy;
        while(first!=null || second!=null)
        {
            
            if(first!=null && second!=null)
            {
            sum=first.data+second.data+p;
            if(sum>9)
            {
                p=1;
                Node curr=new Node(sum%10);
                dummy.next=curr;
                dummy=dummy.next;
                
            }
            else
            {
               p=0;
               Node curr=new Node(sum);
               dummy.next=curr;
               dummy=dummy.next;
            }
          
                first=first.next;
                second=second.next;
           }
        else
        {
            if(first==null)
            {
                 sum=second.data+p;
                 Node curr=new Node(sum%10);
               dummy.next=curr;
               dummy=dummy.next;
                second=second.next;
                if(sum<10)p=0;
              
            }
            else
            {    sum=first.data+p;
                 Node curr=new Node(sum%10);
               dummy.next=curr;
               dummy=dummy.next;
               first=first.next;
                 if(sum<10)p=0;
            }
        }
        }
        if (p==1)
        { Node curr=new Node(1);
               dummy.next=curr;
        }
        temp=reverseLL(temp.next);
        return temp;
    }
    static Node reverseLL(Node head){
        Node prev=null;
        Node cur=head;
        while(cur != null){
            Node temp = cur.next;
            cur.next=prev;
            prev=cur;
            cur=temp;
        }
        return prev;
    }

}
  
  
  
