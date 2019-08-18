package leetcode;

/**
 * @author xjk
 * @date 2019/4/7 -  15:39
 * insertion-sort-list
 * 题目描述
 * 使用插入排序对链表进行排序。
 * Sort a linked list using insertion sort.
 **/
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(-1);
        ListNode pre = dummyHead;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            while (pre.next != null && pre.next.val < cur.val) {
                pre =pre.next;
            }
            cur.next = pre.next;
            pre.next = cur;
            pre = dummyHead;
            cur = next;
        }
        return dummyHead.next;
    }
}
