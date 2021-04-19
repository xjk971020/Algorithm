package leetcode;

import java.util.Stack;

/**
 * @Author:xjk
 * @Description:
 *
 * 739. 每日温度
 *
 * 请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 *
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 *
 * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/daily-temperatures
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Date: 2021/4/12
 */
public class _739_DailyTemperatures {

    /**
     * 使用单调栈，栈的存放的数据是数组的索引位，栈的排序是根据温度单调递减
     * @param T
     * @return
     */
    public int[] dailyTemperatures(int[] T) {
        if (T == null || T.length == 0) {
            return new int[0];
        }

        Stack<Integer> indexStack = new Stack<>();

        int[] result = new int[T.length];

        for (int i = 0; i < T.length; ++ i) {
            while(!indexStack.isEmpty() && T[indexStack.peek()] < T[i]) {
                result[indexStack.peek()] = i - indexStack.peek();
                indexStack.pop();
            }
            indexStack.push(i);
        }

        return result;
    }

}
