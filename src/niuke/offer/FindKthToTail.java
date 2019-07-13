package niuke.offer;

import leetcode.ListNode;

/**
 * @author xjk
 * @date 2019/6/17 -  17:35
 *
 * 题目描述
 * 输入一个链表，输出该链表中倒数第k个结点。
 **/
public class FindKthToTail {
    /**
     * 先求出链表长度，再根据k的值遍历
     * @param head
     * @param k
     * @return
     */
    public ListNode FindKthToTail(ListNode head, int k) {
        if (k < 0) {
            throw new RuntimeException("k不能小于0");
        }
        int length = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            length++;
        }
        if (length < k) {
            return null;
        }
        for (;k < length;++k) {
            head = head.next;
        }
        return head;
    }

    /**
     * 两个指针，先让第一个指针和第二个指针都指向头结点，然后再让第一个指正走(k-1)步，到达第k个节点。
     * 然后两个指针同时往后移动，当第一个结点到达末尾的时候，第二个结点所在位置就是倒数第k个节点了。
     * @param head
     * @param k
     * @return
     */
    public ListNode findKthToTail(ListNode head, int k) {
        if (k < 0) {
            throw new RuntimeException("k不能小于0");
        }
        if (head == null || k == 0) {
            return null;
        }
        ListNode pre = head;
        ListNode next = head;
        for (int i = 1; i < k; ++i) {
            if (next.next != null) {
                next = next.next;
            } else {
                return null;
            }
        }
        while (next.next != null) {
            next = next.next;
            pre = pre.next;
        }
        return pre;
    }
}
