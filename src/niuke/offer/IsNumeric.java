package niuke.offer;

/**
 * @Author:xjk
 * @Date 2019/7/3 21:46
 * 表示数值的字符串
 * 题目描述
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 */
public class IsNumeric {
    public boolean isNumeric(char[] str) {
        boolean hasE = false;
        boolean hasPoint = false;
        for (int i = 0; i < str.length; ++i) {
            if (str[i] == '+' || str[i] == '-') {
                if (i > 0 && str[i-1] != 'e' && str[i-1] != 'E') {
                    return false;
                }
            } else if (str[i] == 'e' || str[i] == 'E') {
                if (hasE || i == str.length - 1) {
                    return false;
                }
                hasE = true;
            } else if (str[i] == '.') {
                if (hasE || hasPoint) {
                    return false;
                }
                hasPoint = true;
            } else if (str[i] > '9' || str[i] < '0') {
                return false;
            }
        }
        return true;
    }
}
