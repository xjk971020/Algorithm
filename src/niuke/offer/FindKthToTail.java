package niuke.offer;

import leetcode.ListNode;

/**
 * @author xjk
 * @date 2019/6/17 -  17:35
 * 题目描述
 * 输入一个链表，输出该链表中倒数第k个结点。
 **/
public class FindKthToTail {
    public ListNode FindKthToTail(ListNode head, int k) {
        int length = 0;
        ListNode temp = head;
        while(temp != null) {
            length++;
            temp = temp.next;
        }
        for (; k <= length; ++k) {
            head = head.next;
        }
        return head;
    }
}
