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
        if (str == null || str.length == 0) {
            return false;
        }
        boolean hasE = false, decimal = false, signal = false;
        for (int i = 0; i < str.length; ++i) {
            if (str[i] == 'E' || str[i] == 'e') {
                if (i == str.length - 1) {
                    return false;
                }
                if (hasE) {
                    return false;
                }
                hasE = true;
            } else if (str[i] == '+' || str[i] == '-') {
                if (signal && str[i - 1] != 'E' && str[i - 1] != 'e') {
                    return false;
                }
                if (!signal && i>0 && str[i-1] != 'E' && str[i-1] != 'e') {
                    return false;
                }
                signal = true;
            } else if (str[i] == '.') {
                if (hasE) {
                    return false;
                }
                if (decimal) {
                    return false;
                }
                decimal = true;
            } else if(str[i] < '0' || str[i] > '9'){
                //不是e也不是+-符号也不是小数点，那么只能是数字，不是数字就是非法的字符
                return false;
            }
        }
        return true;
    }
}
