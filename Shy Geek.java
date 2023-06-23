gfg link: https://practice.geeksforgeeks.org/problems/59dfb26eb6c659e6e5f60869ac335f450f97165a/1?page=2&category[]=Binary%20Search&sortBy=submissions

QUES:
Geek went to buy some chocolates from a nearby shop with k coins in his pocket. He found that the shop contains n chocolates which are arranged in sorted order (increasing) of their prices.

Now geek wants to taste costlier chocolates so he decided that he will buy the costliest chocolate (of course among the ones that he can afford) till there exists at least one type of chocolate he can afford. You may assume that there is an infinite supply of chocolates in the shop Geek visited.

As you know, Geek is a shy person and hence he will enquire about the prices of the chocolates at most 50 times from the shopkeeper. Now, your task is to find the number of chocolates he had enjoyed. 

Note: If you call the Shop.get function more than 50 times it will return -1. Price of chocolates are pairwise distinct.

Example 1:

Input:
3 5 
2 4 6

Output:
1

Explanation: The prices of chocolates are [2, 4, 6] and Geek had 5 coins with him. So he can only buy chocolate that costs 4 coins (since he always picks the costliest one).
Example 2:

Input:
4 9 
1 2 3 4

Output:
3

Explanation: The prices of chocolates are [1, 2, 3, 4] and Geek had 9 coins with him. So he can buy two chocolates that cost 4 coins. Thereafter, he had only 1 coin with him, hence he will have 1 more chocolate (that costs 1 coin).
Your Task:
Return the number of chocolates geeks had eaten. Use the get(int i) function to inquire about the price of the i'th chocolate. 
Note that, you can only call that function 50 times after which it will return -1. Test cases are generated such that the answer can always be found.

Expected Time Complexity: O(logN)
Expected Auxiliary Space: O(logN)

Constraints:
0 < n < 105
0 < priceOfChocolate < = 107 
0 < k <= 1012 

CODE:
/*
Instructions - 

    1. 'shop' is object of class Shop.
    2. User 'shop.get(int i)' to enquire about the price
            of the i^th chocolate.
    3. Every chocolate in shop is arranged in increasing order
            i.e. shop.get(i) <= shop.get(i + 1) for all 0 <= i < n - 1
*/
class Solution{
    
    static Shop shop;
    Solution(Shop shop){
        this.shop = shop;
    }
    static long find(int n, long k){
        // Return the number of chocolates Geek had
        // enjoyed out of 'n' chocolates availabe in the
        // 'shop'.
        // Initialize the number of chocolates enjoyed by the geek to 0.
    long maxChocolates = 0;
    // Initialize the left and right indices for binary search.
    int left = 0;
    int right = n - 1;
    // Keep looping while the geek has some money left.
    while (k > 0) {
        // Initialize the maximum price of chocolate that the geek can afford.
        int maxPrice = 0;
        // Perform binary search to find the highest price chocolate that the geek can afford.
        while (left <= right) {
            // Calculate the middle index of the search range.
            int mid = (left + right) / 2;
            // Get the price of the chocolate at the middle index.
            int price = shop.get(mid);
            // If the price is higher than the remaining money, search in the lower half.
            if (price > k) {
                right = mid - 1;
            // Otherwise, update the maximum price found so far and search in the upper half.
            } else {
                maxPrice = price;
                left = mid + 1;
            }
        }
        // If the maximum price is 0, break the loop since there are no chocolates that the geek can afford.
        if (maxPrice == 0) {
            break;
        }
        // Calculate the maximum number of chocolates that the geek can buy with the remaining money.
        int numChocolates = (int) (k / maxPrice);
        // Add the number of chocolates to the total count.
        maxChocolates += numChocolates;
        /* Update the remaining money by taking the modulo with the price of the highest price 
        chocolate that the geek can afford.*/
        k = k % maxPrice;
        // Reset the left index to perform binary search on the entire array in the next iteration.
        left = 0;
    }
        // Return the number of chocolates enjoyed by the geek.
        return maxChocolates;
    }

}
