gfg link: https://practice.geeksforgeeks.org/problems/n-meetings-in-one-room-1587115620/1?page=1&category[]=Greedy&curated[]=1&sortBy=submissions

QUES:
There is one meeting room in a firm. There are N meetings in the form of (start[i], end[i]) where start[i] is start time of meeting i and end[i] is finish time of 
meeting i.
What is the maximum number of meetings that can be accommodated in the meeting room when only one meeting can be held in the meeting room at a particular time?

Note: Start time of one chosen meeting can't be equal to the end time of the other chosen meeting.


Example 1:

Input:
N = 6
start[] = {1,3,0,5,8,5}
end[] =  {2,4,6,7,9,9}
Output: 
4
Explanation:
Maximum four meetings can be held with
given start and end timings.
The meetings are - (1, 2),(3, 4), (5,7) and (8,9)
Example 2:

Input:
N = 3
start[] = {10, 12, 20}
end[] = {20, 25, 30}
Output: 
1
Explanation:
Only one meetings can be held
with given start and end timings.

Your Task :
You don't need to read inputs or print anything. Complete the function maxMeetings() that takes two arrays start[] and end[] along with their size N as input 
parameters and returns the maximum number of meetings that can be held in the meeting room.


Expected Time Complexity : O(N*LogN)
Expected Auxilliary Space : O(N)


Constraints:
1 ≤ N ≤ 105
0 ≤ start[i] < end[i] ≤ 105
  
CODE:
class Solution {
    
    static class Pair implements Comparable <Pair>{
        int s,e;
        public Pair(int s, int e){
            this.s=s;
            this.e=e;
        }
        public int compareTo(Pair that){
            return this.e - that.e;
        }
    }
    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    public static int maxMeetings(int start[], int end[], int n){
        // add your code here
        if(n==0) return 0;
        Pair a[] = new Pair[n];
        for(int i=0;i<n;i++){
            a[i] = new Pair(start[i],end[i]);
        }
        Arrays.sort(a);
        int curEnd = a[0].e;
        int ans=1;
        for(int i=0;i<n;i++){
            if(a[i].s > curEnd){
                ans++;
                curEnd = a[i].e;
            }
        }
        return ans;
    }
}
