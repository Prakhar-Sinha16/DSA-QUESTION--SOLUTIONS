gfg link: https://practice.geeksforgeeks.org/problems/95bb244da24edd6214086ff934886ccda6ed9da8/1

QUES:
Given an array locations[] of size n where locations[i] represents the location of the ith fruit on the x-axis and also given an array 
types[]  where types[i] is an integer which represents the type of the ith fruit. You are initially at coordinate 0 and you have to 
collect all the fruits and then return back to coordinate 0 again. To move 1 unit on the x-axis requires 1 second of time. The only 
condition is that you have to collect the fruits in a non-decreasing order of their types[i] (for example if ith fruit has type[i]=1 
and jth fruit has type[j]=2 then ith fruit has to be picked before jth fruit). Find minimum time to collect all fruits in the 
non-decreasing order of their types and return back to coordinate 0.

Note: You can assume it takes no time to pick up fruit and the location of a fruit can be negative also.

Example 1:

Input:
n=4
locations={1,3,5,7}
types={1,2,3,1}
Output:
18
Explanation:
You start at x=0 and move to x=7 and 
in the way pick fruits of type 1 at x=1 
and x=7 and it took total 7 seconds to 
move from 0->7 now you move to x=3 
in 4 seconds and than to x=5 in 2 seconds 
and than return back to x=0 in 5 seconds.
So overall it took 18 seconds(7+4+2+5).
Example 2:

Input:
n=4
locations={-4,-3,1,-8}
types={4,2,4,5}
Output:
24
Explanation:
The optimal way is to way go to x=-3 
in starting than 1 and follow path 
like this  (1)->(-4)->(-8)->(0) and 
total time it takes is 24 .
Your Task:
You don't need to read input or print anything. Your task is to complete the function minTime() which takes an integer n, integer array 
locations and types and you have to return minimum time to collect all fruits.

Expected Time Complexity: O(n)
Expected Space Complexity: O(n)

Constraints:
1<=n<=105
-109<=locations[i]<=109
1<=types[i]<=105
  
CODE:
class Solution {
    static long dp[][];
    public static long minTime(int n, int[] locations, int[] types) {
        // code here
        int mx=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            mx=Math.max(mx,types[i]);
        }
        int tmp[][]=new int[mx+1][2];
        for(int i=0;i<mx+1;i++){
            tmp[i][0]=Integer.MAX_VALUE;
            tmp[i][1]=Integer.MIN_VALUE;
        }
        for(int i=0;i<n;i++){
            int in=types[i];
            tmp[in][0]=Math.min(tmp[in][0],locations[i]);
            tmp[in][1]=Math.max(tmp[in][1],locations[i]);
        }
        ArrayList<ArrayList<Integer>> arr=new ArrayList<>();
        for(int i=0;i<mx+1;i++){
            if(tmp[i][0]!=Integer.MAX_VALUE){
                ArrayList<Integer> A=new ArrayList<>();
                A.add(tmp[i][0]);
                A.add(tmp[i][1]);
                arr.add(A);
            }
        }
        dp=new long[arr.size()+1][3];
        for(int i=0;i<arr.size()+1;i++){
            Arrays.fill(dp[i],-1);
        }
        return fun(0,arr,2);
    }
    public static long fun(int i,ArrayList<ArrayList<Integer>> arr,int pos)
    {
        if(i==arr.size()){
            return dp[i][pos]=Math.abs(arr.get(i-1).get(pos));
        }
        if(dp[i][pos]!=-1){
            return dp[i][pos];
        }
        int x=0;
        if(pos==0){
            x=arr.get(i-1).get(0);
        }else if(pos==1){
            x=arr.get(i-1).get(1);
        }
        if(arr.get(i).get(1)<=x){
            return dp[i][pos]=x-arr.get(i).get(0)+fun(i+1,arr,0);
        }else if(arr.get(i).get(0)>=x){
            return dp[i][pos]=(arr.get(i).get(1)-x)+fun(i+1,arr,1);
        }else{
            int mn=arr.get(i).get(0),mx=arr.get(i).get(1);
            return dp[i][pos]=Math.min(2*(x-mn)+(mx-x)+fun(i+1,arr,1),2*(mx-x)+(x-mn)+fun(i+1,arr,0));
        }
    }
}
        
