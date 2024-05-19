package org.back0.leetcode.array;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {
        var maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[0]) {
                maxProfit = Math.max(maxProfit, prices[i] - prices[0]);
            } else {
                prices[0] = prices[i];
            }
        }

        return maxProfit;
    }

}
