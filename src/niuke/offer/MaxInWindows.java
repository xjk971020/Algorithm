package niuke.offer;

import java.util.ArrayList;
import java.util.LinkedList;
/**
 * @Author:xjk
 * @Date 2019/7/1 14:55
 * 滑动窗口的最大值
 * 题目描述
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。 
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，
 * 那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}； 
 * 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 */
public class MaxInWindows {
    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> list = new ArrayList<>();
        if (num == null || num.length == 0 || size <= 0 || num.length < size) {
            return list;
        }
        LinkedList<Integer> indexMax = new LinkedList<>();
        for (int i = 0; i < num.length; ++i) {
            while (!indexMax.isEmpty() && num[i] > num[indexMax.peekLast()]) {
                indexMax.removeLast();
            }
            indexMax.addLast(i);
            if (indexMax.peekFirst() == i - size) {
                indexMax.removeFirst();
            }
            if (i >= size - 1) {
                list.add(num[indexMax.peekFirst()]);
            }
        }
        return list;
     }
}
