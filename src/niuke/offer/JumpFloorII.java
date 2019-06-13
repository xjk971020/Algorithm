package niuke.offer;

/**
 * author:xjk
 * 2019/6/13 16:02
 * niuke.offer
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
public class JumpFloorII {

    private int[] arr = new int[1024];

    public JumpFloorII() {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = -1;
        }
    }

    /**
     * 记住规律
     * f(n) = 2 * f(n - 1)
     */
    public int solution(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("台阶数不能小于0");
        }
        if (n <= 1) {
            return n;
        }
        if (arr[n] != -1) {
            return arr[n];
        }
        arr[n] = solution(n - 1) * 2;
        return arr[n];
    }
}
