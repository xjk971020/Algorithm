package niuke.xjk.sort;

import java.util.Arrays;

/**
 * @author xjk
 * @date 2019/3/20 -  14:54
 * 冒泡排序
 **/
public class BubbleSort {
    public static int[] bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return arr;
        }
        for (int end = arr.length - 1; end > 0; --end) {
            for (int i = 0; i < end; i++) {
                if (arr[i] > arr[i+1]) {
                    swap(arr,i,i+1);
                }
            }
        }
        return arr;
    }
    public static void swap(int[] arr,int i, int j)  {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int arr[] = {1,4,6,2,3};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
