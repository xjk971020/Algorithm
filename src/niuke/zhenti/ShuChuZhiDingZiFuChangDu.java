package niuke.zhenti;

import java.util.Scanner;

/**
 * @Author:xjk
 * @Date 2019/8/10 15:25
 * 输出指定长度子串
 * 题目描述
 * 给定一个字符串，输出所有指定长度为n的子串，没有则输出-1
 * 输入描述:
 * 输入第一行一个字符串，如：“1234567890”
 *
 * 输入第二行一个数字是n，如5
 * 输出描述:
 * 输出所有长度为n的子串，如“12345”，“23456”，“34567”，“45678”，“56789”
 */
public class ShuChuZhiDingZiFuChangDu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        int count = scanner.nextInt();
        if (count <= 0 || line.length() < count) {
            System.out.println(-1);
        }
        int forCount = line.length() - count;
        for (int i = 0; i <= forCount; ++i) {
            if (i == forCount) {
                System.out.print(line.substring(i,i+count));
                continue;
            }
            System.out.print(line.substring(i,i+count) + " ");
        }
    }
}
