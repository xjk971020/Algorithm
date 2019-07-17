package niuke.offer;

import java.util.ArrayList;

/**
 * @author:xjk 2019/7/17 11:32
 * niuke.offer
 * 数组中只出现一次的数字
 * 题目描述
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 */
public class FindNumsAppearOnce {
    public void findNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if (array == null || array.length < 2) {
            throw new RuntimeException("数组不能为空或长度不能小于2");
        }
        if (array.length == 2) {
            num1[0] = array[0];
            num2[0] = array[1];
            return;
        }
        quickSort(array, 0, array.length - 1);
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < array.length; ++i) {
            if (i + 1 < array.length && array[i] == array[i+1]) {
                ++i;
            } else {
                result.add(array[i]);
            }
        }
        num1[0] = result.get(0);
        num2[0] = result.get(1);
    }

    /**
     * 快速排序
     */
    private void quickSort(int[] array, int left, int right) {
        if (left < right) {
           swap(array, left, left + (int)Math.random()*(right - left + 1));
           int[] position = process(array, left, right);
           quickSort(array, left, position[0] - 1);
           quickSort(array, position[1] + 1, right);
        }
    }

    private int[] process(int[] array, int left, int right) {
        int less = left - 1;
        int more = right;
        while(right < more) {
            if (array[left] < array[right]) {
                swap(array, ++less, left++);
            } else if (array[left] > array[right]) {
                swap(array, --more, left);
            } else {
                left++;
            }
        }
        swap(array, more, right);
        return new int[]{less + 1,more};
    }

    private void swap( int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
