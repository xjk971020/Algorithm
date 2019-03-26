package niuke.xjk.question;

import niuke.xjk.sort.Counter;
import niuke.xjk.sort.InsertionSort;

import java.util.Arrays;

/**
 * @author xjk
 * @date 2019/3/24 -  9:07
 *  荷兰国旗问题
 *  左程云 基础2
 *  时间复杂度：O(N)
 **/
public class NetherLandFlag {

    public static int[] solution(int[] arr, int num) {
        return partition(arr,0,arr.length - 1, num);
    }

    /**
     * 核心思想:遍历数组，小的往左放，大的往右放，等于不变
     * @param arr
     * @param left
     * @param right
     * @param num
     * @return
     */
    public static int[] partition(int[] arr, int left,int right,int num) {
        int less = left - 1;
        int more = right + 1;
        while (left < more) {
            if (arr[left] < num) {
                swap(arr,++less,left++);
            } else if (arr[left] > num) {
                swap(arr, --more,left);
            } else {
                left++;
            }
        }
        return arr;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = Counter.generateRandomArray(40,100);
        System.out.println(Arrays.toString(solution(arr,20)));
    }
}
