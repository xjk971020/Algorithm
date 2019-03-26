package niuke.xjk.sort;

import java.util.Arrays;

/**
 * @author xjk
 * @date 2019/3/20 -  15:12
 * 选择排序
 * 不具有稳定性
 **/
public class SelectionSort {

    public static int[] selectionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return arr;
        }
        for (int i = 0; i < arr.length - 1; i ++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[j] < arr[minIndex]? j : minIndex;
            }
            swap(arr,i,minIndex);
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
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
