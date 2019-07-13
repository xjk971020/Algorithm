package niuke.offer;

/**
 * @author xjk
 * @date 2019/6/23 -  19:37
 * 调整数组顺序使奇数位于偶数前面
 * 题目描述
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 **/
public class ReOrderArray {

    /**
     * 插排思想
     * @param array
     */
    public void reOrderArray(int [] array) {
        if (array.length == 0 || array == null) {
            return;
        }
        //记录奇数的位置
        int begin = 0;
        int end = array.length;
        //偶数不动, 找奇数, 每次找到一个奇数就插入到上一次插入的奇数的后一个位置
        for (int i = 0; i < end; ++i) {
            if (array[i] % 2 == 1) {
                int index = i;
                while (index > begin) {
                    array[index] = array[index] ^ array[index-1];
                    array[index-1] = array[index] ^ array[index-1];
                    array[index] = array[index] ^ array[index-1];
                    index--;
                }
                begin++;
            }
        }
    }

    /**
     * 使用辅助数组，扫两次
     * 时间复杂度空间复杂度高，
     * @param array
     */
    public void reOrderArray1(int [] array) {
        if (array.length == 0 || array == null) {
            return;
        }
        int[] temp = new int[array.length];
        int index = 0;
        for (int i = 0; i < array.length; ++i) {
            if (array[i] % 2 == 1) {
                temp[index] = array[i];
                index++;
            }
        }
        index = array.length - 1;
        for (int i = array.length - 1; i >= 0; --i) {
            if (array[i] % 2 == 0) {
                temp[index] = array[i];
                index--;
            }
        }
        System.arraycopy(temp, 0,  array, 0, array.length);
    }

}
