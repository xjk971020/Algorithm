package leetcode;

/**
 * @Author:xjk
 * @Description:
 *
 * 896. 单调数列
 * 如果数组是单调递增或单调递减的，那么它是单调的。
 * <p>
 * 如果对于所有 i <= j，A[i] <= A[j]，那么数组 A 是单调递增的。 如果对于所有 i <= j，A[i]> = A[j]，那么数组 A 是单调递减的。
 * <p>
 * 当给定的数组 A 是单调数组时返回 true，否则返回 false。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/monotonic-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2021/4/20
 */
public class _896_IsMonotonic {

    public boolean isMonotonic(int[] A) {
        if (A == null || A.length == 0) {
            return false;
        }

        boolean isUpArray = true, isDownArray = true;

        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] > A[i+1]) {
                isUpArray = false;
            } else if (A[i] < A[i+1]) {
                isDownArray = false;
            }
        }

        return isUpArray || isDownArray;
    }
}
