package niuke.zhenti;

import java.util.Scanner;
import java.util.Stack;

/**
 * @Author:xjk
 * @Date 2019/8/11 10:37
 * 整数的倒数
 *
 * 题目描述
 * 整数的倒数
 * 输入描述:
 * 输入一个整数x
 * 输出描述:
 * 把x倒序输出
 */
public class ZhengShuDeDaoShu {
    public static void main(String[] args) {
        Scanner scanner  = new Scanner(System.in);
        char[] chars = scanner.nextLine().toCharArray();
        //0表示正数，1表示负数
        int zhengShu = 0;
        if (chars[0] == '-') {
            zhengShu = 1;
        }
        StringBuffer stringBuffer = new StringBuffer();
        Stack<Character> stack = new Stack<>();
        for (int i = zhengShu; i < chars.length; i++) {
            stack.push(chars[i]);
        }
        if (zhengShu == 0) {
            int size = stack.size();
            for (int i = 0; i < size; i++) {
                stringBuffer.append(stack.pop());
            }
            System.out.println(stringBuffer.toString());
        } else {
            stringBuffer.append("-");
            int size = stack.size();
            for (int i = 0; i < size; i++) {
                stringBuffer.append(stack.pop());
            }
            System.out.println(stringBuffer.toString());

        }
    }
}
