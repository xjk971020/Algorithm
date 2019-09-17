package leetcode;

import java.util.LinkedList;

/**
 * @Author:cathetine
 * @Date:19-9-17
 * @Time:上午11:22
 * 695. 岛屿的最大面积
 * 给定一个包含了一些 0 和 1的非空二维数组 grid , 一个 岛屿 是由四个方向 (水平或垂直) 的 1 (代表土地) 构成的组合。你可以假设二维矩阵的四个边缘都被水包围着。
 * <p>
 * 找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为0。)
 * <p>
 * 示例 1:
 * <p>
 * [[0,0,1,0,0,0,0,1,0,0,0,0,0],
 * [0,0,0,0,0,0,0,1,1,1,0,0,0],
 * [0,1,1,0,1,0,0,0,0,0,0,0,0],
 * [0,1,0,0,1,1,0,0,1,0,1,0,0],
 * [0,1,0,0,1,1,0,0,1,1,1,0,0],
 * [0,0,0,0,0,0,0,0,0,0,1,0,0],
 * [0,0,0,0,0,0,0,1,1,1,0,0,0],
 * [0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * 对于上面这个给定矩阵应返回 6。注意答案不应该是11，因为岛屿只能包含水平或垂直的四个方向的‘1’。
 * <p>
 * 示例 2:
 * <p>
 * [[0,0,0,0,0,0,0,0]]
 * 对于上面这个给定的矩阵, 返回 0。
 * <p>
 * 注意: 给定的矩阵grid 的长度和宽度都不超过 50。
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/max-area-of-island
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxAreaOfIsland {
    /**
     * 广度优先遍历
     *
     * @param grid
     * @return
     */
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        int maxArea = Integer.MIN_VALUE;
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] marked = new boolean[rows][cols];
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!marked[i][j] && grid[i][j] == 1) {
                    int curCount = 1;
                    marked[i][j] = true;
                    queue.addLast(i * cols + j);
                    while (!queue.isEmpty()) {
                        int curIndex = queue.removeFirst();
                        int curX = curIndex % cols;
                        int curY = curIndex / cols;
                        for (int k = 0; k < directions.length; ++k) {
                            int newX = curX + directions[k][0];
                            int newY = curY + directions[k][1];
                            boolean inArea = newX >= 0 && newY >= 0 && newX < cols && newY < rows;
                            if (inArea && !marked[newY][newX] && grid[newY][newX] == 1) {
                                curCount++;
                                queue.addLast(newY * cols + newX);
                                marked[newY][newX] = true;
                            }
                        }
                    }
                    maxArea = Math.max(maxArea, curCount);
                }
            }
        }
        return maxArea;
    }

    private int count = 0;
    private int rows;
    private int cols;

    /**
     * 深度优先遍历
     *
     * @param grid
     * @return
     */
    public int maxAreaOfIsland_(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        rows = grid.length;
        cols = grid[0].length;
        boolean[][] seen = new boolean[rows][cols];
        int maxArea = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!seen[i][j] && grid[i][j] == 1) {
                    count = 0;
                    dfs(j, i, grid, seen);
                    maxArea = Math.max(maxArea, count);
                }
            }
        }
        return maxArea;
    }

    private void dfs(int x, int y, int[][] grid, boolean[][] seen) {
        if (x < 0 || y < 0 || x >= cols || y >= rows || grid[y][x] == 0 || seen[y][x]) {
            return;
        }
        count++;
        grid[y][x] = 0;
        seen[y][x] = true;
        dfs(x - 1, y, grid, seen);
        dfs(x + 1, y, grid, seen);
        dfs(x, y - 1, grid, seen);
        dfs(x, y + 1, grid, seen);
    }

    public static void main(String[] args) {
        int[][] chars = {{1,1,0,1,1},{1,0,0,0,0},{0,0,0,0,1},{1,1,0,1,1}};
        MaxAreaOfIsland maxAreaOfIsland = new MaxAreaOfIsland();
        System.out.println(maxAreaOfIsland.maxAreaOfIsland_(chars));
    }
}
