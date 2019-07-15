package niuke.offer;

import java.util.Stack;

/**
 * @author xjk
 * @date 2019/4/1 -  11:38
 * 栈的压入、弹出序列
 * 题目描述：
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 **/
public class IsPopOrder {
    public static boolean isPopOrder(int[] pushs,int[] pops) {
        if (pushs.length == 0 && pops.length == 0) {
            return true;
        }
        Stack<Integer> help = new Stack<>();
        //用于标识弹出序列的位置
        int popIndex = 0;
        for (int push : pushs) {
            help.push(push);
            //如果栈不为空，且栈顶元素等于弹出序列
            while (!help.isEmpty() && help.peek() == pops[popIndex]) {
                help.pop();
                //弹出序列向后一位
                popIndex++;
            }
        }
        return help.isEmpty();
    }
}
