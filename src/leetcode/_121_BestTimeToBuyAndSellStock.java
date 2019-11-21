package leetcode;

/**
 * @Author:cathetine
 * @Date:19-8-25 下午11:10
 * 121. 买卖股票的最佳时机
 * 题目描述
 * 假设你有一个数组，其中第i个元素是某只股票在第i天的价格。
 * 如果你最多只能完成一笔交易(即买一股和卖一股股票)，设计一个算法来求最大利润。
 *
 * Say you have an array for which the i th element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 */
public class _121_BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int max = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else {
                max = Math.max(max, prices[i] - min);
            }
        }
        return max;
    }
}
