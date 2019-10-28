package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author: xjk
 * @Date: 2019/10/28
 * @Time: 10:53
 * 179. 最大数
 * <p>
 * 给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [10,2]
 * 输出: 210
 * 示例 2:
 * <p>
 * 输入: [3,30,34,5,9]
 * 输出: 9534330
 * 说明: 输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _179_LargestNumber {
    private class LargestNumberCpmpartor implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            String order1 = o1 + o2;
            String order2 = o2 + o1;
            return order2.compareTo(order1);
        }
    }

    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new String("");
        }
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, new LargestNumberCpmpartor());
        StringBuilder result = new StringBuilder();
        if ("0".equals(strs[0])) {
            return "0";
        }
        for (int i = 0; i < strs.length; i++) {
            result.append(strs[i]);
        }
        return result.toString();
    }
}
