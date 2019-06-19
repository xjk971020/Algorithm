package niuke.offer;

/**
 * @author xjk
 * @date 2019/4/1 -  10:12
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含质因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数
 **/
public class UglyNumber {
    public static int getUglyNumber(int index) {
        if (index < 0) {
            throw new RuntimeException("参数错误");
        }
        if (index <= 6) {
            return index;
        }
        int[] arr = new int[index];
        arr[0] = 1;
        int index2 = 0, index3 = 0, index5 = 0;
        for (int i = 1; i < index; i++) {
            arr[i] = Math.min(arr[index2] * 2, Math.min(arr[index3] * 3, arr[index5] * 5));
            if (arr[i] == arr[index2] * 2) {
                index2++;
            }
            if (arr[i] == arr[index3] * 3) {
                index3++;
            }
            if (arr[i] == arr[index5] * 5) {
                index5++;
            }
        }
        return arr[index - 1];
    }
}
