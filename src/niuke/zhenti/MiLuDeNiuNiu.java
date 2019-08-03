package niuke.zhenti;

import java.util.Scanner;

/**
 * @Author:xjk
 * @Date 2019/8/3 17:25
 * 迷路的牛牛
 * 题目描述
 * 牛牛去犇犇老师家补课，出门的时候面向北方，但是现在他迷路了。
 * 虽然他手里有一张地图，但是他需要知道自己面向哪个方向，请你帮帮他。
 * 输入
 *  复制
 *   3
 *   LRR
 * 输出
 *  复制
 *   E
 */
public class MiLuDeNiuNiu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        String str = scanner.next();
        int leftCount = 0;
        int rightCount = 0;
        for (int i = 0; i < count; ++i) {
            if (str.charAt(i) == 'L') {
                leftCount++;
            } else if (str.charAt(i) == 'R') {
                rightCount++;
            }
        }
        char[] direction = {'E', 'S', 'W','N', 'E', 'S', 'W'};
        System.out.println(direction[3+(rightCount-leftCount)%4]);
    }
}
