package leetcode;

import java.util.List;

/**
 * @Author:cathetine
 * @Date:19-9-4
 * @Time:下午10:10
 * 120. 三角形最小路径和
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 *
 * 例如，给定三角形：
 *
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 */
public class MinimumTotal {
    Integer[][] help;
    public int minimumTotal(List<List<Integer>> triangle) {
        help = new Integer[triangle.size()][triangle.size()];
        return process(triangle, 0, 0);
    }
    private int process(List<List<Integer>> triangle, int row, int index) {
        if (help[row][index] != null) {
            return help[row][index];
        }
        if (row == triangle.size() - 1) {
            return triangle.get(row).get(index);
        }
        int left = process(triangle,row + 1, index);
        int right = process(triangle,row + 1, index + 1);
        help[row][index] = Math.min(left, right) + triangle.get(row).get(index);
        return help[row][index];
    }
}
