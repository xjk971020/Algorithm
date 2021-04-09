package leetcode;

import java.util.Stack;

/**
 * @Description: 用一个栈实现另一个栈的排序
 * @Date: 2021/4/9
 */
public class SortStackByStack {

    Stack<Integer> help = new Stack<>();

    public void sortStack(Stack<Integer> stack) {
        if (stack == null) {
            throw new IllegalArgumentException();
        }

        while (!stack.isEmpty()) {
            int stackPop = stack.pop();
            while (!help.isEmpty() && help.peek() < stackPop) {
                stack.push(help.pop());
            }
            help.push(stackPop);
        }

        while (!help.isEmpty()) {
            stack.push(help.pop());
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(4);
        stack.push(5);
        stack.push(3);
        System.out.println(stack);

        SortStackByStack sortStackByStack = new SortStackByStack();
        sortStackByStack.sortStack(stack);
        System.out.println(stack);
    }

}
