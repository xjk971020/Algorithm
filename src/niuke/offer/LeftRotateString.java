package niuke.offer;

/**
 * @Author:xjk
 * @Date 2019/6/28 17:28
 * 左旋转字符串
 * 题目描述
 * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
 * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
 * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。
 * 是不是很简单？OK，搞定它！
 */
public class LeftRotateString {
    public String leftRotateString(String str,int n) {
        if (n < 0) {
            throw new RuntimeException("n不能小于0");
        }
        if (str == null || str.length() == 0) {
            return "";
        }
        char[] chars = str.toCharArray();
        reverse(chars, 0 ,n - 1);
        reverse(chars, n, chars.length - 1);
        reverse(chars, 0, chars.length - 1);
        StringBuffer stringBuffer = new StringBuffer(chars.length);
        for (char c : chars) {
            stringBuffer.append(c);
        }
        return stringBuffer.toString();
    }

    private void reverse(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }
}
