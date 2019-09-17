package leetcode;

import java.util.LinkedList;

/**
 * @Author:cathetine
 * @Date:19-9-16
 * @Time:下午10:02
 * 200. 岛屿数量
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。
 * 一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。
 * 你可以假设网格的四个边均被水包围。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-islands
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NumIslands {
    /**
     * 深度优先遍历
     *
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int x = grid[0].length;
        int y = grid.length;
        int count = 0;
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(j, i, x, y, grid);
                }
            }
        }
        return count;
    }

    private void dfs(int curX, int curY, int x, int y, char[][] grid) {
        if (curX < 0 || curY < 0 || curX >= x || curY >= y || grid[curY][curX] == '0') {
            return;
        }
        grid[curY][curX] = '0';
        dfs(curX - 1, curY, x, y, grid);
        dfs(curX + 1, curY, x, y, grid);
        dfs(curX, curY - 1, x, y, grid);
        dfs(curX, curY + 1, x, y, grid);
    }

    /**
     * 广度优先遍历
     *
     * @param grid
     * @return
     */
    public int numIslands_(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int cols = grid[0].length;
        int rows = grid.length;
        boolean[][] marked = new boolean[rows][cols];
        //岛屿数量
        int count = 0;
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!marked[i][j] && grid[i][j] == '1') {
                    count++;
                    queue.addFirst(i * cols + j);
                    marked[i][j] = true;
                    while (!queue.isEmpty()) {
                        int index = queue.removeFirst();
                        int curX = index % cols;
                        int curY = index / cols;
                        for (int z = 0; z < 4; ++z) {
                            int newX = curX + directions[z][0];
                            int newY = curY + directions[z][1];
                            boolean inArea = newX >= 0 && newY >= 0 && newX < cols && newY < rows;
                            if (inArea && !marked[newY][newX] && grid[newY][newX] == '1') {
                                queue.addFirst(newY * cols + newX);
                                marked[newY][newX] = true;
                            }
                        }
                    }
                }
            }
        }
        return count;
    }


    public static void main(String[] args) {
        char[][] chars = {{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};
        NumIslands numIslands = new NumIslands();
        System.out.println(numIslands.numIslands_(chars));
    }
}
