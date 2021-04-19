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

        int[][] smallIndex = getNearSmallIndex(heights);

        int largestArea = 0;

        for (int i = 0; i < heights.length; i++) {
            int leftSmallIndex = smallIndex[i][0];
            int rightSmallIndex = smallIndex[i][1];
            int width = 0;
            if (leftSmallIndex == -1 && rightSmallIndex == -1) {
                width = heights.length;
            }
            if (leftSmallIndex == -1) {
                width = smallIndex[i][1] - leftSmallIndex;
            }
            if (rightSmallIndex == -1) {
                width = heights.length - smallIndex[i][0];
            }
            int curArea = width * heights[i];

        }

        return largestArea;
    }

    public int[][] getNearSmallIndex(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return null;
        }

        int[][] result = new int[numbers.length][2];
        //存放相同的数组下标的栈
        Stack<List<Integer>> indexStack = new Stack<>();

        for (int i = 0; i < numbers.length; i++) {
            while (!indexStack.isEmpty() && numbers[indexStack.peek().get(0)] > numbers[i]) {
                List<Integer> currEqIndexList = indexStack.pop();
                int leftSmallIndex = indexStack.isEmpty() ? -1 : indexStack.peek().get(0);
                int rightSmallIndex = i;

                for (Integer currEqIndex : currEqIndexList) {
                    result[currEqIndex][0] = leftSmallIndex;
                    result[currEqIndex][1] = rightSmallIndex;
                }
            }

            if (indexStack.isEmpty() || numbers[indexStack.peek().get(0)] != numbers[i]) {
                List<Integer> newEqIndexList = new ArrayList<>();
                newEqIndexList.add(i);
                indexStack.add(newEqIndexList);
            } else {
                List<Integer> currEqIndexList = indexStack.peek();
                currEqIndexList.add(i);
            }
        }

        while (!indexStack.isEmpty()) {
            List<Integer> currEqIndexList = indexStack.pop();
            int leftSmallIndex = indexStack.isEmpty() ? -1 : indexStack.peek().get(0);
            int rightSmallIndex= -1;
            for (Integer currEqIndex : currEqIndexList) {
                result[currEqIndex][0] = leftSmallIndex;
                result[currEqIndex][1] = rightSmallIndex;
            }
        }

        return result;
    }

}
