package niuke.xjk.sort;

import java.util.Arrays;

/**
 * @author xjk
 * @date 2019/3/22 -  16:31
 * 归并排序
 * 递归
 **/
public class MergerSort {
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        sortProcess(arr, 1, arr.length - 1 );
    }

    public static void sortProcess(int[] arr,int left, int right) {
        if (left == right ) {
            return;
        }
        int mid =  left + ((right - left) >> 1);
        sortProcess(arr,left,mid);
        sortProcess(arr,mid + 1, right);
        merge(arr,left,right,mid);
    }

    public static void merge(int[] arr,int left, int right, int mid) {
        int[] help= new int[right - left + 1];
        int i = 0;
        int p1 = left;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= right) {
            help[i++] = arr[p1] > arr[p2] ? arr[p2++] : arr[p1++];
        }
        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }
        while (p2 <= right) {
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i ++) {
            arr[left + i] = help[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,4,6,2,3};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
