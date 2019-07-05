package niuke.offer;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @Author:xjk
 * @Date 2019/7/5 23:04
 * 从尾到头打印链表
 * 题目描述
 * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 */
public class PrintListFromTailToHead {

    private ArrayList<Integer> list;

    public PrintListFromTailToHead() {
        list = new ArrayList<>();
    }

    /**
     * 递归
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode != null) {
            printListFromTailToHead(listNode.next);
            list.add(listNode.val);
        }
        return list;
    }

    /**
     * 迭代
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printListFromTailToHead_(ListNode listNode) {
        while (listNode != null) {
            list.add(listNode.val);
            listNode = listNode.next;
        }
        Collections.reverse(list);
        return list;
    }
}
