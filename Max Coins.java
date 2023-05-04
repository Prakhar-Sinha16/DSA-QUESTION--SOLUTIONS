gfg link: https://practice.geeksforgeeks.org/problems/111fb97b983399c0ee9f34b7bae18ac76bf6f07a/1

QUES:
You are given a 2D integer array ranges whose length is n where ranges[i]=[starti, end,coinsi] means all integers from starti to endi inclusive starti and endi are 
present and we get coinsi amount of coins when we select this ith range. You can select at most two intervals so as to collect maximum coins but if you select two 
ranges then those two ranges should not intersect or overlap but can touch each other.

Note: You can select at max 2 ranges and they should not intersect with each other but they can touch themselves.

Example 1:

Input :
n=3
ranges={{1,3,4},{2,3,5},{3,4,2}}
Output: 7
Explanation:
We can see that we can take 2nd and 
3rd ranges as they are not intersecting
(only touching) we get maximum Coins by 
taking these ranges(5+2=7).
Example 2:

Input :
n=5
ranges={{1,3,4},{2,3,5},{3,4,2},{5,8,9},{2,8,10}}
Output: 14
Explanation:
We can see that we can take 2nd and 
4th ranges as they are not intersecting 
we get maximum Coins(5+9=14) by taking 
these ranges.
Your Task:
You don't need to read input or print anything. Your task is to complete the function maxCoins() which takes an integer n(length of ranges), integer 2D integer array 
ranges, and you have to return the maximum number of coins you got after selecting at most two ranges that are not intersecting.

Expected Time Complexity: O(nlogn)
Expected Space Complexity: O(n)

Constraints:
1<=n<=105
0<=ranges[i][0]<=ranges[i][1]<=109
0<=ranges[i][2](coins)<=106
The sum of n over all test cases won't exceed 106
  
CODE:
class Solution{
    static class Range{
        int s;
        int e;
        int c;
        public Range(int s, int e, int c){
            this.s=s;
            this.e=e;
            this.c=c;
        }
    }
    static class RangeComparator implements Comparator<Range>{
        public int compare(Range o1, Range o2){
            //This logic also handles cases when starting points are equal
            //If they are equal it arranges in asceding according to end points
            if(o1.s!=o2.s){
                return o1.s-o2.s;
            }else{
                return o1.e-o2.e;
            }
        }
    }
    public static int maxCoins(int n,int ranges[][])
    {
        Range[] r=new Range[n];
        for(int i=0;i<n;i++){
            r[i]=new Range(ranges[i][0],ranges[i][1],ranges[i][2]);
        }
        Arrays.sort(r,new RangeComparator());
        
        int[][] dp=new int[n][3];
        //Since in function below, we are going to only valid states after 'take', we just need to keep
        //a track of remaining slots and not the last range's end, so dp[n][3];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return maxCoins(r,0,2,dp);
    }
    
    public static int maxCoins(Range[] ranges, int i, int rem,int[][] dp){
        if(i==ranges.length || rem==0){
            return 0;
        }
        if(dp[i][rem]!=-1){
            return dp[i][rem];
        }
        int notTake=maxCoins(ranges,i+1,rem,dp);
        int take=ranges[i].c;
        //If we are taking this interval, checking the next possible interval with binary search lowerbound
        int s=i+1;
        int e=ranges.length-1;
        int ind=ranges.length;
        while(s<=e){
            int mid=(s+e)/2;
            if(ranges[mid].s>=ranges[i].e){
                ind=mid;
                e=mid-1;
            }else{
                s=mid+1;
            }
        }
        take+=maxCoins(ranges,ind,rem-1,dp);
        return dp[i][rem]=Math.max(take,notTake);
    }
}
