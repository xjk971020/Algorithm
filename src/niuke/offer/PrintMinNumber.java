package niuke.offer;

import java.util.Arrays;

/**
 * @Author:xjk
 * @Date 2019/7/6 21:36
 * 把数组排成最小的数
 * 题目描述
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
 * 打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */
public class PrintMinNumber {
    public String PrintMinNumber(int [] numbers) {
        if (numbers == null || numbers.length == 0) {
            return null;
        }
        int length = numbers.length;
        String[] strs = new String[length];
        for (int i = 0; i < length; i++) {
            strs[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(strs, (s1,s2) -> {
            String s1s2 = s1 + s2;
            String s2s1 = s2 + s1;
            return s1s2.compareTo(s2s1);
        });
        StringBuffer stringBuffer = new StringBuffer();
        for (String str : strs) {
            stringBuffer.append(str);
        }
        return stringBuffer.toString();
    }
}
