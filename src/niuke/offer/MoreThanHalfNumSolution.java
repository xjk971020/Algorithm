package niuke.offer;

/**
 * author:xjk
 * 2019/6/18 10:33
 * niuke.offer
 * 数组中出现次数超过一半的数字
 * 题目描述:
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class MoreThanHalfNumSolution {
    public int moreThanHalfNumSolution(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int times = 1;
        int curNum = array[0];
        for (int i = 1; i < array.length; ++i) {
            if (array[i] == curNum) {
                times++;
            } else {
                if (times == 0) {
                    curNum = array[i];
                } else {
                    times--;
                }
            }
        }
        times = 0;
        for (int anArray : array) {
            if (anArray == curNum) {
                times++;
            }
        }
        if (times > array.length / 2) {
            return curNum;
        }
        return 0;
    }
}
