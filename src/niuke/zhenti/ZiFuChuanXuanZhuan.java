package niuke.zhenti;

import java.util.Scanner;

/**
 * @Author:xjk
 * @Date 2019/8/13 20:46
 * 字符串旋转
 *
 * 题目描述
 * 字符串旋转:
 * 给定两字符串A和B，如果能将A从中间某个位置分割为左右两部分字符串（都不为空串），并将左边的字符串移动到右边字符串后面组成新的字符串可以变为字符串B时返回true。
 * 例如：如果A=‘youzan’，B=‘zanyou’，A按‘you’‘zan’切割换位后得到‘zanyou’和B相同返回true。
 * 输入描述:
 * 2个不为空的字符串(说明:输入一个字符串以英文分号";"分割为2个字符串)
 * 例如:youzan;zanyou 即为A=‘youzan’，B=‘zanyou’
 * 输出描述:
 * 输出true或false(表示是否能按要求匹配两个字符串)
 */
public class ZiFuChuanXuanZhuan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] inputs = input.split(";");
        String a = inputs[0];
        String b = inputs[1];
        if (a.length() != b.length()) {
            System.out.println(false);
            return;
        }
        a = a + a;
        if (a.contains(b)) {
            System.out.println(true);
            return;
        }
        System.out.println(false);
    }
}
