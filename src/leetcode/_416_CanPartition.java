package leetcode;

/**
 * @Author:cathetine
 * @Date:19-11-11
 * @Time:下午12:58
 * 416. 分割等和子集
 *
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 *
 * 注意:
 *
 * 每个数组中的元素不会超过 100
 * 数组的大小不会超过 200
 * 示例 1:
 *
 * 输入: [1, 5, 11, 5]
 *
 * 输出: true
 *
 * 解释: 数组可以分割成 [1, 5, 5] 和 [11].
 *  
 *
 * 示例 2:
 *
 * 输入: [1, 2, 3, 5]
 *
 * 输出: false
 *
 * 解释: 数组不能分割成两个元素和相等的子集.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-equal-subset-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _416_CanPartition {
    /**
     * https://leetcode-cn.com/problems/partition-equal-subset-sum/solution/0-1-bei-bao-wen-ti-xiang-jie-zhen-dui-ben-ti-de-yo/
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 == 1) {
            return false;
        }
        sum = sum/2;
        //初始化一个二维数组, 行表示物品, 列表示容量
        boolean[][] temp = new boolean[nums.length][sum + 1];
        //初始化第一列, 因为第一列都可达
        for (int i = 0; i < temp.length; ++i) {
            temp[i][0] = true;
        }
        for (int i = 1; i < nums.length; ++i) {
            for (int j = 1; j <= sum; ++j) {
                if (nums[i] <= j) {
                    temp[i][j] = temp[i-1][j] || temp[i - 1][j - nums[i]];
                }
            }
        }
        return temp[nums.length - 1][sum];
    }
}
