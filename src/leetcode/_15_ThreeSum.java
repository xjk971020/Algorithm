package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: xjk
 * @Date: 2019/11/6
 * @Time: 17:11
 * 15. 三数之和
 * <p>
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _15_ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length <= 2) {
            return result;
        }
        Arrays.sort(nums);
        int start = 0;
        int end = nums.length - 1;
        for (; start < end - 1; ++start) {
            int mid = start + 1;
            int tempEnd = end;
            //如果排完序后第一个数比0大，说明后面的数都比0大
            if (nums[start] > 0) {
                break;
            }
            //去重
            if (start > 0 && nums[start] == nums[start - 1]) {
                continue;
            }
            while (mid < tempEnd) {
                int tempResult = nums[start] + nums[mid] + nums[tempEnd];
                if (tempResult > 0) {
                    tempEnd--;
                } else if (tempResult == 0) {
                    List<Integer> level = new ArrayList<>();
                    level.add(nums[start]);
                    level.add(nums[mid]);
                    level.add(nums[tempEnd]);
                    result.add(level);
                    //去重
                    while (mid < tempEnd && nums[mid] == nums[mid+1]) {
                        mid++;
                    }
                    mid++;
                } else {
                    mid++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {-1, 0, 1, 2, -1, -4};
        _15_ThreeSum threeSum = new _15_ThreeSum();
        threeSum.threeSum(arr);
    }
}
