package niuke.offer;

/**
 * @Author:xjk
 * @Date 2019/6/28 20:28
 * 链表中环的入口结点
 * 题目描述
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 */
public class EntryNodeOfLoop {
    public ListNode entryNodeOfLoop(ListNode pHead) {
        ListNode meetingNode = meetingNode(pHead);
        if (meetingNode == null) {
            return null;
        }
        while (meetingNode != pHead) {
            meetingNode = meetingNode.next;
            pHead = pHead.next;
        }
        return meetingNode;
    }

    /**
     * 找出快慢指针相遇的节点
     * @param pHead
     * @return
     */
    private ListNode meetingNode(ListNode pHead) {
        if (pHead == null) {
            return null;
        }
        ListNode pre = pHead;
        ListNode next = pHead;
        if (pre.next == null) {
            return null;
        }
        while (pre != null && next != null) {
            if (pre.next != null) {
                pre = pre.next;
            }
            if (next.next != null && next.next.next != null) {
                next = next.next.next;
            }
            if (next == pre) {
                return pre;
            }
        }
        return null;
    }

    /**
     * 时间复杂度为O（n），两个指针，一个在前面，另一个紧邻着这个指针，在后面。
     * 两个指针同时向前移动，每移动一次，前面的指针的next指向NULL。
     * 也就是说：访问过的节点都断开，最后到达的那个节点一定是尾节点的下一个，
     * 也就是循环的第一个。
     * 这时候已经是第二次访问循环的第一节点了，第一次访问的时候我们已经让它指向了NULL，
     * 所以到这结束。
     * @param pHead
     * @return
     */
    ListNode entryNodeOfLoop_(ListNode pHead) {
        if (pHead == null) {
            return null;
        }
        ListNode pre = pHead;
        ListNode next = pHead;
        while (next.next != null && next.next.next != null) {
            pre = pre.next;
            next = next.next.next;
            if (pre == next) {
                next = pHead;
                while (pre != next) {
                    next = next.next;
                    pre = pre.next;
                }
                //这个判断必须放在while后面，不然当第一个节点是环的入口节点的时候，会出现死循环
                if (next == pre) {
                    return pre;
                }
            }
        }
        return null;
    }
}
