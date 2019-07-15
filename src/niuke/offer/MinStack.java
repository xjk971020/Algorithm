package niuke.offer;

import java.util.Stack;

/**
 * @author:xjk 2019/7/15 15:14
 * niuke.offer
 * 包含min函数的栈
 * 题目描述
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 */
public class MinStack {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public MinStack() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int node) {
        stack1.push(node);
        if (stack2.isEmpty()) {
            stack2.push(node);
        } else if (min() > node) {
            stack2.push(node);
        } else {
            stack2.push(min());
        }
    }

    public void pop() {
        if (stack1.isEmpty()) {
            throw new RuntimeException("栈为空");
        }
        stack1.pop();
        stack2.pop();
    }

    public int top() {
        return stack1.peek();
    }

    public int min() {
        if (stack2.isEmpty()) {
            throw new RuntimeException("栈为空");
        }
        return stack2.peek();
    }
}
