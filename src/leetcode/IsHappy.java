package leetcode;

/**
 * @Author:cathetine
 * @Date:19-8-27 下午3:01
 * 202. 快乐数
 * 编写一个算法来判断一个数是不是“快乐数”。
 * <p>
 * 一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，
 * 然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。
 * 如果可以变为 1，那么这个数就是快乐数。
 * <p>
 * <p>
 * <p>
 */
public class IsHappy {
    public boolean isHappy(int n) {
        if (n < 0) {
            return false;
        }
        int count = n;
        for (int i = 0; i < 1000; ++i) {
            count = process(count);
//            System.out.println(count);
            if (count == 1) {
                return true;
            }
        }
        return false;
    }

    private int process(int n) {
//        System.out.println(n);
        int count = 0;
        while (n > 0) {
            int temp = n % 10;
            count += temp * temp;
            n = n / 10;
        }
        System.out.println(count);
        return count;
    }

    public static void main(String[] args) {
        IsHappy isHappy = new IsHappy();
        System.out.println(isHappy.isHappy(2));
    }
}
