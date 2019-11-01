package leetcode;

/**
 * @author: xjk
 * @Date: 2019/11/1
 * @Time: 17:51
 * 24. 两两交换链表中的节点
 *
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 *  
 *
 * 示例:
 *
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _24_SwapPairs {
    /**
     * 递归写法
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }
    /**
     * 迭代
     */
    public ListNode swapPairs_(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        //用tempHead去循环
        ListNode tempHead = dummyHead;
        while (tempHead.next != null && tempHead.next.next != null) {
            ListNode pre = tempHead.next;
            ListNode next = tempHead.next.next;
            pre.next = next.next;
            next.next = pre;
            tempHead.next = next;
            //注意这里要变成等于pre，pre位置已经被调换到后一个指针
            tempHead = pre;
        }
        return dummyHead.next;
    }
}
