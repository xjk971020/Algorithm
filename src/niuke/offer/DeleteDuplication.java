package niuke.offer;

/**
 * @Author:xjk
 * @Date 2019/6/29 8:51
 * 删除链表中重复的结点
 * 题目描述
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class DeleteDuplication {
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        ListNode head = new ListNode(-1);
        head.next = pHead;
        //设置 pre ，next 指针， pre指针指向当前确定不重复的那个节点，而next指针相当于工作指针，一直往后面搜索。
        ListNode pre = head;
        ListNode next = head.next;
        while (next != null) {
            if (next.next != null && next.val == next.next.val) {
                //一直往后搜索, 知道找到最后一个相同的节点
                while (next.next != null && next.val == next.next.val) {
                    next = next.next;
                }
                pre.next = next.next;
                next = next.next;
            } else {
                pre = pre.next;
                next = next.next;
            }
        }
        return head.next;
    }
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}