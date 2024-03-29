gfg link : https://practice.geeksforgeeks.org/problems/6a1b365b520f10c8a29b533eb72951b4b4237b57/1

QUES:
Given a string str consisting of only two characters 'a' and 'b'. You need to find the minimum steps required to make the string empty by removing consecutive a's and b's.

Example 1:

Input:
str = "bbaaabb"
Output:
2
Explanation:
Operation 1: Removal of all a's modifies str to "bbbb".
Operation 2: Removal of all remaining b's makes str
empty.
Therefore, the minimum number of operations required
is 2.
Example 2:

Input:
str = "aababaa"
Output:
3
Explanation:
Operation 1: Removal of b's modifies str to "aaabaa".
Operation 2: Removal of b's modifies str = "aaaaa".
Operation 3: Removal of all remaining a's makes str 
empty.
Therefore, the minimum number of operations required 
is 3.
Your Task:

You need to complete the function minSteps() which takes a string str as the only input parameter and returns an integer, denoting the minimum steps required to make the string empty.

Expected Time Complexity: O(N), where N = length of string str
Expected Space Complexity: O(1)
  
CODE:
class Solution{
	int minSteps(String s) {
		//Write your code here
		int a=1;
		for(int i=1;i<s.length();i++){
		    if(s.charAt(i) != s.charAt(i-1)) a++;
		
		}
		return (a/2)+1;
	}
}
