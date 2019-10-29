package leetcode;

/**
 * @author: xjk
 * @Date: 2019/10/28
 * @Time: 10:18
 * 148. 排序链表
 *
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 *
 * 示例 1:
 *
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例 2:
 *
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _148_SortList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;
        ListNode head1 = sortList(head);
        ListNode head2 = sortList(slow);
        return merge(head1, head2);
    }
    private ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode head = new ListNode(-1);
        dummyHead.next = head;
        ListNode p1 = head1;
        ListNode p2 = head2;
        while (p1 != null && p2 != null) {
            if (p1.val > p2.val) {
                head.next = p2;
                head = head.next;
                p2 = p2.next;
            } else {
                head.next = p1;
                head = head.next;
                p1 = p1.next;
            }
        }
        while (p1 != null) {
            head.next = p1;
            p1 = p1.next;
            head = head.next;
        }
        while (p2 != null) {
            head.next = p2;
            p2 = p2.next;
            head = head.next;
        }
        return dummyHead.next.next;
    }
}
