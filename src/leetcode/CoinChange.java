package leetcode;

import java.util.Arrays;

/**
 * @Author:cathetine
 * @Date:19-9-12
 * @Time:下午3:35
 * 322. 零钱兑换
 * 给定不同面额的硬币 coins 和一个总金额 amount。
 * 编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 * 示例 2:
 * <p>
 * 输入: coins = [2], amount = 3
 * 输出: -1
 */
public class CoinChange {
    /**
     * 暴力回溯, 超时
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        return coinChange(coins, 0, amount);
    }
    private int coinChange(int[] coins, int step, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (step < coins.length && amount > 0) {
            int minCost = Integer.MAX_VALUE;
            int curMaxCost = amount/coins[step];
            for (int i = 0;  i <= curMaxCost; ++i) {
                if (amount >= i * coins[i]) {
                    int res = coinChange(coins, step+1, amount - i * coins[step]);
                    if (res != -1) {
                        minCost = Math.min(minCost, res + i);
                        return minCost;
                    }
                }
            }
            return (minCost == Integer.MAX_VALUE)?-1:minCost;
        }
        return -1;
    }

    /**
     * 自上而下的动态规划, 记忆化dp
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange_(int[] coins, int amount) {
        int[] count = new int[amount];
        return coinChange_(coins, amount, count);
    }

    private int coinChange_(int[] coins, int amount, int[] count) {
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        if (count[amount - 1] != 0) {
            return count[amount - 1];
        }
        int minCost = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int res = coinChange_(coins, amount - coins[i], count);
            if (res != -1 && res < minCost) {
                minCost = res + 1;
            }
        }
        count[amount - 1] = minCost == Integer.MAX_VALUE ? -1:minCost;
        return count[amount-1];
    }

    /**
     * 自底向上的dp
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange__(int[] coins, int amount) {
        int[] count = new int[amount + 1];
        Arrays.fill(count,amount + 1);
        count[0] = 0;
        for (int i = 1; i <= amount; ++i) {
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j]) {
                    count[i] = Math.min(count[i], count[i-coins[j]] + 1);
                }
            }
        }
        return count[amount] == amount+1?-1:count[amount];
    }
}
