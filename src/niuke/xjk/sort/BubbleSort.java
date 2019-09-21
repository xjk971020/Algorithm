package niuke.xjk.sort;

import java.util.Arrays;

/**
 * @author xjk
 * @date 2019/3/20 -  14:54
 * 冒泡排序
 * 具有稳定性
 **/
public class BubbleSort {
    public static int[] bubbleSort(int[] arr) {
        //用一个开关判断某一次是否没有交换过,  没有交换过说明已经排好序了
        boolean doSwap = false;
        for (int end = arr.length - 1; end > 0; --end) {
            for (int i = 0; i < end; ++i) {
                if (arr[i] > arr[i+1]) {
                    swap(arr, i, i + 1);
                    doSwap = true;
                }
            }
            if (!doSwap) {
                return arr;
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
        int arr[] = {1,4,6,2,3};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
