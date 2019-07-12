package niuke.offer;

/**
 * author:xjk
 * 2019/6/13 15:23
 * niuke.offer
 * 跳台阶
 * 题目描述
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 */
public class JumpFloor {
    private int[] arr = new int[1024];

    public JumpFloor() {
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = -1;
        }
    }

    public int JumpFloor(int target) {
        if (target < 0) {
            throw new IllegalArgumentException("目标数不能小于0");
        }
        if (target == 0) {
            return 0;
        }
        if (target <= 2) {
            return target;
        }
        if (arr[target] != -1) {
            return arr[target];
        }
        arr[target] = JumpFloor(target - 1) + JumpFloor(target - 2);
        return arr[target];
    }
}
