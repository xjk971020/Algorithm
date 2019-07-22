package niuke.offer;

/**
 * @Author:xjk
 * @Date 2019/7/2 21:26
 * 把字符串转换成整数
 * 题目描述
 * 将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能，
 * 但是string不符合数字要求时返回0)，要求不能使用字符串转换整数的库函数。
 * 数值为0或者字符串不是一个合法的数值则返回0。
 */
public class StrToInt {
    public int StrToInt(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        int first = 0;
        char[] chars = str.toCharArray();
        if (chars[0] == '-') {
            first = 1;
        }
        int sum = 0;
        for (int i = first; i < chars.length; i++) {
            if (chars[i] == '+') {
                continue;
            }
            if (chars[i] > 57 || chars[i] < 48) {
                return 0;
            }
            int temp = sum * 10 + chars[i] - 48;
            //要先判断是否大小是否溢出，整数溢出时值为-2147483647
            if ((temp - chars[i] + 48)/10 != sum) {
                return 0;
            }
            sum = sum * 10 + chars[i] -48;
        }
        if (first == 1) {
            sum = (int)Math.pow(-1, first) * sum;
        }
        return sum;
    }

    public static void main(String[] args) {
        StrToInt strToInt = new StrToInt();
        strToInt.StrToInt("123");
    }
}
