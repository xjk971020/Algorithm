package leetcode;

/**
 * @Author:xjk
 * @Date 2019/11/22 21:37
 * 92. 反转链表 II
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 * <p>
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _92_ReverseBetween {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == 1) {
            return reverseN(head, n);
        }
        head.next = reverseBetween(head.next, m - 1, n - 1);
        return head;
    }

    /**
     * 从head开始第n个节点的下一个节点
     */
    private ListNode next;

    /**
     * 反转head开始的n个链表，包括head
     *
     * @param head
     * @param n
     * @return
     */
    private ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            next = head.next;
            return head;
        }
        ListNode last = reverseN(head.next, n - 1);
        head.next.next = head;
        head.next = next;
        return last;
    }
}
