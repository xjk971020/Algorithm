package niuke.offer;

/**
 * @Author:xjk
 * @Date 2019/7/8 22:21
 * 机器人的运动范围
 * 题目描述
 * 地上有一个m行和n列的方格。
 * 一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
 * 但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 */
public class MovingCount {
    public int movingCount(int threshold, int rows, int cols) {
        boolean[][] flag = new boolean[rows][cols];
        return helper(0, 0, rows, cols, flag, threshold);
    }

    private int helper(int i, int j, int rows, int cols, boolean[][] flag, int threshold) {
        if (i < 0 || i >= rows || j < 0 || j >= cols || sum(i) + sum(j) > threshold || flag[i][j]) {
            return 0;
        }
        flag[i][j] = true;
        return helper(i + 1, j, rows, cols, flag, threshold)
                + helper(i - 1, j, rows, cols, flag, threshold)
                + helper(i, j + 1, rows, cols, flag, threshold)
                + helper(i, j - 1, rows, cols, flag, threshold)
                + 1;
    }

    private int sum(int i) {
        int count = 0;
        do {
            count += i % 10;
        } while ((i = i / 10) > 0);
        return count;
    }
}
