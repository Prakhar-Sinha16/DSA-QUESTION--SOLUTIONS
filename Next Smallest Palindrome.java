gfg link: https://practice.geeksforgeeks.org/problems/next-smallest-palindrome4740/1

QUES:
Given a number, in the form of an array Num[] of size N containing digits from 1 to 9(inclusive). The task is to find the next smallest palindrome strictly larger than the given number.

Example 1:

Input:
N = 11
Num[] = {9, 4, 1, 8, 7, 9, 7, 8, 3, 2, 2}
Output: 9 4 1 8 8 0 8 8 1 4 9
Explanation: Next smallest palindrome is
9 4 1 8 8 0 8 8 1 4 9
Example 2:

Input:
N = 5
Num[] = {2, 3, 5, 4, 5}
Output: 2 3 6 3 2
Explanation: Next smallest palindrome is
2 3 6 3 2
Your Task:
Complete the function generateNextPalindrome() which takes an array num, and a single integer n, as input parameters and returns an array of integers denoting the answer. You don't to print answer or take inputs.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

Constraints:
1 <= N <= 105
1 <= Num[i] <= 9

CODE:
class Solution {

    int mod = (int)1e9+7;
    Vector<Integer> generateNextPalindrome(int num[], int n) {
        
        // ALL 9
        boolean all9 = true;
        for(int i : num) if(i != 9){
            all9 = false;
            break;
        }
        if(all9){
            Vector<Integer> a9 = new Vector<>(n);
            a9.add(1);
            for(int i = 1;i<n;i++)a9.add(0);
            a9.add(1);
            return a9;
        }
        
        // OPTION A
        Vector<Integer> a = new Vector<>(n);
        
        for(int i=0;i<n;i++){
            a.add(0);
        }
        for(int i=0;i<n/2;i++){
            a.set(i, num[i]);
        }
        
        if(n%2 == 1) a.set(n/2, num[n/2]);
        for(int i=0;i<n/2;i++){
            a.set(n-1-i, num[i]);
        }
        
        
        
        // OPTION B
        Vector<Integer> b = new Vector<>();
        
        for(int i=0;i<n/2;i++){
            b.add(num[i]);
        }
        
        if(n%2 == 1){
            b.add(num[n/2]+1);
            if(b.get(n/2) > 9){
                int carry = 1, i = n/2-1;
                b.set(n/2, 0);
                while(i>=0 && carry == 1){
                    b.set(i, b.get(i)+1);
                    if(b.get(i) > 9) b.set(i, 0);
                    else carry = 0;
                    i--;
                }
                if(carry == 1){
                    b.add(0, 1);
                }
            }
        }
        else {
            b.set(n/2-1, b.get(n/2-1)+1);
            if(b.get(n/2-1) > 9){
                int carry = 1, i = n/2-2;
                b.set(n/2-1, 0);
                while(i>=0 && carry == 1){
                    b.set(i, b.get(i)+1);
                    if(b.get(i) == 10) b.set(i, 0);
                    else carry = 0;
                    i--;
                }
                if(carry == 1){
                    b.add(0, 1);
                }
            }
        }
        int m = b.size();
        if(n%2 == 1) m--;
        for(int i=0;i<m;i++){
            b.add(b.get(m-1-i));
        }
        
        if(isGreater(a, num)){
            if(isGreater(b, a)){
                return a;
            }
        }
        if(isGreater(b, num)){
                return b;
        }
        
        
        return b;
    }
    boolean isGreater(Vector<Integer> a, int num[]) {
        if(a.size() > num.length) return true;
        int n = num.length;
        for(int i = 0;i<n;i++){
            if(a.get(i) != num[i]){
                return a.get(i)>num[i];
            }
        }
        return false;
    }
    boolean isGreater(Vector<Integer> a, Vector<Integer> b) {
        if(a.size() > b.size()) return true;
        if(a.size() < b.size()) return false;
        int n = b.size();
        for(int i = 0;i<n;i++){
            if(a.get(i) != b.get(i)){
                return a.get(i)>b.get(i);
            }
        }
        return false;
    }
}
