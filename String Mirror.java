gfg link: https://practice.geeksforgeeks.org/problems/d385b9d635b7b10eef6bf365b84922aaeec9eb98/1

QUES:
You are given a string str of length n. You want to choose a non-zero integer k (k<=n), such that you can perform the following operation:
Take the prefix of the string of length k and append the reverse of it to itself.
Your task is to find the lexicographically smallest string you can get.

Example 1:

Input:
str = "bvdfndkn"
Output:
bb
Explanation:
If we choose k=1, prefix of length k will be "b", reverse of
this prefix will be "b" itself, when we append both we get "bb",
"bb" is the lexicographically smallest string you can get.
If you choose k>1, the resulting string will not be 
lexicographically smaller than "bb".
Example 2:

Input:
str = "casd"
Output:
caac
Explanation:
If we choose k=2, prefix of length k will be "ca", reverse of
this prefix will be "ac", when we append both we get "caac",
"caac" is the lexicographically smallest string you can get.
Your Task:
You don't need to read input or print anything. Your task is to complete the function stringMirror() which takes a String str as input, and returns the 
lexicographically smallest string.

Expected Time Complexity: O(|str|)
Expected Space Complexity: O(|str|)

Constraints:
1 <= |str| <= 105
  
CODE:
class Solution {
    public static String stringMirror(String str) {
        // code here
        StringBuilder str1=new StringBuilder();
        str1.append(str.charAt(0));
        
        for(int i=1;i<str.length();i++){
            if(str.charAt(i)<str.charAt(i-1)){ //next element should be smaller than previous then only we add
                str1.append(str.charAt(i));
            }else if(str.charAt(i)==str.charAt(i-1) && i!=1){ //equal other than first string
                str1.append(str.charAt(i));
            }else{
                break;
            }
                
        }
        
        StringBuilder rev=new StringBuilder(str1);
        
        rev.reverse();
        
        str1.append(rev);
        
        return str1.toString();
    }
}
