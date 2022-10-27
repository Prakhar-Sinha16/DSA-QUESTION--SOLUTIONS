gfg link=> https://practice.geeksforgeeks.org/problems/print-leaf-nodes-from-preorder-traversal-of-bst2657/1

//Ques: Given a preorder traversal of a BST, find the leaf nodes of the tree without building the tree.


// Example 1:

// Input:
// N = 2
// arr = {2,1}
// Output: {1}
// Explaination: 1 is the only leaf node.

// Example 2:

// Input:
// N = 3
// Arr = {3, 2, 4}
// Output: {2, 4}
// Explaination: 2, 4 are the leaf nodes.

// Your Task:
// You don't need to read input or print anything. Your task is to complete the function leafNodes() which takes the array arr[] and its size N as input parameters and returns the leaf nodes of the tree.


// Expected Time Complexity: O(N)
// Expected Auxiliary Space: O(N)


// Constraints:
// 1 ≤ N ≤ 103
// 1 ≤ arr[i] ≤ 103

//CODE:

public int[] leafNodes(int arr[], int n){
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[0]);
        for(int i=1;i<n;i++){
            if(arr[i]<stack.peek()){
                stack.push(arr[i]);
            }else{
                int temp=stack.peek();
                int count=0;
                while(!stack.isEmpty() && stack.peek()<arr[i]){
                    stack.pop();
                    count++;
                }
                stack.push(arr[i]);
                if(count >= 2){
                    ans.add(temp);
                }
            }
        }
        ans.add(stack.peek());
        int answer[] = new int[ans.size()];
        int index=0;
        for(int i : ans){
            answer[index]=i;
            index++;
        }
        return answer;
    }
