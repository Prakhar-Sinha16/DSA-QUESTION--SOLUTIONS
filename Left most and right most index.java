gfg link => https://practice.geeksforgeeks.org/problems/find-first-and-last-occurrence-of-x0849/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article

//QUES: Given a sorted array with possibly duplicate elements. The task is to find indexes of first and last occurrences of an element X in the given array.

Note: If the element is not present in the array return {-1,-1} as pair.

 

Example 1:

Input:
N = 9
v[] = {1, 3, 5, 5, 5, 5, 67, 123, 125}
X = 5
Output:
2 5
Explanation:
Index of first occurrence of 5 is 2
and index of last occurrence of 5 is 5.
Example 2:

Input:
N = 9
v[] = {1, 3, 5, 5, 5, 5, 7, 123, 125}
X = 7
Output:
6 6
 

Your Task:  
You don't need to read input or print anything. Your task is to complete the function indexes() which takes the array v[] and an integer X as inputs and returns  the first and last occurrence of the element X. If the element is not present in the array return {-1,-1} as pair.

Can you solve the problem in expected time complexity?


Expected Time Complexity: O(Log(N))
Expected Auxiliary Space: O(1)


Constraints:
1 ≤ N ≤ 105
1 ≤ v[i], X ≤ 1018
  
//CODE:
  /*
class pair  {  
    long first, second;  
    public pair(long first, long second)  
    {  
        this.first = first;  
        this.second = second;  
    }  
}
*/

class Solution {
    
    public long leftIndex(long a[], long x){
        int l=0, r=a.length-1;
        long ans=-1;
        while(l<=r){
            int mid = (l+r)/2;
            if(a[mid]==x){
                ans=mid;
                r=mid-1;
            }
            else if(x>a[mid]) l=mid+1;
            else r= mid-1;
        }
        return ans;
    }
    
    public long rightIndex(long a[], long x){
        int l=0, r=a.length-1;
        long ans=-1;
        while(l<=r){
            int mid = (l+r)/2;
            if(a[mid]==x){
                ans=mid;
                l=mid+1;
            }
            else if(x>a[mid]) l=mid+1;
            else r= mid-1;
        }
        return ans;
    }
    
    public pair indexes(long a[], long x){
        // Your code goes here
        long c= leftIndex(a,x);
        long d= rightIndex(a,x);
        // a[0]=c;
        // a[1]=d;
        return new pair(c,d);
    }
}
