package niuke.offer;

/**
 * @author xjk
 * @date 2019/6/25 -  20:14
 * 数组中的逆序对
 * 题目描述
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，
 * 则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P。
 * 并将P对1000000007取模的结果输出。
 * 即输出P%1000000007
 **/
public class InversePairs {

    public int inversePairs(int [] array) {
        if (array == null || array.length == 0 || array.length == 1) {
            return 0;
        }
        return merge(array, 0, array.length - 1);
    }

    private int merge(int[] array, int start, int end) {
        if (start == end ) {
            return 0;
        }
        int mid = (start + end)/2;
        return merge(array, start, mid) +
                merge(array, mid + 1, end) +
                mergeProcess(array, start, mid, end);
    }

    private int mergeProcess(int[] array, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];
        int index = 0;
        int i = start;
        int j = mid + 1;
        int count = 0;
        while (i <= mid && j <= end) {
            if (array[i] <= array[j] ) {
                temp[index++] = array[i++];
            } else {
                temp[index++] = array[j++];
                count = count + mid - i + 1;
                if (count >= 1000000007) {
                    count = count % 1000000007;
                }
            }
        }
        while (i <= mid) {
            temp[index++] = array[i++];
        }
        while (j <= end) {
            temp[index++] = array[j++];
        }
        for (int k = 0; k < temp.length; ++k) {
            array[start + k] = temp[k];
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,1,0};
        InversePairs inversePairs = new InversePairs();
        System.out.println(inversePairs.inversePairs(arr));
    }
}
