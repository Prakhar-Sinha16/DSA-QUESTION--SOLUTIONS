gfg link => https://practice.geeksforgeeks.org/problems/sum-of-beauty-of-all-substrings-1662962118/1

//QUES: Given a string S, return the sum of beauty of all its substrings.
// The beauty of a string is defined as the difference in frequencies between the most frequent and least frequent characters.

// For example, the beauty of string "aaac" is 3 - 1 = 2.
// Example 1:

// Input:
// S = "aaac"
// Output:
// 3
// Explanation: The substrings with non - zero beauty are ["aaac","aac"] where beauty of "aaac" is 2 and beauty of "aac" is 1.
 

// Example 2:

// Input:
// S = "geeksforgeeks"
// Output:
// 62
// Explanation: There are 91 substrings of the given strings. Like, the beauty of substring "geek" is 1. In this way the sum of beauties of all substrings are 62.
// Your Task:
// You don't need to read input or print anything. Your task is to complete the function beautySum() which takes string S as input paramters and returns the sum of beauty of all its substrings. 

// Expected Time Complexity: O(|S|2)
// Expected Auxiliary Space: O(1)

// Constraints: 
// 1 ≤ |S| ≤ 500
// S only contains lower case alphabets.

//CODE:
class Solution {
    public static int getBeauty(int freq[])
    {
        int minF = Integer.MAX_VALUE;
        int maxF = Integer.MIN_VALUE;
        for(int i = 1;i < 27;i++)
        {
            if(freq[i] != 0)
            minF = Math.min(minF,freq[i]);
            maxF = Math.max(maxF,freq[i]);
        }
        int beauty = maxF - minF;
        return beauty;
        
    }
    public static int beautySum(String s) {
        // code here
        int n = s.length();
        int sum = 0;
        for(int i = 0;i < n;i++)
        {
            int freq[] = new int[27];
            for(int j = i; j < n;j++)
            {
                char ch = s.charAt(j);
                int ind = ch - 96;
                freq[ind]++;
                int beauty = getBeauty(freq);
                sum += beauty;
            }
        }
        return sum;
    }
}
        
