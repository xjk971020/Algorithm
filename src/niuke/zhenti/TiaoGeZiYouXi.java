package niuke.zhenti;

import java.util.Scanner;

/**
 * @Author:xjk
 * @Date 2019/8/9 22:34
 * 跳格子游戏
 * 题目描述
 * 假设你正在玩跳格子（所有格子排成一个纵列）游戏。需要 跳完n 个格子你才能抵达终点。
 * 每次你可以跳 1 或 2 个格子。你有多少种不同的方法可以到达终点呢？
 * 注意：给定 n 是一个正整数。
 * 输入描述:
 * 格子数n
 * 输出描述:
 * 跳完n个格子到达终点的方法
 */
public class TiaoGeZiYouXi {
    private int[] arr;
    public TiaoGeZiYouXi() {
        arr = new int[1024];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = -1;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        TiaoGeZiYouXi tiaoGeZiYouXi = new TiaoGeZiYouXi();
        System.out.println(tiaoGeZiYouXi.process(num));
    }
    private int process(int i) {
        if (i == 0) {
            return 0;
        }
        if (i <= 2){
            return i;
        }
        if (arr[i] != -1) {
            return arr[i];
        }
        arr[i] = process(i-1) + process(i - 2);
        return arr[i];
    }
}
