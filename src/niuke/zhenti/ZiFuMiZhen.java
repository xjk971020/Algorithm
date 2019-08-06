package niuke.zhenti;

import java.util.Scanner;

/**
 * @author:xjk 2019/8/6 11:25
 * niuke.zhenti
 * 网易游戏
 * 字符迷阵
 * 题目描述
 * 字符迷阵是一种经典的智力游戏。玩家需要在给定的矩形的字符迷阵中寻找特定的单词。
 * 在这题的规则中，单词是如下规定的：
 * 1. 在字符迷阵中选取一个字符作为单词的开头；
 * 2. 选取右方、下方、或右下45度方向作为单词的延伸方向；
 * 3. 以开头的字符，以选定的延伸方向，把连续得到的若干字符拼接在一起，则称为一个单词。
 */
public class ZiFuMiZhen {
    private static int process(char[][] ch, String word, int i, int j, int len, int type) {
        if (len == word.length()) {
            return 1;
        }
        if (i < 0 || i >= ch.length || j < 0 || j >= ch[0].length || ch[i][j] != word.charAt(len)) {
            return 0;
        }

        int length = 0;
        if (ch[i][j] == word.charAt(len)) {
            switch (type) {
                case 0:
                    length += process(ch, word, i + 1, j, len + 1, 0);
                    break;
                case 1:
                    length += process(ch, word, i, j + 1, len + 1, 1);
                    break;
                case 2:
                    length += process(ch, word, i + 1, j + 1, len + 1, 2);
                    break;
            }
        }
        return length;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            char[][] ch = new char[m][n];
            for (int i = 0; i < m; i++) {
                ch[i] = sc.next().toCharArray();
            }
            String word = sc.next();
            int sum = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    sum += process(ch, word, i, j, 0, 0) +
                            process(ch, word, i, j, 0, 1) +
                            process(ch, word, i, j, 0, 2);
                }
            }
            System.out.println(sum);
        }
    }
}
