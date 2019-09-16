package leetcode;

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
    public int numIslands(char[][] grid) {
        if (grid == null) {
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
        System.out.println(curX);
        grid[curX][curY] = '0';
        dfs(curX - 1, curY, x, y, grid);
        dfs(curX + 1, curY, x, y, grid);
        dfs(curX, curY - 1, x, y, grid);
        dfs(curX, curY + 1, x, y, grid);
    }

    public static void main(String[] args) {
        char[][] chars = {{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};
        NumIslands numIslands = new NumIslands();
        System.out.println(numIslands.numIslands(chars));
    }
}
