package niuke.xjk.sort;

import niuke.xjk.util.Counter;

import java.util.Arrays;

/**
 * @author xjk
 * @date 2019/3/20 -  15:12
 * 选择排序
 * 不具有稳定性
 **/
public class SelectionSort {

    public static int[] selectionSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return arr;
        }
        for (int i = 0; i < arr.length - 1; ++i){
            int minIndex = i;
            for (int j = i + 1; j < arr.length; ++j) {
                minIndex = arr[minIndex] > arr[j]?j:minIndex;
            }
            if (minIndex != i) {
                swap(arr, minIndex, i);
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
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
