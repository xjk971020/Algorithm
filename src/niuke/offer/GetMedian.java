package niuke.offer;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author:xjk 2019/7/26 9:41
 * niuke.offer
 * 数据流中的中位数
 * 题目描述
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，
 * 那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * 我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 */
public class GetMedian {
    /**
     * 优先级队列默认为小根堆
     */
    private PriorityQueue<Integer> minHeap;
    /**
     * 传入比较器将它初始化为大根堆
     */
    private PriorityQueue<Integer> maxHeap;
    /**
     * 记录数据流的个数为第几个
     */
    private int count;

    public GetMedian() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        count = 0;
    }

    public void Insert(Integer num) {
        count++;
        //偶数进入大根堆
        if ((count & 1) == 0) {
            if (!minHeap.isEmpty() && minHeap.peek() < num) {
                maxHeap.offer(minHeap.poll());
                minHeap.offer(num);
            } else {
                maxHeap.offer(num);
            }
        //基数进入小根堆
        } else {
            if (!maxHeap.isEmpty() && maxHeap.peek() > num) {
                maxHeap.offer(num);
                minHeap.offer(maxHeap.poll());
            } else {
                minHeap.offer(num);
            }
        }
    }

    public Double GetMedian() {
        if (maxHeap.isEmpty() && minHeap.isEmpty()) {
            throw new RuntimeException("没有数据");
        }
        if ((count & 1) == 0) {
            return  new Double(maxHeap.peek() + minHeap.peek())/2;
        } else {
            return new Double(minHeap.peek());
        }
    }
}
