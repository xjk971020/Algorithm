package leetcode;

import java.util.Arrays;
import java.util.Stack;

/**
 * @Author:xjk
 * @Description:
 *
 * 503. 下一个更大元素 II
 *
 * 给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。
 * 数字 x 的下一个更大的元素是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。
 * 如果不存在，则输出 -1。
 *
 * 示例 1:
 *
 * 输入: [1,2,1]
 * 输出: [2,-1,2]
 * 解释: 第一个 1 的下一个更大的数是 2；
 * 数字 2 找不到下一个更大的数；
 * 第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-greater-element-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Date: 2021/4/12
 */
public class _503_NextGreaterElements {

    public int[] nextGreaterElements(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        //维护一个索引的单调递减栈
        Stack<Integer> indexStack = new Stack<>();
        int[] result = new int[nums.length];
        Arrays.fill(result, -1);

        for (int i = 0; i < nums.length; ++i) {
            while (!indexStack.isEmpty() && nums[indexStack.peek()] < nums[i]) {
                Integer curMinIndex = indexStack.pop();
                result[curMinIndex] = nums[i];
            }
            //将本次的索引加入栈中
            indexStack.push(i);
        }

        for (int i = 0; i < nums.length; ++i) {
            while (!indexStack.isEmpty() && nums[indexStack.peek()] < nums[i]) {
                Integer curMinIndex = indexStack.pop();
                result[curMinIndex] = nums[i];
            }
        }

        return result;
    }

}
