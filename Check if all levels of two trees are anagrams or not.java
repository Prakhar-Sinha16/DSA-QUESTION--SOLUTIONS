gfg link => https://practice.geeksforgeeks.org/problems/check-if-all-levels-of-two-trees-are-anagrams-or-not/1

//QUES: Given two binary trees, the task is to check if each of their levels are anagrams of each other or not. 

//Example 1:

// Input:

// Output: 1
// Explanation: 
// Tree 1:
// Level 0 : 1
// Level 1 : 3, 2
// Level 2 : 5, 4

// Tree 2:
// Level 0 : 1
// Level 1 : 2, 3
// Level 2 : 4, 5

// As we can clearly see all the levels of above two binary trees 
// are anagrams of each other, hence return true.
// Example 2:

// Input:

// Output: 0
// Explanation: 
// Tree 1:
// Level 0 : 1
// Level 1 : 2, 3 
// Level 2 : 5, 4 

// Tree 2: 
// Level 0 : 1 
// Level 1 : 2, 4 
// Level 2 : 5, 3 

// As we can clearly see that level 1 and leve 2 are not anagrams of each other, hence return false.
// Your Task:  
// You don't need to read input or print anything. Your task is to complete the function areAnagrams() which takes the root of two trees as input and returns an 1 if all the levels are anagrams, else returns 0 as output.
 
// Expected Time Complexity: O(NlogN)
// Expected Auxiliary Space: O(N)

// Constraints:
// 1 <= N <= 104
// 1 <= tree.val <= 109

//CODE: 
class Solution {
    public static boolean areAnagrams(Node node1, Node node2) {
        // code here
        Queue<Node> q1 = new LinkedList<>();
		Queue<Node> q2 = new LinkedList<>();
		q1.add(node1);
		q2.add(node2);
		while (q1.size() > 0 && q2.size() > 0) {
			int s1 = q1.size();
			int s2 = q2.size();
			ArrayList<Integer> list1 = new ArrayList<>();
			ArrayList<Integer> list2 = new ArrayList<>();
			if (s1 != s2) {
				return false;
			}
			for (int i = 0; i < s1; i++) {
				Node n1 = q1.poll();
				Node n2 = q2.poll();
				list1.add(n1.data);
				list2.add(n2.data);
				if (n1.left != null) {
					q1.offer(n1.left);
				}
				if (n2.left != null) {
					q2.offer(n2.left);
				}
				if (n1.right != null) {
					q1.offer(n1.right);
				}
				if (n2.right != null) {
					q2.offer(n2.right);
				}
			}
			Collections.sort(list1);
			Collections.sort(list2);
			for (int i = 0; i < s1; i++) {
				int v1 = list1.get(i);
				int v2 = list2.get(i);
				if (v1 != v2) {
					return false;
				}
			}
		}
		if (q1.size() != 0 || q2.size() != 0) {
			return false;
		}
		return true;
    }
}
