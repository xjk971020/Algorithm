package leetcode;

/**
 * @author xjk
 * @date 2019/4/28 -  10:11
 * 53. 最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 **/
public class MaxSubArray {
    public static int maxSubArray(int[] nums) {
       int res = nums[0], sum = 0;
       for (int i : nums) {
           if (sum > 0) {
               sum += i;
           } else {
               sum = i;
           }
           res = Math.max(res,sum);
       }
       return  res;
    }

    public static void main(String[] args) {
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(arr));
    }
}
