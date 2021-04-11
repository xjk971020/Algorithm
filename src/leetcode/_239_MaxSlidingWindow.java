package leetcode;

import java.util.LinkedList;

/**
 * @Author:xjk
 * @Description: 239. 滑动窗口最大值
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * <p>
 * 返回滑动窗口中的最大值。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 * 示例 2：
 * <p>
 * 输入：nums = [1], k = 1
 * 输出：[1]
 * 示例 3：
 * <p>
 * 输入：nums = [1,-1], k = 1
 * 输出：[1,-1]
 * 示例 4：
 * <p>
 * 输入：nums = [9,11], k = 2
 * 输出：[11]
 * 示例 5：
 * <p>
 * 输入：nums = [4,-2], k = 2
 * 输出：[4]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sliding-window-maximum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2021/4/9
 */
public class _239_MaxSlidingWindow {

    /**
     * 常规循环，超时
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        int[] result = new int[nums.length - k + 1];
        int loopCnt = nums.length - k + 1;
        for (int i = 0; i < loopCnt; i++) {
            int curMax = nums[i];
            int lineLoopCnt = i + k;
            for (int j = i + 1; j < lineLoopCnt; ++j) {
                if (curMax < nums[j]) {
                    curMax = nums[j];
                }
            }
            result[i] = curMax;
        }
        return result;
    }

    /**
     * 双端队列
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow_1(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        int[] result = new int[nums.length - k + 1];
        int resIndex = 0;
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            while (!linkedList.isEmpty() && nums[linkedList.peekLast()] <= nums[i]) {
                linkedList.pollLast();
            }
            linkedList.addLast(i);

            if (linkedList.peekFirst() == i - k) {
                linkedList.pollFirst();
            }

            if (i >= k - 1) {
                result[resIndex++] = nums[linkedList.peekFirst()];
            }
        }

        return result;
    }


}
