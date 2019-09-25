package niuke.xjk.sort;

import niuke.xjk.util.Counter;

import java.util.Arrays;

/**
 * @author xjk
 * @date 2019/3/24 -  10:20
 * 改进后的快速排序
 * 空间复杂度O(logN)
 * 不具有稳定性
 **/
public class QuickSort {
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }
    private static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            swap(arr, left + (int)(Math.random() * (right - left + 1)), right);
            int[] partition = partition(arr, left, right);
            quickSort(arr, left, partition[0] - 1);
            quickSort(arr, partition[1] + 1, right);
        }
    }
    private static int[] partition(int[] arr, int left, int right) {
        int less = left - 1;
        int more = right;
        while (left < more) {
            if (arr[left] > arr[right]) {
                swap(arr,--more,left);
            } else if (arr[left] < arr[right]) {
                swap(arr, ++less, left++);
            } else {
                left++;
            }
        }
        swap(arr, more,right);
        return new int[]{less + 1, more};
    }
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = Counter.generateRandomArray(40,100);
        System.out.println(Arrays.toString(arr));
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
}
}
