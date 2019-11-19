package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:xjk
 * @Date 2019/11/19 10:38
 * 78. 子集
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _78_Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        subsets(0, nums, new ArrayList<>(), result);
        return result;
    }
    private void subsets(int step, int[] nums, List<Integer> level, List<List<Integer>> result) {
        result.add(level);
        for (int i = step; i < nums.length; ++ i) {
            level.add(nums[i]);
            subsets(i + 1, nums, level, result);
            level.remove(level.size() - 1);
        }
    }
}
