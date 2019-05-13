package niuke.offer;

import leetcode.ListNode;

import java.util.HashSet;

/**
 * @author xjk
 * @date 2019/5/12 -  15:43
 * 输入两个链表，找出它们的第一个公共结点。
 **/
public class SameNode {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null ||  pHead2 == null) {
            return null;
        }
        ListNode current1 = pHead1;
        ListNode current2 = pHead2;
        HashSet set = new HashSet();
        while (current1 != null) {
            set.add(current1);
            current1 = current1.next;
        }
        while (current2 != null) {
            if (set.contains(current2)) {
                return current2;
            }
            current2 = current2.next;
        }
        return null;
    }
}
