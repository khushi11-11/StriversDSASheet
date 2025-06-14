package array.medium;
/*
STOCK BUY AND SELL~
Problem Statement: You are given an array of prices where prices[i] is the price of a given stock on an ith day.
You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock. Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

Example 1:
Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and
sell on day 5 (price = 6), profit = 6-1 = 5.

Note: That buying on day 2 and selling on day 1
is not allowed because you must buy before
you sell.

Example 2:
Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transactions are
done and the max profit = 0.
 */
public class Q06_StockBuyAndSell {
    public static void main(String[] args) {
        int[] arr1 = {7,1,5,3,6,4};
        maxProfit(arr1);
        int[] arr2 = {7,6,4,3,1};
        optimal(arr2);
    }

    static void maxProfit(int[] arr) {
        int left=0, curr=1;
        int profit=0;
        while (left < arr.length-1) {
            // profit calculation
            if (arr[left] < arr[curr]) {
                int temp = arr[curr] - arr[left];
                if (temp > profit)
                    profit = arr[curr] - arr[left];
            }
            // updating selling day as needed to check every selling day's profit
            if (curr == arr.length - 1) {
                left++;
                curr = left + 1;
            } else {
                curr++;
            }
        }
        System.out.println(profit);
    }

    static void optimal(int[] prices) {
        int min_price = Integer.MAX_VALUE;
        int profit = 0;
        for (int price : prices) {
            if (price < min_price) {
                min_price=price;
            } else {
                int temp = price-min_price;
                if (temp>profit) {
                    profit=temp;
                }
            }
        }
        System.out.println(profit);
    }
}
