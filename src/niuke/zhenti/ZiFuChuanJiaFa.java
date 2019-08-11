package niuke.zhenti;

import java.util.Scanner;

/**
 * @Author:xjk
 * @Date 2019/8/11 10:57
 * 字符串加法
 * 题目描述
 *
 * 输入两个字符串a和b，字符串内容为二进制数字，求两个字符串相加的结果，加法计算方法以二进制方式计算，并返回对应的字符串结果。要求程序尽可能的高效。示例如下：
 *
 * /**
 *
 * * @param a = "1101"
 *
 * * @param b = "1100"
 *
 * * @return "11001"
 *
 *
 *
        *public String add(String a,String b){
        *}
        *
        *输入描述:
        *输入两个字符串，如"1101","1100"
        *输出描述:
        *"11001"
 */
public class ZiFuChuanJiaFa {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.next();
        String b = scanner.next();
        System.out.println(add(a,b));
    }
    public static String add(String a, String b) {
        Integer intA = Integer.valueOf(a, 2);
        Integer intB = Integer.valueOf(b, 2);
        int num = intA + intB;
        return Integer.toBinaryString(num);
    }
}
