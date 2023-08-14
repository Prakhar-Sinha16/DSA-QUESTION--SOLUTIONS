gfg link: https://practice.geeksforgeeks.org/batch/gts-1/track/GTS-ARRAY/problem/minimum-swaps-1624449643

QUES:
Given two array A[] and B[] of same size N. 
In one swap, You can swap A[i] with B[i]. The task is to calculate the minimum number of swaps requeired to make all elements of the array A[] equal, or make all elements of the array B[] equal. 
Note: If it is not possible to make the all elements of any one array equal then return -1.

Example 1:

Input:
N = 4
A[] = {2,1,2,2}
B[] = {3,2,4,4}
Output: 1
Explanation: we can swap A[2] and B[2].
A[] becomes {2,2,2,2} , B[] becomes {3,1,4,4}
Now all elements of the array A[] are equal.

Example 2:

Input:
N = 3
A[] = {1,1,2}
B[] = {1,1,1}
Output: 0
Explanation: No swaps required,
All elements of the array B[] are already equal.
Example 3:

Input:
N = 2
A[] = {1,2}
B[] = {4,3}
Output: -1
Explanation: It is not possible to make all
elements of one array equal.
Your Task:
You don't need to read input or print anything. Your task is to complete the function minSwaps() which takes N, an array A[ ] and an array B[] as input and returns the minimum number of swaps required to make the all elements of the array A[] or B[] equal. If it is not possible then return -1.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

Constraints:
1 < N < 105
1 < A[i] < 105

CODE:
class Solution{
    int minSwaps(int N, int A[], int B[]){
        int c1=0,c2=0,c3=0,c4=0;
        int a=A[0],b=B[0];
        
        for(int i=0;i<A.length;i++){
 //case1:= we try to make all top elem 2
            if(c1!=Integer.MAX_VALUE){
                if(A[i]==a){

                }else if(B[i]==a){
                    c1++;
                }else{
                    c1=Integer.MAX_VALUE;
                }
            }
            
//case2:==we try to make all bottom elem2
            if(c2!=Integer.MAX_VALUE){
                if(B[i]==a){
                    
                }else if(A[i]==a){
                    c2++;
                }else{
                    c2=Integer.MAX_VALUE;
                }
            }
            
 //case3: try to make top elm 5
            if(c3!=Integer.MAX_VALUE){
                if(A[i]==b){

                }else if(B[i]==b){
                    c3++;
                }else{
                    c3=Integer.MAX_VALUE;
                }
            }
            
 //case 4 try to make all bottom elem 5
            if(c4!=Integer.MAX_VALUE){
                if(B[i]==b){
                    
                }else if(A[i]==b){
                    c4++;
                }else{
                    c4=Integer.MAX_VALUE;
                }
            }
            
        }
//then return min amongs all ,if not possible
// return -1
    return Math.min(Math.min(c1,c2),Math.min(c3,c4))==Integer.MAX_VALUE?-1:Math.min(Math.min(c1,c2),Math.min(c3,c4));

    }
}
