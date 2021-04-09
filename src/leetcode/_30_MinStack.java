package leetcode;

import java.util.Stack;

/**
 * @Author:xjk
 * @Description: 30. 包含min函数的栈
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.min();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.min();   --> 返回 -2.
 *  
 * <p>
 * 提示：
 * <p>
 * 各函数的调用总次数不超过 20000 次
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2021/4/8
 */
public class _30_MinStack {

    private Stack<Integer> oriStack;
    private Stack<Integer> minStack;

    /**
     * initialize your data structure here.
     */
    public _30_MinStack() {
        oriStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        if (oriStack.isEmpty()) {
            oriStack.push(x);
            minStack.push(x);
            return;
        }

        if (x <= minStack.peek()) {
            minStack.push(x);
        }


        oriStack.push(x);
    }

    public void pop() {
        if (oriStack.isEmpty()) {
            throw new RuntimeException();
        }

        int oriPop = oriStack.pop();
        if (!minStack.isEmpty() && oriPop == minStack.peek()) {
            minStack.pop();
        }

    }

    public int top() {
        if ( oriStack.isEmpty()) {
            throw new RuntimeException();
        }
        return oriStack.peek();
    }

    public int min() {
        if (minStack.isEmpty()) {
            throw new RuntimeException();
        }
        return minStack.peek();
    }
}
