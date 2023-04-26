gfg link: https://practice.geeksforgeeks.org/problems/6bb49b563cc171335c6564b00307a6d867e0268d/1

QUES:
You are given an integer n, denoting the number of people who needs to be seated, and a list of m integers seats, where 0 represents a vacant seat and 1 represents an already occupied seat.

Find whether all n people can find a seat, provided that no two people can sit next to each other.

Example 1:

Input:
n = 2
m = 7
seats[] = {0, 0, 1, 0, 0, 0, 1}
Output:
Yes
Explanation:
The two people can sit at index 0 and 4.
Example 2:

Input:
n = 1
m = 3
seats[] = {0, 1, 0}
Output:
No
Explanation:
There is no way to get a seat for one person.
Your Task:

You don't have to input or print anything. Complete the function is_possible_to_get_seats() which takes the input parameters and return a boolean value, indicating whether all people can find a seat.

Expected Time Complexity: O(m)
Expected Space Complexity: O(1)

Constraints:

0 <= n <= 105
1 <= m <= 105
seats[i] == 0 or seats[i] == 1
  
CODE:
class Solution {
    public static boolean is_possible_to_get_seats(int n, int m, int[] arr) {
        for (int i = 0; i < m && n > 0; i++) {
            if (arr[i] == 0) {
                if ((i == 0 || arr[i-1] == 0) && (i == m-1 || arr[i+1] == 0)) {
                    n--;
                    arr[i] = 1;
                }
            }
        }
        return n == 0;
    }
}
