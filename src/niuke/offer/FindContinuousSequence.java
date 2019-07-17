package niuke.offer;

import java.util.ArrayList;

/**
 * @author xjk
 * @date 2019/6/26 -  10:33
 * 和为S的连续正数序列
 * 题目描述
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
 * 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
 * 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
 * 现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 **/
public class FindContinuousSequence {
    /**
     * 双指针技术，相当于有一个窗口，窗口的左右两边就是两个指针，我们根据窗口内值之和来确定窗口的位置和宽度。
     * @param sum
     * @return
     */
    public ArrayList<ArrayList<Integer>> findContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (sum < 0) {
            throw new RuntimeException("sum不能小于0");
        }
        if (sum < 3) {
            return res;
        }
        int small = 1;
        int big = 2;
        int curNum = big + small;
        int middle = sum/2;
        while (small <= middle) {
            if (curNum == sum) {
                addContinuousSequence(res, small, big);
            }
            while(small <= middle && curNum > sum) {
                curNum -= small;
                small++;
                if (curNum == sum) {
                    addContinuousSequence(res, small, big);
                }
            }
            big++;
            curNum += big;
        }
        return res;
    }

    private void addContinuousSequence(ArrayList<ArrayList<Integer>> res, int small, int big) {
        ArrayList<Integer> level = new ArrayList<>();
        for (int i = small; i <= big; ++i) {
            level.add(i);
        }
        res.add(level);
    }
}
