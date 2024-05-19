package org.back0.leetcode.array;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/
public class BestTimeToBuyAndSellStockII {

    public int maxProfit(int[] prices) {
        int maxProfit = 0;

        for (int i = 0; i < prices.length - 1; i++) {
            int currProfit = prices[i + 1] - prices[i];

            if (currProfit > 0) {
                maxProfit += currProfit;
            }
        }

        return maxProfit;
    }

}
