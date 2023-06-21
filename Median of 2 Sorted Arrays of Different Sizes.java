gfg link: https://practice.geeksforgeeks.org/problems/median-of-2-sorted-arrays-of-different-sizes/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article

QUES:
Given two sorted arrays array1 and array2 of size m and n respectively. Find the median of the two sorted arrays.

Example 1:

Input:
m = 3, n = 4
array1[] = {1,5,9}
array2[] = {2,3,6,7}
Output: 5
Explanation: The middle element for
{1,2,3,5,6,7,9} is 5
Example 2:

Input:
m = 2, n = 4
array1[] = {4,6}
array2[] = {1,2,3,5}
Output: 3.5
Your Task:
The task is to complete the function MedianOfArrays() that takes array1 and array2 as input and returns their median. 

Can you solve the problem in expected time complexity?

Expected Time Complexity: O(min(log n, log m)).
Expected Auxiliary Space: O((n+m)/2).

Constraints: 
0 ≤ m,n ≤ 106
1 ≤ array1[i], array2[i] ≤ 109
  
CODE:
class GFG { 
    static double medianOfArrays(int n1, int n2, int a1[], int a2[]) {
        // Your Code Here
        n1=a1.length;
        n2=a2.length;
        if(n1 > n2) return medianOfArrays(n2,n1,a2,a1);
        
        int l=0,r=n1;
        while(l <=r){
            int m1 = (l+r)/2;
            int m2 = (n1+n2+1)/2-m1;
            
            int max1 = m1==0?Integer.MIN_VALUE : a1[m1-1];
            int max2 = m2==0?Integer.MIN_VALUE : a2[m2-1];
            
            int min1 = m1==n1?Integer.MAX_VALUE : a1[m1];
            int min2 = m2==n2?Integer.MAX_VALUE : a2[m2];
            
            if(max1 <= min2 && max2 <= min1){
                if((n1+n2)%2==0){
                    return ((double)Math.max(max1,max2)+(double)Math.min(min1,min2))/2;
                }else{
                    return (double)Math.max(max1,max2);
                }
            }else if(max2 > min1){
                l = m1+1;
            }else{
                r = m1-1;
            }
        }
        return 0.0;
    }
}
