package niuke.zhenti;

import java.util.Scanner;
import java.util.Stack;

/**
 * @Author:xjk
 * @Date 2019/8/11 10:07
 * 括号配对问题
 *
 * 题目描述
 * 括号配对问题
 * 输入描述:
 * 给定一个字符串S，请检查该字符串的括号是否配对，只含有"[", "]", "(", ")"
 * 输出描述:
 * 配对，返回true
 *
 * 不配对，返回false
 */
public class KuoHaoPeiDuiWenTi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        char[] chars = line.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '[' || chars[i] == '(') {
                stack.push(chars[i]);
            } else if(stack.isEmpty() && chars[i] == ']' || chars[i] == ')') {
                System.out.println(false);
                return;
            } else if(chars[i] == ']') {
                if (!stack.isEmpty() && stack.pop() != '[') {
                    System.out.println(false);
                    return;
                }
            } else if (chars[i] == ')') {
                if (!stack.isEmpty() && stack.pop() != '(') {
                    System.out.println(false);
                    return;
                }
            }
        }
        if (!stack.isEmpty()) {
            System.out.println(false);
            return;
        }
        System.out.println(true);
    }
}
