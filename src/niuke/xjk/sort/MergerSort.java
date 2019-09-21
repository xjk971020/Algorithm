package niuke.xjk.sort;

import java.util.Arrays;

/**
 * @author xjk
 * @date 2019/3/22 -  16:31
 * 归并排序
 * 递归
 * 具有稳定性
 **/
public class MergerSort {
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        mergeProcess(arr,0,arr.length-1);
    }
    private static void mergeProcess(int[] arr, int left, int right) {
        if (left == right) {
            return;
        }
        int mid = left + ((right - left) >> 1);
        mergeProcess(arr, left, mid);
        mergeProcess(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }
    private static void merge(int[] arr, int left, int mid, int right) {
        int[] help = new int[right - left + 1];
        int p1 = left;
        int p2 = mid + 1;
        int index = 0;
        while (p1 <= mid && p2 <= right) {
            help[index++] = arr[p1] <= arr[p2] ? arr[p1++]:arr[p2++];
        }
        while (p1 <= mid) {
            help[index++] = arr[p1++];
        }
        while (p2 <= right) {
            help[index++] = arr[p2++];
        }
        for (index = 0;  index < help.length; ++ index) {
            arr[left+index] = help[index];
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,4,6,2,3};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
