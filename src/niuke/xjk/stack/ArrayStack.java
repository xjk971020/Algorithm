package niuke.xjk.stack;

/**
 * @author xjk
 * @date 2019/3/26 -  14:36
 * 使用数组实现栈
 **/
public class ArrayStack {
    private Integer index;
    private Integer[] arr;

    /**
     * 构造函数，需传入初始大小
     * @param initSize
     */
    public ArrayStack(int initSize) {
        if (initSize < 0) {
            throw new ArrayIndexOutOfBoundsException("initSize less than 0");
        }
        arr = new Integer[initSize];
        index = 0;
    }

    /**
     * 压栈
     * @param obj
     */
    public void push(int obj) {
        if (index == arr.length) {
            throw new ArrayIndexOutOfBoundsException("The Queue is full");
        }
        arr[index++] = obj;
    }

    /**
     * 出栈
     * @return
     */
    public Integer pop() {
        if (index == 0) {
            throw new ArrayIndexOutOfBoundsException("The Queue is empty");
        }
        return arr[--index];
    }

    /**
     * 取出栈顶元素
     * @return
     */
    public Integer peek() {
        if (index == 0) {
            return null;
        }
        return arr[index - 1];
    }

    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(10);
        arrayStack.push(10);
        arrayStack.push(20);
        Integer one = arrayStack.pop();
        System.out.println(one);
        System.out.println(arrayStack.peek());
    }
}
