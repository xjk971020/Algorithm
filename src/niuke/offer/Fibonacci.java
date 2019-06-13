package niuke.offer;

/**
 * author:xjk
 * 2019/6/13 15:32
 * niuke.offer
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 * 递归优化
 * 递推
 */
public class Fibonacci {

    private int[] arr = new int[1024];

    public Fibonacci() {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = -1;
        }
    }

    /**
     * 递归解法
     * 使用数组优化
     * @param n
     * @return
     */
    public int fibonacciOfDigui(int n) {
        if (n <= 2) {
            return 1;
        }
        if (arr[n] != -1) {
            return arr[n];
        }
        arr[n] = fibonacciOfDigui(n - 1) + fibonacciOfDigui(n - 2);
        return arr[n];
    }

    /**
     * 递推解法
     * @param n
     * @return
     */
    public int fibonacciOfDitui(int n) {
        if (n == 0) {
            return 0;
        }
        if (n <= 2) {
            return 1;
        }
        int pre = 1;
        int next = 1;
        int sum = 0;
        for (int i = 3; i <= n; i++) {
            sum = pre + next;
            pre = next;
            next = sum;
        }
        return sum;
    }
}
