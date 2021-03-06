package leetcode;

import java.util.Arrays;

/**
 * @Author:cathetine
 * @Date:19-8-31
 * @Time:上午10:15
 * 1029. 两地调度
 *
 * 公司计划面试 2N 人。第 i 人飞往 A 市的费用为 costs[i][0]，飞往 B 市的费用为 costs[i][1]。
 *
 * 返回将每个人都飞到某座城市的最低费用，要求每个城市都有 N 人抵达。
 *
 *  
 *
 * 示例：
 *
 * 输入：[[10,20],[30,200],[400,50],[30,20]]
 * 输出：110
 * 解释：
 * 第一个人去 A 市，费用为 10。
 * 第二个人去 A 市，费用为 30。
 * 第三个人去 B 市，费用为 50。
 * 第四个人去 B 市，费用为 20。
 *
 * 最低总费用为 10 + 30 + 50 + 20 = 110，每个城市都有一半的人在面试。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-city-scheduling
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TwoCitySchedCost {
    public int twoCitySchedCost(int[][] costs) {
        int rows = costs.length;
        int totalCost = 0;
        for (int i = 0; i < costs.length; i++) {
            totalCost += costs[i][0];
        }
        int[] help = new int[costs.length];
        for (int i = 0; i < help.length; i++) {
            help[i] = costs[i][0] - costs[i][1];
        }
        Arrays.sort(help);
        for (int i = help.length - 1; i > rows/2; --i) {
            totalCost -= help[i];
        }
        return totalCost;
    }
}
