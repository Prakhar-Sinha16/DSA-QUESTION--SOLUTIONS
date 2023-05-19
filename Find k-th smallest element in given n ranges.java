gfg link: https://practice.geeksforgeeks.org/problems/find-k-th-smallest-element-in-given-n-ranges/1

QUES:
Given n ranges of the form [p, q] which denotes all the numbers in the range [p, p + 1, p + 2,...q].  Given another integer q denoting 
the number of queries. The task is to return the kth smallest element for each query (assume k>1) after combining all the ranges.
In case the kth smallest element doesn't exist return -1. 

Example 1:

Input:
n = 2, q = 3
range[] = {{1, 4}, {6, 8}}
queries[] = {2, 6, 10}
Output: 
2 7 -1
Explanation: 
After combining the given ranges, 
the numbers become 1 2 3 4 6 7 8. As here 2nd 
element is 2, so we print 2. As 6th element is 
7, so we print 7 and as 10th element doesn't 
exist, so weprint -1.
Example 2:

Input:
n = 2, q = 2
range[] = {{2, 6}, {5, 7}} 
queries[] = {5, 8}
Output: 
6 -1
Explantion: 
After combining the ranges, we'll take Union of 
range= {2,3,4,5,6,7}, here  5th smallest number 
will be 6 and 8th smallest number does not exists.
Your Task:  
You don't need to read input or print anything. Your task is to complete the function kthSmallestNum() which takes a n * 2 array 
denoting the ranges and an array denoting the queries.

Expected Time Complexity: O(nlogn+q*n)
Expected Auxiliary Space: O(q)

Constraints:
1 <= n <= 103
1 <= range[i][0] <= range[i][1] <= 2*109
1 <= q <= 500
1 <= queries[i] <= 2*109
  
CODE:
class Solution {
    public static ArrayList<Integer> kthSmallestNum(int n, int[][] range, int q, int[] queries) {
        // code here
        ArrayList<Integer> ans=new ArrayList<>();
        Arrays.sort(range,new Comparator<int[]>() {
            public int compare(int a[],int b[]){
                return a[0]-b[0];
            }
        } );
        List<List<Integer>> list=new ArrayList<>();
        List<Integer> arr=new ArrayList<>();
        arr.add(range[0][0]);arr.add(range[0][1]);
        list.add(arr);
        for(int i=1;i<n;i++){
            if(list.get(list.size()-1).get(1)>=range[i][0]){
                list.get(list.size()-1).set(1,Math.max(list.get(list.size()-1).get(1),range[i][1]));
            }
            else{
                List<Integer> array=new ArrayList<>();
                array.add(range[i][0]);array.add(range[i][1]);
                list.add(array);
            }
        }
        for(int i=0;i<q;i++)
        {
            int ele=queries[i];
            boolean added=false;
            for(int j=0;j<list.size();j++){
                int window=list.get(j).get(1)-list.get(j).get(0)+1;
                if(window<ele){
                    ele=ele-window;
                }
                else{
                    added=true;
                    ans.add(list.get(j).get(0)+ele-1);
                    break;
                }
            }
            if(added==false){
                ans.add(-1);
            }
        }
        return ans;
    }
}
