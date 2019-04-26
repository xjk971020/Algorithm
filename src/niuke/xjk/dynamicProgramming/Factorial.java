package niuke.xjk.dynamicProgramming;

/**
 * @author xjk
 * @date 2019/4/25 -  8:34
 * 求n!
 **/
public class Factorial {
    /**
     * 递归
     * @param n
     * @return
     */
    public static long getFactorial(int n) {
        if (n == 1) {
            return 1L;
        }
        return (long)n * getFactorial(n - 1);
    }

    /**
     * 迭代
     * @param n
     * @return
     */
    public static long getFactorial2(int n) {
        long result = 1L;
        for (int i = 1; i <= n; ++i) {
            result *= i;
        }
        return (long) result;
    }
}
