gfg link => https://practice.geeksforgeeks.org/problems/satisfy-the-equation5847/1
//QUES: Given an array A[ ] of N of  integers, find the index of values that satisfy A + B = C + D where A,B,C & D are integers values in the array.
Note: As there may be multiple pairs satisfying the equation return lexicographically smallest order of  A, B, C and D and return all as -1 if there are no pairs satisfying the equation.

// Example 1:

// Input:
// N = 7
// A[] = {3, 4, 7, 1, 2, 9, 8}
// Output:
// 0 2 3 5
// Explanation:
// A[0] + A[2] = 3+7 = 10
// A[3] + A[5] = 1+9 = 10
// Example 2:

// Input:
// N = 4
// A[] = {424, 12, 31, 7}
// Output:
// -1 -1 -1 -1
// Explanation:
// There are no pairs satisfying the equation.
 

// Your Task:
// You don't need to read input or print anything. Your task is to complete the function satisfyEqn() which takes an Integer N and an array A[] of size N as input and returns a vector of 4 integers denoting A, B, C, and D respectively.

 

// Expected Time Complexity: O(N2*logN2)
// Expected Auxiliary Space: O(N2)

 

// Constraints:
// 1 <= N <= 500
// 1 <= A[i] <= 10
  
  //CODE:
  class Pair{
    int x;
    int y;
    Pair(int a,int b){
        x=a;
        y=b;
    }
}


// 1 2 4 5==curr
// 0 3 4 5 ==ans

class Solution {
    
    static int[] satisfyEqn(int[] A, int N) {
        // code here
        int ans[]=new int[4];
        Arrays.fill(ans,Integer.MAX_VALUE);
        Map<Integer,Pair> map=new HashMap<>();//key-> sum, values-> indices
        
        for(int i=0;i<N-1;i++){
            for(int j=i+1;j<N;j++){
                int sum=A[i]+A[j];
                if(!map.containsKey(sum)){
                    map.put(sum,new Pair(i,j));
                    continue;
                }
                
                Pair p=map.get(sum);
                if(p.x!=i && p.y!=j && p.x!=j && p.y!=i){
                    int curr[]=new int[4];
                    curr[0]=p.x;
                    curr[1]=p.y;
                    curr[2]=i;
                    curr[3]=j;
                    if(ans[0]==Integer.MAX_VALUE){
                        for(int idx=0;idx<4;idx++){
                            ans[idx]=curr[idx];
                        }
                    }else{
                        boolean replace=false;
                        for(int idx=0;idx<4;idx++){
                            if(ans[idx]>curr[idx]){
                                replace=true;
                                break;
                            }else if(ans[idx]<curr[idx]){
                                break;
                            }
                        }
                        if(replace){
                            //replace it
                            for(int idx=0;idx<4;idx++){
                                ans[idx]=curr[idx];
                            }
                        }
                    }
                }
            }
        }
        if(ans[0]==Integer.MAX_VALUE){
            Arrays.fill(ans,-1);
        }
        return ans;
    }
};
