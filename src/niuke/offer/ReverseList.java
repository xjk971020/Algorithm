package niuke.offer;

/**
 * @Author:xjk
 * @Date 2019/7/14 15:18
 * 反转链表
 * 题目描述
 * 输入一个链表，反转链表后，输出新链表的表头。
 */
public class ReverseList {
    /**
     * 递归的方法其实是非常巧的，它利用递归走到链表的末端，
     * 然后再更新每一个node的next值 ，实现链表的反转。而newhead的值没有发生改变，
     * 为该链表的最后一个结点，所以，反转后，我们可以得到新链表的head。
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        //如果链表为空或者链表中只有一个元素
        if (head == null || head.next == null) {
            return head;
        }
        //先反转后面的链表，走到链表的末端结点
        ListNode pReverseRoot = reverseList(head.next);
        //再将当前节点设置为后面节点的后续节点
        head.next.next = head;
        head.next = null;
        return pReverseRoot;
    }

    /**
     * 迭代
     * 设两个指针
     * @param head
     * @return
     */
    public ListNode rreverseList_(ListNode head) {
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
