package niuke.offer;

/**
 * @author xjk
 * @date 2019/6/23 -  13:46
 * 旋转数组的最小数字
 * 题目描述
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 **/
public class MinNumberInRotateArray {
    /**
     * 双指针法
     * 一前一后两个指针进行遍历
     * 时间复杂度高
     * @param array
     * @return
     */
    public int minNumberInRotateArray1(int [] array) {
        if (array.length == 0 || array == null) {
            return 0;
        }
        int pre = 0;
        int next = 1;
        while (next <= array.length) {
            if (array[pre] > array[next]) {
                return array[next];
            }
            pre++;
            next++;
        }
        return 0;
    }

    /**
     * 二分查找:
     *   会有这样三种情况:
     * (1)0 1 1 1 1 这样的数组旋转之后会变成 1 1 1 0 1 或者 1 0 1 1 1
     *    这种情况二分查找不起作用, 只能在mid位置到末尾进行遍历找出最小值
     * (2)array[mid] > array[high]:
     *    出现这种情况的array类似[3,4,5,6,0,1,2]，此时最小数字一定在mid的右边。
     *    low = mid + 1
     * (3)array[mid] < array[high]:
     *    出现这种情况的array类似[2,2,3,4,5,6,6],此时最小数字一定就是array[mid]或者在mid的左
     *    边。因为右边必然都是递增的。
     *    high = mid
     * @param array
     * @return
     */
    public int minNumberInRotateArray2(int [] array) {
        if (array.length == 0 || array == null) {
            return 0;
        }
        int index1 = 0;
        int index2 = array.length - 1;
        int indexMid = index1;
        while (array[index1] >= array[index2]) {
            if (index2 - index1 == 1) {
                indexMid = index2;
                break;
            }
            indexMid = ((index2 + index1)>>1);
            if (array[index1] == array[indexMid] && array[index2] == array[indexMid]) {
                return minInOrder(array, index1, index2);
            }
            //这个地方有点绕
            if (array[indexMid] >= array[index1]) {
                index1 = indexMid;
            } else if (array[indexMid] <= array[index2]) {
                index2 = indexMid;
            }
        }
        return array[indexMid];
    }

    private  int minInOrder(int [] array, int index1, int index2) {
        for (;index1 < index2; ++index1) {
            if (array[index1] > array[index1+1]) {
                return array[index1+1];
            }
        }
        return 0;
    }
}
