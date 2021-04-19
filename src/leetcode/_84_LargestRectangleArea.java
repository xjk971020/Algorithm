package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author:xjk
 * @Description:
 * 84. 柱状图中最大的矩形
 *
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 *
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 *
 * 输入: [2,1,5,6,2,3]
 * 输出: 10
 *
 * @Date: 2021/4/19
 */
public class _84_LargestRectangleArea {

    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }

        int largestArea = 0;
        Stack<Integer> indexStack = new Stack<>();

        for (int i = 0; i < heights.length; i++) {
            while (!indexStack.isEmpty() && heights[indexStack.peek()] > heights[i]) {
                int curHeight = indexStack.pop();

                while (!indexStack.isEmpty() && curHeight == heights[indexStack.peek()]) {
                    curHeight = indexStack.pop();
                }

                int curWidth = indexStack.isEmpty() ? i : i - indexStack.peek() - 1;
                int curArea = curWidth * curHeight;

                largestArea = Math.max(curArea, largestArea);
            }

            indexStack.push(i);
        }

        while (!indexStack.isEmpty()) {
            int curHeight = indexStack.pop();

            while (!indexStack.isEmpty() && curHeight == heights[indexStack.peek()]) {
                curHeight = indexStack.pop();
            }

            int curWidth = indexStack.isEmpty() ? heights.length : heights.length - indexStack.peek() - 1;
            int curArea = curWidth * curHeight;

            largestArea = Math.max(curArea, largestArea);
        }

        return largestArea;
    }

    public static void main(String[] args) {
        int[] input = {2,1,5,6,2,3};
        _84_LargestRectangleArea algorithm = new _84_LargestRectangleArea();
        int res = algorithm.largestRectangleArea(input);
        System.out.println(res);

    }

}
