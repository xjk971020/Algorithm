package niuke.offer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author xjk
 * @date 2019/6/24 -  12:01
 * 最小的K个数
 * 题目描述
 * 输入n个整数，找出其中最小的K个数。
 * 例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 **/
public class GetLeastNumbers {
    /**
     * 构建一个大根堆, 将数据流中的数依次加到堆中, 此过程中保证每次大根堆中大的数是数据流中最小的几个数
     * @param input
     * @param k
     * @return
     */
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        //此处需要注意边界, k == 0 的时候
        if (input == null || input.length == 0 || k <= 0) {
            return result;
        }
        if (k > input.length) {
            throw new RuntimeException("k不能大于input数组的长度");
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int anInput : input) {
            if (maxHeap.size() != k) {
                maxHeap.offer(anInput);
            } else if (maxHeap.peek() > anInput) {
                Integer temp = maxHeap.poll();
                temp = null;
                maxHeap.offer(anInput);
            }
        }
        maxHeap.forEach(var -> {
            result.add(var);
        });
        return result;
    }
}
