package leetcode;

import java.util.Stack;

/**
 * @Author:cathetine
 * @Date:19-8-26 下午11:28
 * largest-rectangle-in-histogram
 * https://www.nowcoder.com/practice/e3f491c56b7747539b93e5704b6eca40?tpId=46&tqId=29094&tPage=1&rp=1&ru=/ta/leetcode&qru=/ta/leetcode/question-ranking
 */
public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length < 1)
            return 0;

        Stack<Integer> stack = new Stack<Integer>();
        stack.push(-1);
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            while (stack.peek() != -1 && heights[i] < heights[stack.peek()]) {
                int top = stack.pop();
                max = Math.max(max, (i - stack.peek() - 1) * heights[top]);
            }
            stack.push(i);
        }
        while (stack.peek() != -1) {
            int top = stack.pop();
            max = Math.max(max, (heights.length - 1 - stack.peek()) * heights[top]);
        }
        return max;
    }
}
