package niuke.xjk.stack;

import java.util.Stack;

/**
 * @author xjk
 * @date 2019/3/26 -  19:08
 * 从栈中获取最小的元素
 **/
public class GetMinStack {
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;
    public  GetMinStack() {
        stackData = new Stack<>();
        stackMin = new Stack<>();
    }

    /**
     * 入栈
     * @param newNum
     */
    public void push(int newNum) {
        if (stackMin == null || stackMin.isEmpty()) {
            stackMin.push(newNum);
        } else if (newNum < getMin()) {
            stackMin.push(newNum);
        } else {
            stackMin.push(getMin());
        }
        stackData.push(newNum);
    }

    /**
     * 出栈
     * @return
     */
    public int pop() {
        if (stackData.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        stackMin.pop();
        return stackData.pop();
    }

    /**
     * 获取stackMin中的栈顶元素，即压入栈中的所有树的最小值
     * @return
     */
    public int getMin() {
        if (stackMin == null || stackMin.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return stackMin.peek();
    }

    public static void main(String[] args) {
        GetMinStack stack = new GetMinStack();
        stack.push(10);
        stack.push(30);
        stack.push(20);
        System.out.println(stack.getMin());
    }
}
