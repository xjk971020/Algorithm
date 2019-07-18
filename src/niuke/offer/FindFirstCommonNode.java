package niuke.offer;

import leetcode.ListNode;

import java.util.HashSet;

/**
 * @author xjk
 * @date 2019/5/12 -  15:43
 * 两个链表的第一个公共结点
 * 题目描述
 * 输入两个链表，找出它们的第一个公共结点。
 **/
public class FindFirstCommonNode {
    public ListNode findFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        HashSet<ListNode> set = new HashSet<>();
        while (pHead1 != null) {
            set.add(pHead1);
            pHead1 = pHead1.next;
        }
        while (pHead2 != null) {
            if (set.contains(pHead2)) {
                return pHead2;
            }
            pHead2 = pHead2.next;
        }
        return null;
    }
}
