gfg link: https://practice.geeksforgeeks.org/problems/find-median-in-a-stream-1587115620/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article

QUES:
Given an input stream of N integers. The task is to insert these numbers into a new stream and find the median of the stream formed by 
each insertion of X to the new stream.

Example 1:

Input:
N = 4
X[] = 5,15,1,3
Output:
5
10
5
4
Explanation:Flow in stream : 5, 15, 1, 3 
5 goes to stream --> median 5 (5) 
15 goes to stream --> median 10 (5,15) 
1 goes to stream --> median 5 (5,15,1) 
3 goes to stream --> median 4 (5,15,1 3) 
 

Example 2:

Input:
N = 3
X[] = 5,10,15
Output:
5
7.5
10
Explanation:Flow in stream : 5, 10, 15
5 goes to stream --> median 5 (5) 
10 goes to stream --> median 7.5 (5,10) 
15 goes to stream --> median 10 (5,10,15) 
Your Task:
You are required to complete the class Solution. 
It should have 2 data members to represent 2 heaps. 
It should have the following member functions:
insertHeap() which takes x as input and inserts it into the heap, the function should then call balanceHeaps() to balance the new heap.
balanceHeaps() does not take any arguments. It is supposed to balance the two heaps.
getMedian() does not take any arguments. It should return the current median of the stream.

Expected Time Complexity : O(nlogn)
Expected Auxilliary Space : O(n)
 
Constraints:
1 <= N <= 106
1 <= x <= 106
  
CODE:
class Solution
{
    //Function to insert heap.
    static PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    static boolean even = true;
    public static void insertHeap(int x)
    {
        // add your code here
        if(even){
            minHeap.offer(x);
            maxHeap.offer(minHeap.poll());
        }else{
            maxHeap.offer(x);
            minHeap.offer(maxHeap.poll());
        }
        even = !even;
    }
    
    //Function to balance heaps.
    public static void balanceHeaps()
    {
       // add your code here
    }
    
    //Function to return Median.
    public static double getMedian()
    {
        // add your code here
        if(even){
            return (maxHeap.peek() + minHeap.peek())/2;
        }else{
            return (double)maxHeap.peek();
        }
    }
    
}
