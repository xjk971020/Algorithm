package leetcode;

/**
 * @author:xjk 2019/8/28 10:23
 * leetcode
 * single-number
 * 题目描述
 * 现在有一个整数类型的数组，数组中素只有一个元素只出现一次，其余的元素都出现两次。
 * 注意：
 * 你需要给出一个线性时间复杂度的算法，你能在不使用额外内存空间的情况下解决这个问题么？
 *
 * Given an array of integers, every element appears twice except for one. Find that single one.
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */
public class SingleNumber {
    /**
     * 1.异或满足交换律。
     * 2.相同两个数异或为0。
     * 3.0异或一个数为那个数本身。
     * @param A
     * @return
     */
    public int singleNumber(int[] A) {
        int res = 0;
        for (int i = 0;i < A.length; ++i) {
            res = res ^ A[i];
        }
        return res;
    }
}
