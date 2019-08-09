package niuke.zhenti;

import java.util.Scanner;

/**
 * @Author:xjk
 * @Date 2019/8/9 21:52
 * 查找数组众数
 * 题目描述
 * 给定一个数组A[n], 定义数组的众数 ( Majority Element) 为数组中出现次数超过 n/2 次的元素, 假设数组A[n]非空且一定存在众数, 请设计算法找到该众数并输出.
 *
 * 输入描述:
 * 一个非空且一定存在众数的整数数组,如: [1,2,2]
 * 输出描述:
 * 输出打印该众数,如: 2
 */
public class ChaZhaoShuZuZhogShu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] numStrs = input.replace("[","").replace("]","").split(",");
        int[] nums = new int[numStrs.length];
        for (int i = 0; i < numStrs.length; i++) {
            nums[i] = Integer.parseInt(numStrs[i]);
        }
        int count = 0;
        int nextNum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                nextNum = nums[i];
                count++;
            } else if (nextNum == nums[i]) {
                count++;
            } else {
                count--;
            }
        }
        System.out.println(nextNum);
        scanner.close();
    }
}
