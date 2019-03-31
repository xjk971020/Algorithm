package niuke.xjk.sort;

import niuke.xjk.util.Counter;

import java.util.Arrays;

/**
 * @author xjk
 * @date 2019/3/25 -  12:21
 * 堆排序
 * 时间复杂度 : O(N*logN)
 * 不具有稳定性
 **/
public class HeapSort {

    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr,i);
        }
        int heapSize = arr.length;
        swap(arr,0,--heapSize);
        while (heapSize > 0) {
            heapify(arr,0,heapSize);
            swap(arr,0,--heapSize);
        }
    }

    /**
     * 将某节点与其父节点比较，若比父节点大，则交换
     * 堆的构建过程
     * @param arr
     * @param index
     */
    private static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1)/2]) {
            swap(arr,index,(index - 1)/2);
            index = (index - 1)/2;
        }
    }

    /**
     * 从index位置的数进行调整，直到变成堆
     * @param arr
     * @param index
     * @param heapSize 堆的总长度(0-(heapSize-1)形成堆)
     */
    private static void heapify(int[] arr,int index, int heapSize) {
        int left = index * 2 + 1;
        while (left < heapSize) {
            int largest = (left + 1) < heapSize && arr[left] < arr[left + 1] ? left + 1: left;
            largest = arr[index] > arr[largest] ? index : largest;
            if (largest == index) {
                break;
            }
            swap(arr,index,largest);
            index = largest;
            left = index * 2 + 1;
        }
    }

    /**
     * 交换数组上的对应下标的两个数
     * @param arr
     * @param i
     * @param j
     */
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = Counter.generateRandomArray(40,100);
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
