package niuke.zhenti;

import java.util.Scanner;

/**
 * @Author:xjk
 * @Date 2019/8/8 16:20
 * 网易游戏
 * 时钟
 * 题目描述
 * 注意：本题允许使用C/C++/Java/python进行解答，其他编程语言提交均视作无效处理。
 *
 * 小W有一个电子时钟用于显示时间，显示的格式为HH:MM:SS，HH，MM，SS分别表示时，分，秒。
 * 其中时的范围为[‘00’,‘01’…‘23’]，分的范围为[‘00’,‘01’…‘59’]，秒的范围为[‘00’,‘01’…‘59’]。
 *
 * 但是有一天小W发现钟表似乎坏了，显示了一个不可能存在的时间“98:23:00”，
 * 小W希望改变最少的数字，使得电子时钟显示的时间为一个真实存在的时间，
 * 譬如“98:23:00”通过修改第一个’9’为’1’，即可成为一个真实存在的时间“18:23:00”。
 * 修改的方法可能有很多，小W想知道，在满足改变最少的数字的前提下，符合条件的字典序最小的时间是多少。
 * 其中字典序比较为用“HHMMSS”的6位字符串进行比较。
 */
public class ShiZhong {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCount = scanner.nextInt();
        scanner.nextLine();
        while (testCount-- > 0) {
            String line = scanner.next();
            process(line);
        }
        scanner.close();
    }
    private static void process(String str) {
        int hour = Integer.valueOf(str.substring(0,2));
        int min = Integer.valueOf(str.substring(3,5));
        int second = Integer.valueOf(str.substring(6,8));
        char[] strs = str.toCharArray();
        if (hour > 23) {
            strs[0] = '0';
        }
        if (min > 59) {
            strs[3] = '0';
        }
        if (second > 59) {
            strs[6] = '0';
        }
        System.out.println(new String(strs));
    }
}
