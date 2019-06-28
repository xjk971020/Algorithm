package niuke.offer;

import leetcode.ListNode;

/**
 * @Author:xjk
 * @Date 2019/6/28 20:28
 * 链表中环的入口结点
 * 题目描述
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 */
public class EntryNodeOfLoop {
    public ListNode entryNodeOfLoop(ListNode pHead) {
        ListNode meetingNode = meetingNode(pHead);
        if (meetingNode == null) {
            return null;
        }
        ListNode temp = meetingNode;
        int count = 1;
        while (temp.next != meetingNode) {
            ++count;
            temp = temp.next;
        }
        ListNode indexTemp = pHead;
        for (int i = 0; i < count; ++i) {
            indexTemp = indexTemp.next;
        }
        ListNode headTemp = pHead;
        while (indexTemp != headTemp) {
            indexTemp = indexTemp.next;
            headTemp = headTemp.next;
        }
        return indexTemp;
    }

    private ListNode meetingNode(ListNode pHead) {
        if (pHead == null) {
            return null;
        }
        ListNode pre = pHead;
        ListNode next = pHead;
        if (pre.next == null) {
            return null;
        }
        while (pre != null && next != null) {
            if (pre.next != null) {
                pre = pre.next;
            }
            if (next.next != null && next.next.next != null) {
                next = next.next.next;
            }
            if (next == pre) {
                return pre;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        EntryNodeOfLoop entryNodeOfLoop = new EntryNodeOfLoop();
        System.out.println(entryNodeOfLoop.entryNodeOfLoop(node));
    }
}
