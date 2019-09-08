package leetcode;

import java.util.Arrays;

/**
 * @Author:cathetine
 * @Date:19-9-8
 * @Time:下午3:22
 * 62. 不同路径
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 问总共有多少条不同的路径？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-paths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class UniquePaths {
    /**
     * 递归, 超时
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        if (m <= 0 || n <= 0) {
            throw new RuntimeException("m或者n的值不能小于等于0");
        }
        if (m == 1 || n == 1) {
            return 1;
        }
        return process(1,1,m,n);
    }
    private int process(int x, int y, int m, int n) {
        if (x < 1 || y < 1 || x > m || y > n) {
            return 0;
        }
        if (x == m && y == n) {
            return 1;
        }
        return process(x + 1, y,m,n) + process(x, y+1,m,n);
    }

    /**
     * 空间复杂度为O(n)级别的动态规划
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths_(int m, int n) {
        if (m <= 0 || n <= 0) {
            throw new RuntimeException("m或者n的值不能小于等于0");
        }
        if (m == 1 || n == 1) {
            return 1;
        }
        int[] cur = new int[n];
        Arrays.fill(cur,1);
        for (int i = 1; i < m; ++i) {
            for  (int j = 1; j < n; ++j) {
                cur[j] = cur[j] + cur[j-1];
            }
        }
        return cur[n-1];
    }
}
