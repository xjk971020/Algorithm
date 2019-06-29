package niuke.offer;

/**
 * @Author:xjk
 * @Date 2019/6/29 10:41
 * 在O(1)时间内删除链表中指定节点
 * 题目描述
 * 给定单向链表的头指针和一个节点指针，定义一个函数在O(1)时间删除该节点。
 */
public class DeleteNodeInList {
    public ListNode deleteNode(ListNode head, ListNode node) {
        if (head == null) {
            return null;
        }
        if (node == head) {
            head = head.next;
        } else if (node.next == null){
            ListNode temp = head;
            while (temp.next != node) {
                temp = temp.next;
            }
            temp.next = null;
        } else {
            node.val = node.next.val;
            node.next = node.next.next;
        }
        return head;
    }
}
