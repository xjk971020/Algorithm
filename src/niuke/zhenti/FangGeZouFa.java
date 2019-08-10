package niuke.zhenti;

import java.util.Scanner;

/**
 * @Author:xjk
 * @Date 2019/8/10 13:02
 * 方格走法
 * 题目描述
 * 有一个X*Y的网格，小团要在此网格上从左上角到右下角，只能走格点且只能向右或向下走。请设计一个算法，计算小团有多少种走法。给定两个正整数int x,int y，请返回小团的走法数目。
 *
 * 输入描述:
 * 输入包括一行，空格隔开的两个正整数x和y，取值范围[1,10]。
 * 输出描述:
 * 输出一行，表示走法的数目
 */
public class FangGeZouFa {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        System.out.println(f(rows,cols));
    }
    private static int f(int x, int y){
        if (x <= 0 && y <= 0) {
            return -1;
        }
        if (x == 1 && y > 0) {
            return y + 1;
        }
        if (y == 1 && x > 0) {
            return x + 1;
        }
        return f(x-1, y) + f(x, y-1);
    }
}
