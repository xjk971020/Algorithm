package niuke.xjk.sort;

import java.util.Arrays;

/**
 * @author xjk
 * @date 2019/3/23 -  10:39
 * 小和问题
 * 利用归并排序的思想进行求解
 * 题目详情 左程云-初级1
 **/
public class SmallSum {
    public static int smallSum(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        return mergeSort(arr, 0, arr.length - 1);
    }

    public static int mergeSort(int[] arr, int left, int right) {
        if (left == right) {
            return 0;
        }
        int mid = left + ((right - left) >> 1);
        return mergeSort(arr, left, mid) +
                mergeSort(arr, mid + 1, right) +
                merge(arr, left, mid, right);
    }

    public static int merge(int[] arr, int left, int mid, int right) {
        int[] help = new int[right - left + 1];
        int i = 0;
        int p1 = left;
        int p2 = mid + 1;
        int res = 0;
        while (p1 <= mid && p2 <= right) {
            res += arr[p1] < arr[p2] ? (right - p2 + 1) * arr[p1] : 0;
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }
        while (p2 <= right) {
            help[i++] = arr[p2++];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 6, 2, 3};
        System.out.println(smallSum(arr));
    }
}