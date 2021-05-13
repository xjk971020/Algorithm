package leetcode;

import java.util.Stack;

/**
 * @Author:xjk
 * @Description:
 *
 * 85. 最大矩形
 *
 * 给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 *
 * @Date: 2021/4/20
 */
public class _85_MaximalRectangle {


    public int maximalRectangle(char[][] matrix) {

        if (matrix == null) {
            throw new IllegalArgumentException();
        }

        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int[] heights = new int[matrix[0].length];
        int maxArea = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                heights[j] = matrix[i][j] == '0' ? 0 : heights[j] + 1;
            }
            maxArea = Math.max(maxRecFromBottom(heights), maxArea);
        }

        return maxArea;
    }

    private int maxRecFromBottom(int[] heights) {
        int curMaxArea = 0;
        Stack<Integer> indexStack = new Stack<>();

        for (int i = 0; i < heights.length; i++) {
            while (!indexStack.isEmpty() && heights[indexStack.peek()] >= heights[i]) {
                int curHeightIndex = indexStack.pop();
                int end = i - 1;
                int start = indexStack.isEmpty() ? -1 : indexStack.peek();
                int curArea = (end - start) * heights[curHeightIndex];
                curMaxArea = Math.max(curArea, curMaxArea);
            }
            indexStack.push(i);
        }

        while (!indexStack.isEmpty()) {
            int curHeightIndex = indexStack.pop();
            int end = heights.length - 1;
            int start = indexStack.isEmpty() ? -1 : indexStack.peek();
            int curArea = (end - start) * heights[curHeightIndex];
            curMaxArea = Math.max(curArea, curMaxArea);
        }

        return curMaxArea;
    }
}
