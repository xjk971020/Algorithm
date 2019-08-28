package leetcode;

/**
 * @author: xjk
 * @Date: 2019/8/28
 * @Time: 12:13
 * 55. 跳跃游戏
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个位置。
 *
 * 示例 1:
 *
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 从位置 0 到 1 跳 1 步, 然后跳 3 步到达最后一个位置。
 * 示例 2:
 *
 * 输入: [3,2,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jump-game
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CanJump {
    /**
     * 从后往前遍历数组，如果遇到的元素可以到达最后一行，则截断后边的元素。
     * 否则继续往前，若最后剩下的元素大于1个，则可以判断为假。
     * 否则就是真，时间复杂度O(n)就可以
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int step = 1;
        for (int i = nums.length - 2; i >= 0; --i) {
            if (nums[i] >= step) {
                step = 1;
            } else {
                step++;
            }
        }
        return step == 1;
    }

    /**
     * 遍历一遍，记录能跳到点的最大值，如果当前点超出最大值，返回false. 时间复杂度O(n),空间复杂度O(1)
     * @param nums
     * @return
     */
    public boolean canJump_(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        if (nums.length == 1) {
            return true;
        }
        int step = 0;
        for (int i = 0; i < nums.length - 1; ++i) {
            step = Math.max(i + nums[i], step);
            if (step <= i) {
                return false;
            }
        }
        return true;
    }
}
