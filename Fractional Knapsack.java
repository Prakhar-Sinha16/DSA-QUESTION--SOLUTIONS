gfg link: https://practice.geeksforgeeks.org/problems/fractional-knapsack-1587115620/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article

QUES:
Given weights and values of N items, we need to put these items in a knapsack of capacity W to get the maximum total value in the knapsack.
Note: Unlike 0/1 knapsack, you are allowed to break the item. 

 

Example 1:

Input:
N = 3, W = 50
values[] = {60,100,120}
weight[] = {10,20,30}
Output:
240.00
Explanation:Total maximum value of item
we can have is 240.00 from the given
capacity of sack. 
Example 2:

Input:
N = 2, W = 50
values[] = {60,100}
weight[] = {10,20}
Output:
160.00
Explanation:
Total maximum value of item
we can have is 160.00 from the given
capacity of sack.
 

Your Task :
Complete the function fractionalKnapsack() that receives maximum capacity , array of structure/class and size n and returns a double value representing the maximum 
value in knapsack.
Note: The details of structure/class is defined in the comments above the given function.


Expected Time Complexity : O(NlogN)
Expected Auxilliary Space: O(1)


Constraints:
1 <= N <= 105
1 <= W <= 105
  
CODE:
/*
class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}
*/

class Solution{
    //Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int W, Item a[], int n) {
        // Your code here
        Arrays.sort(a, new Comparator<Item>(){
           public int compare(Item i1, Item i2){
              return i1.weight*i2.value - i2.weight*i1.value;
           }
        });
        
        double ans=0;
        for(int i=0;i<n;i++){
            if(W >= a[i].weight){
                ans += a[i].value;
                W -= a[i].weight;
            }else{
                ans += (double)((a[i].value *W)/(double) a[i].weight);
                break;
            }
        }
        return ans;
    }
}
