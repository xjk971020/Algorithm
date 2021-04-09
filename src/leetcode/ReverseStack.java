package leetcode;

import java.util.Stack;

/**
 * @Author:xjk
 * @Description:
 *
 * 如何仅用递归函数和栈操作逆序一个栈
 *
 * @Date: 2021/4/8
 */
public class ReverseStack {

    public <E> void reverse(Stack<E> stack) {
        if (stack.isEmpty()) {
            return;
        }
        E e = getAndRemoveLastElement(stack);
        reverse(stack);
        stack.push(e);
    }

    public <E> E getAndRemoveLastElement(Stack<E> stack) {
        E result = stack.pop();
        if (stack.isEmpty()) {
            return result;
        }

        E last = getAndRemoveLastElement(stack);
        stack.push(result);
        return last;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack);
        ReverseStack reverseStack = new ReverseStack();
        reverseStack.reverse(stack);
        System.out.println(stack);
    }

}
