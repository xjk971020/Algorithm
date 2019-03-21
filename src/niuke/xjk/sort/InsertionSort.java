package niuke.xjk.sort;

import java.util.Arrays;

/**
 * @author xjk
 * @date 2019/3/20 -  15:44
 * 插入排序
 **/
public class InsertionSort {

    public static int[] insertionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return arr;
        }
        for (int i = 1; i < arr.length; i ++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j+1]; j--) {
                swap(arr,j,j+1);
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
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
