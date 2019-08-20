package leetcode;

/**
 * cathetine
 * 19-8-20 下午10:32
 * reorder-list
 * 题目描述
 * 将给定的单链表L： L 0→L 1→…→L n-1→L n,
 * 重新排序为： L 0→L n →L 1→L n-1→L 2→L n-2→…
 * 要求使用原地算法，并且不改变节点的值
 * 例如：
 * 对于给定的单链表{1,2,3,4}，将其重新排序为{1,4,2,3}.
 * Given a singly linked list L: L 0→L 1→…→L n-1→L n,
 * reorder it to: L 0→L n →L 1→L n-1→L 2→L n-2→…
 * You must do this in-place without altering the nodes' values.
 *
 * For example,
 * Given{1,2,3,4}, reorder it to{1,4,2,3}.
 */
public class ReorderList {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        head.next = reverse(head.next);
    }
    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
