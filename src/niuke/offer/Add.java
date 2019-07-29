package niuke.offer;

/**
 * @Author xjk
 * @Date 2019-7-8 10:36
 * 不用加减乘除做加法
 * 题目描述
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 */
 public class Add {

    /**
     * 两个数异或: 相当于两个数的每个位相加而不考虑进位
     * 两个数做与运算再左移一个位相当于求得进位
     * 将上面两步的结果相加求得结果
     * @param num1
     * @param num2
     * @return
     */
    public int add(int num1, int num2) {
        while (num2 != 0) {
            int sum = num1 ^ num2;
            int carry = (num1 & num2) << 1;
            num1 = sum;
            num2 = carry;
        }
        return num1;
    }
 }
