package com.practice.stock;
/*
https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock),
 design an algorithm to find the maximum profit.

Note that you cannot sell a stock before you buy one.

Example 1:

Input: [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
             Not 7-1 = 6, as selling price needs to be larger than buying price.

Example 2:

Input: [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.


 */
public class BuySellStock {
    /*
    Time complexity : o(n2)
     */
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length <= 1)
            return 0;
        int maxProfit = 0;
        int len = prices.length;
// [7,1,5,3,6,4]
        for(int i=0;i<len-1;i++){
            int m = prices[i+1];
            for(int j=i+1;j<len;j++){
                if(prices[j]>m)
                    m = prices[j];
            }

            maxProfit = Math.max(m-prices[i],maxProfit);
        }

        return maxProfit;

    }

    /*
    Time Cpomplexity :: O(n)
    The key to thinking about this problem is breaking it down into the smallest possible pieces.
    At each index in the array, we have two choices:
    Buy the stock for that price, or sell the stock at that price.
    Choosing the first option is easy- just keep track of the smallest price in a variable (buy). Then, at every index- we check:
    Should we buy the stock?
    -The way to check this is by checking to see if the price of the stock at the current index is less than the lowest price stock we have come across already. If so, adjust the buy variable.
   Should we sell the stock?
   - If the stock price we found so far did not fulfill the first check (to buy the stock),
this means that the price of the stock has to be greater than the smallest price we bought the stock at.
 Thus we check our potential profit if we were to sell the stock at our current price- if it is greater than the profit we have recorded (in the profit variable), we adjust our profit variable accordingly.
     */
    public int maxProfit2(int[] prices) {
        if(prices == null || prices.length <= 1)
            return 0;
        int maxProfit = 0;
        int buy = prices[0];
// [7,1,5,3,6,4]
        for(int i=0;i<prices.length;i++){
            if(prices[i]<buy) {
             buy = prices[i];
            } else if(maxProfit<(prices[i]-buy)) {
                maxProfit = prices[i]-buy;
            }


        }

        return maxProfit;

    }
    public static void main(String[] args) {
        BuySellStock buySellStock = new BuySellStock();
        System.out.println("[7, 1, 5, 3, 6, 4]::"+buySellStock.maxProfit2(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println("[7,6,4,3,1]::"+buySellStock.maxProfit2(new int[]{7,6,4,3,1}));

    }
}
