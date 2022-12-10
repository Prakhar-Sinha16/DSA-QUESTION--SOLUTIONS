gfg link => https://practice.geeksforgeeks.org/problems/build-the-smallest2841/1

//QUES: Given a number k and string num of digits (0 to 9) denoting a positive integer. Find a string denoting the lowest integer number possible by removing k digits from num, without changing their order.
// Note: num will not contain any leading zero.

// Example 1:

// Input:
// k = 2
// num = "143729"
// Output: "1329"
// Explanation: 1329 is the minimum number
// possible after removing '4' and '7'.
 

// Example 2:

// Input:
// k = 3
// num = "10056"
// Output: "0"
// Explanation: 0 is the minimum number
// possible after removing '1' , '5' and '6'.
 

// Your Task:  
// You dont need to read input or print anything. Complete the function buildLowestNumber() which accepts string num and integer k as input parameters and returns a string denoting the smallest integer possible after removing k digits from num without changing the order.


// Expected Time Complexity: O(Length of num) 
// Expected Auxiliary Space: O(Length of num) 


// Constraints:
// 1 <= Length of num <= 105
// 0 <= k < Length of num

//CODE:
class Solution {
    static String buildLowestNumber(String str, int k) {
        Stack<Character> st=new Stack<>();
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            while(!st.isEmpty() && k>0 && st.peek()>ch){
                st.pop();
                k--;
            }
            st.push(ch);
        }
        while(!st.isEmpty() && k>0){
            st.pop();
            k--;
        }
        //adding characters in string builder
        StringBuilder sb=new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        //handling zeros
        int n=sb.length();
        for(int i=n-1;i>=0;i--){
            if(sb.charAt(i)!='0'){
                break;
            }
            if(sb.charAt(i)=='0'){
                sb.deleteCharAt(i);
            }
        }
        return sb.length()==0? "0" : sb.reverse().toString();
    }
}
