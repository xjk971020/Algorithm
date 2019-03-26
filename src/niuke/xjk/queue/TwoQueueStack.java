package niuke.xjk.queue;


import java.util.LinkedList;
import java.util.Queue;

/**
 * @author xjk
 * @date 2019/3/26 -  19:24
 * 使用两个队列实现栈
 **/
public class TwoQueueStack {
    private Queue<Integer> data;
    private Queue<Integer> help;
    public TwoQueueStack() {
        data = new LinkedList<>();
        help = new LinkedList<>();
    }

    /**
     * 入栈
     * @param newNum
     */
    public void push(int newNum) {
        data.add(newNum);
    }

    /**
     * 出栈
     * @return
     */
    public int pop() {
        if (data.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        while (data.size() > 1) {
            help.add(data.poll());
        }
        Integer temp = data.poll();
        swap();
        return temp;
    }

    /**
     * 获得栈顶元素
     * @return
     */
    public int peek() {
        if (data.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        while (data.size() > 1) {
            help.add(data.poll());
        }
        int res = data.poll();
        help.add(res);
        swap();
        return res;
    }

    /**
     * 交换两个队列
     */
    public void swap() {
        Queue<Integer> temp = new LinkedList<>();
        temp = data;
        data = help;
        help = temp;
    }

    public static void main(String[] args) {
        TwoQueueStack stack = new TwoQueueStack();
        stack.push(10);
        stack.push(30);
        stack.push(20);
        System.out.println(stack.peek());
    }

}
