package niuke.xjk.queue;

/**
 * @author xjk
 * @date 2019/3/26 -  16:06
 * 使用数组实现队列
 **/
public class ArrayQueue {

    private int start;
    private int end;
    private int[] arr;
    /**
     * 描述数组的数的长度
     */
    private int size;

    public ArrayQueue(Integer initSize) {
        if (initSize < 0) {
            throw new ArrayIndexOutOfBoundsException("initSize less than 0");
        }
        arr = new int[initSize];
        start = end = 0;
        size = 1;
    }

    /**
     * 入队
     * @param obj
     */
    public void push(int obj) {
        if (size == arr.length) {
            throw new ArrayIndexOutOfBoundsException("Queue is full");
        }
        arr[end] = obj;
        end = end == (arr.length - 1) ? 0 : end++;
        size++;
    }

    /**
     * 出队
     * @return
     */
    public int poll() {
        if (size == 0) {
            throw new RuntimeException("Queue is empty");
        }
        size--;
        int temp = start;
        start = start == arr.length - 1 ? 0 : start++;
        return arr[start];
    }

    /**
     * 取得第一个进入队列的位置
     * @return
     */
    public int peek() {
        if (size == 0) {
            throw new RuntimeException("Queue is empty");
        }
        return arr[start];
    }


}
