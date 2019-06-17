package niuke.offer;

import java.util.Arrays;

/**
 * @author xjk
 * @date 2019/6/17 -  17:56
 * 题目描述
 * 统计一个数字在排序数组中出现的次数。
 **/
public class GetNumberOfK {
    public static int getNumberOfK(int [] array , int k) {
        int pre = 0;
        int hail = array.length - 1;
        for (;pre < array.length; ++pre) {
            if (k == array[pre]) {
                break;
            }
        }
        if (pre == array.length) {
            throw new RuntimeException("数组中不存在" + k);
        }
        for (;hail >= 0; --hail) {
            if (k == array[hail]) {
                break;
            }
        }
        int count = hail - pre + 1;
        return count;
    }

    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {

            arr[i] = (int) (Math.random() * 10);
        }
//        arr[6] = 5;
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(GetNumberOfK.getNumberOfK(arr, 10));
    }
}
