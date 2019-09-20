package niuke.xjk.util;

import niuke.xjk.sort.MergerSort;

import java.util.Arrays;

/**
 * @author xjk
 * @date 2019/3/20 -  20:19
 * 计数器
 * 此处以插入排序为例子，以Array.sort()为绝对正确的方法，进行比对
 **/
public class Counter {
    /**
     * 生成一个随机数组
     * @param maxSize
     * @param value
     * @return
     */
    public static int[] generateRandomArray(int maxSize,int value) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (value *  Math.random())  - (int) (value *  Math.random());
        }
        return arr;
    }

    /**
     * 复制数组
     * @param arr
     * @return
     */
    public static int[] copyOf(int[] arr){
        if (arr == null) {
            return null;
        }
        int[] copyArr = new int[arr.length];
        for (int i = 0; i < arr.length; i ++) {
            copyArr[i] = arr[i];
        }
        return copyArr;
    }

    public static boolean isEqual(int[] arr1, int[] arr2) {
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1 != null && arr2 == null || arr1 == null) {
            return false;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i ++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 绝对正确的方法
     * @param arr
     */
    public static void rightMethod(int[] arr) {
        Arrays.sort(arr);
    }

    public static void main(String[] args) {
        int testTime = 20;
        int value = 1000;
        int maxSize = 20;
        boolean success = true;
        for (int i = 0 ; i < testTime; i ++) {
            int[] arr1 = generateRandomArray(maxSize,value);
            int[] arr2 = copyOf(arr1);
//            InsertionSort.insertionSort(arr1);
//            BubbleSort.bubbleSort(arr1);
//            SelectionSort.selectionSort(arr1);
            MergerSort.mergeSort(arr1);
            rightMethod(arr2);
            if (!isEqual(arr1,arr2)) {
                success = false;
                break;
            }
        }
        System.out.println(success ? "success" : "false");
    }
}
