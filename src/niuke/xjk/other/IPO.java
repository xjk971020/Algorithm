package niuke.xjk.other;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author xjk
 * @date 2019/4/24 -  23:09
 * 输入： 参数1，正数数组costs 参数2，正数数组profits 参数3， 正数k
 * 参数4，正数m costs[i]表示i号项目的花费 profits[i]表示i号项目在扣除花费之后还能挣到的钱(利润)
 * k表示你不能并行、只能串行的最多 做k个项目 m表示你初始的资金
 * 说明：你每做完一个项目，马上获得的收益，可以支持你去做下 一个 项目。
 * 输出： 你最后获得的最大钱数
 **/
public class IPO {
    /**
     * 表示一个项目
     */
    public static class Node{
        int profit;
        int cost;
        public Node(int profit, int cost) {
            this.profit = profit;
            this.cost = cost;
        }
    }

    /**
     * 项目花费的比较器
     * 可以构造一个花费的小根堆
     */
    public static class minCostComparator implements Comparator<Node> {
        @Override
        public int compare(Node o1,Node o2) {
            return o1.cost - o2.cost;
        }
    }

    /**
     * 项目利润的比较器
     * 可以构造一个利润的大根堆
     */
    public static class maxProfitComparator implements Comparator<Node> {

        @Override
        public int compare(Node o1, Node o2) {
            return o2.profit - o1.profit;
        }
    }

    /**
     * @param count 项目数量
     * @param initMoney 初始基金
     * @param cost 项目消费数组
     * @param profit 项目利润数组
     * @return
     */
    public static int getMaximizedCapital(int count,int initMoney,int[] cost,int[] profit) {
        Node[] nodes = new Node[cost.length];
        for (int i = 0; i < cost.length; i++) {
            nodes[i] = new Node(cost[i],profit[i]);
        }
        //构建消费的小根堆
        PriorityQueue<Node> minCostQueue = new PriorityQueue<>(new minCostComparator());
        for (int i = 0; i < nodes.length; i++) {
            minCostQueue.add(nodes[i]);
        }
        //构建利润的大根堆
        PriorityQueue<Node> maxProfitQueue = new PriorityQueue<>(new maxProfitComparator());
        for (int i = 0; i < count; ++i) {
            while (!minCostQueue.isEmpty() && minCostQueue.peek().cost < initMoney) {
                maxProfitQueue.add(minCostQueue.poll());
            }
            if (maxProfitQueue.isEmpty()) {
                return initMoney;
            }
            initMoney += maxProfitQueue.poll().profit;
        }
        return initMoney;
    }
}
