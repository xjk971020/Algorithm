package niuke.offer;

import java.util.ArrayList;

/**
 * @author xjk
 * @date 2019/5/17 -  23:27
 * 和为S的两个数字
 * 题目描述
 * 输入一个递增排序的数组和一个数字S，
 * 在数组中查找两个数，使得他们的和正好是S，
 * 如果有多对数字的和等于S，输出两个数的乘积最小的。
 **/
public class FindNumbersWithSum {
    /**
     * 思路:两个指针,一个从后往前,一个从前往后扫,将这两个位置的数相加看是否等于sum
     * 利用数学规律,两个数和相等时, 差越大, 则乘积越小
     * @param array
     * @param sum
     * @return
     */
    public ArrayList<Integer> findNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> list = new ArrayList<>();
        if (array == null || array.length < 2) {
            return list;
        }
        int i = 0;
        int j = array.length - 1;
        while (i < j) {
            if (array[i] + array[j] == sum) {
                list.add(array[i]);
                list.add(array[j]);
                return list;
            } else if (array[i] + array[j] > sum) {
                --j;
            } else {
                ++i;
            }
        }
        return list;
    }
}
