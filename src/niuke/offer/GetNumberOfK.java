package niuke.offer;

/**
 * @author xjk
 * @date 2019/6/17 -  17:56
 * 数字在排序数组中出现的次数
 * 题目描述
 * 统计一个数字在排序数组中出现的次数。
 **/
public class GetNumberOfK {
    /**
     * 思路:从前往后找, 从后往前找
     * @param array
     * @param k
     * @return
     */
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
        return hail - pre + 1;
    }
}
