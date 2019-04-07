package leetcode;

/**
 * @author xjk
 * @date 2019/4/7 -  15:39
 * 147、对链表进行插入排序
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
