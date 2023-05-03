gfg link: https://practice.geeksforgeeks.org/problems/8d0e8785cef59cf4903b926ceb7100bcd16a9835/1

QUES;
You are given an array of strings arr of size n. You have to find out if it is possible to make a palindromic string by concatenating the strings in any order. Provided 
that all the strings given in the array are of equal length.

Example 1:

Input:
n = 4
arr = {"djfh", "gadt", "hfjd", "tdag"}
Output:
YES
Explanation:
You can make the string "djfhgadttdaghfjd", by concatenating the given strings which is a palindrome.
Example 2:

Input:
n = 3
arr = {"jhjdf", "sftas", "fgsdf"}
Output:
NO
Explanation:
You can't make a palindromic string with this strings.
Your Task:
You don't need to read input or print anything. Your task is to complete the function makePalindrome() which takes an integer n and an array of strings arr respectively 
and returns true or false.

Expected Time Complexity: O(n * len(arr[i]))
Expected Space Complexity: O(n * len(arr[i]))

Constraints:
1 <= n <= 104
0 <= |arr[i]| <= 104
The sum of n*|arr[i]| over all test cases won't exceed 106
  
CODE:
class Solution {
    public static boolean makePalindrome(int n, String[] arr) {
        // code here
        Map<String, Integer> map = new HashMap<>();
        
        for(int i=0; i<n; i++){
            StringBuffer sb = new StringBuffer(arr[i]);
            String s = sb.toString();
            String rev = sb.reverse().toString();
            
           if(map.containsKey(s)){
                map.remove(s);
            }
            else if(map.containsKey(rev)){
                map.remove(rev);
            }
            else{
                map.put(s, 1);
            }
        }
        
        //check map
        
        if(map.size() == 0){
            return true;
        }
        else if(map.size()==1){
            for(String val : map.keySet()){
                StringBuffer sb=new StringBuffer(val);
                
                if(val.equals(sb.reverse().toString())){
                    return true;
                }
            }
        }
        
        return false;
    }
}
