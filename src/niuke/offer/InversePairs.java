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
    private int count;
    public InversePairs() {
        count = 0;
    }
    public int inversePairs(int [] array) {
        if (array == null || array.length <= 1) {
            return 0;
        }
        process(array, 0, array.length - 1);
        return count;
    }

    private void process(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (start + end)>>1;
        process(array, start, mid);
        process(array, mid+1, end);
        merge(array, start, mid, end);

    }

    private void merge(int[] array, int start, int mid, int end) {
        int[] help = new int[end-start+1];
        int i = 0;
        int p1 = start;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= end) {
            if (array[p1] > array[p2]) {
                count = count + mid - p1 + 1;
                if (count > 1000000007) {
                    count = count % 1000000007;
                }
                help[i++] = array[p2++];
            } else {
                help[i++] = array[p1++];
            }
        }
        while (p1 <= mid) {
            help[i++] = array[p1++];
        }
        while (p2 <= end) {
            help[i++] = array[p2++];
        }
        System.arraycopy(help, 0, array, start, help.length);
    }
}
