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
        if (head == null) {
            return;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode after = reorder(slow.next);
        /**
         * 此处必须让slow.next = null,不让当两组链表重新拼接的时候会造成死循环
         * 比如:
         * 1->2->3->4->null
         * 拆分为:
         * 1->2->3->4->null
         * 4->3->null
         * 如果slow.next 不为null
         * 合并后会变成1->4->2->3->4->2->3......
         */
        slow.next = null;
        ListNode start = head;
        while (start != null && after != null) {
            ListNode startTemp = start.next;
            ListNode afterTemp = after.next;
            start.next = after;
            start = startTemp;
            after.next = start;
            after = afterTemp;
        }
    }
    //反转链表
    private ListNode reorder(ListNode head) {
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

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        ReorderList reorderList = new ReorderList();
        reorderList.reorderList(node);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}
