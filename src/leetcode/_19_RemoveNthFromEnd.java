package leetcode;

/**
 * @author: xjk
 * @Date: 2019/11/8
 * @Time: 16:26
 * 19. 删除链表的倒数第N个节点
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 *
 * 给定的 n 保证是有效的。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _19_RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n <= 0) {
            return null;
        }
        if (head.next == null && n == 1) {
            return null;
        }
        int length = 0;
        ListNode temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        if (n > length) {
            return null;
        }
        temp = head;
        int step = length - n;
        //判断删除的是否是第一个
        if (length == n) {
            return temp.next;
        }
        while (step > 1) {
            temp = temp.next;
            step--;
        }
        temp.next = temp.next.next;
        return head;
    }
}
