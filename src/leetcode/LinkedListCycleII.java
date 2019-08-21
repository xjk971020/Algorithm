package leetcode;

/**
 * @author:xjk 2019/8/21 18:54
 * leetcode
 * linked-list-cycle-ii
 * 题目描述
 * 对于一个给定的链表，返回环的入口节点，如果没有环，返回null
 * 拓展：
 * 你能给出不利用额外空间的解法么？
 *
 * Given a linked list, return the node where the cycle begins. If there is no cycle, returnnull.
 * Follow up:
 * Can you solve it without using extra space?
 */
public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                slow = head;
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }
}
