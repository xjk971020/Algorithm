package niuke.offer;

/**
 * @Author:xjk
 * @Date 2019/7/20 21:14
 * 整数中1出现的次数（从1到n整数中1出现的次数）
 * 题目描述
 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
 * 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。
 * ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。
 */
public class NumberOf1Between1AndNSolution {
    public int numberOf1Between1AndN(int n) {
        if (n < 0) {
            throw new RuntimeException("n的值不能小于0");
        }
        int number = 0;
        for (int i = 1; i <= n; ++i) {
            number += numberOf1(i);
        }
        return number;
    }

    private int numberOf1(int n) {
        int number = 0;
        while (n > 0) {
            if (n % 10 == 1) {
                number++;
            }
            n = n/10;
        }
        return number;
    }
}
