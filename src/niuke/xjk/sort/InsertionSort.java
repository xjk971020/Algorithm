package niuke.xjk.sort;

import niuke.xjk.util.Counter;

import java.util.Arrays;

/**
 * @author xjk
 * @date 2019/3/20 -  15:44
 * 插入排序
 * 具有稳定性
 **/
public class InsertionSort {

    public static int[] insertionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return arr;
        }
        for (int i = 1; i < arr.length; ++i) {
            for (int j = i - 1; j >= 0; --j) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                } else {
                    break;
                }
            }
        }
        return arr;
    }

    private static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    public static void main(String[] args) {
        int[] arr = Counter.generateRandomArray(40,100);
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
