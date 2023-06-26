gfg link: https://practice.geeksforgeeks.org/problems/pythagorean-triplet3018/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article

QUES:
Given an array arr of N integers, write a function that returns true if there is a triplet (a, b, c) that satisfies a2 + b2 = c2, otherwise 
false.

Example 1:

Input:
N = 5
Arr[] = {3, 2, 4, 6, 5}
Output: Yes
Explanation: a=3, b=4, and c=5 forms a
pythagorean triplet.
Example 2:

Input:
N = 3
Arr[] = {3, 8, 5}
Output: No
Explanation: No such triplet possible.
Your Task:
Complete the function checkTriplet() which takes an array arr, single integer n, as input parameters and returns boolean denoting answer to 
the problem. You don't to print answer or take inputs. 
Note: The driver will print "Yes" or "No" instead of boolean.

Expected Time Complexity: O(max(Arr[i])2)
Expected Auxiliary Space: O(max(Arr[i]))

Constraints:
1 <= N <= 107
1 <= Arr[i] <= 1000

CODE:
class Solution {
    boolean checkTriplet(int[] a, int n) {
        // code here
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<a.length; i++){
            set.add(a[i]*a[i]);
        }
        
        for(int i=0; i<a.length; i++){
            for(int j=i+1; j<a.length; j++){
                int isq=a[i]*a[i];
                int jsq=a[j]*a[j];
                if(set.contains(isq + jsq))return true;
            }
        }
        return false;
    }
}
