package niuke;

import leetcode.ListNode;

/**
 * @Author:xjk
 * @Date 2019/7/14 15:48
 * 合并两个排序的链表
 * 题目描述
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class Merge {
    public ListNode merge(ListNode list1, ListNode list2) {
        if (list1 == null && list2 != null) {
            return list2;
        }
        if (list1 != null && list2 == null) {
            return list1;
        }
        if (list1 == null && list2 == null) {
            return null;
        }
        if (list1.val > list2.val) {
            list2.next = merge(list1, list2.next);
            return list2;
        } else {
            list1.next = merge(list1.next, list2);
            return list1;
        }
    }
}
