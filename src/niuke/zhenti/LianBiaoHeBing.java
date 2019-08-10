package niuke.zhenti;

import java.util.Scanner;

/**
 * @Author:xjk
 * @Date 2019/8/10 16:00
 * 链表合并
 * 题目描述
 * 请编写一段代码，实现两个单向有序链表的合并
 * 输入描述:
 * 第一行一个链表，如1 2 3 4 5
 *
 * 第二行一个链表，如2 3 4 5 6
 * 输出描述:
 * 输出：1 2 2 3 3 4 4 5 5 6
 */
public class LianBiaoHeBing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] first = scanner.nextLine().split(" ");
        String[] second = scanner.nextLine().split(" ");
        ListNode firstHead = new ListNode(Integer.valueOf(first[0]));
        ListNode temp = firstHead;
        for (int i = 1; i < first.length; i++) {
            temp.next = new ListNode(Integer.valueOf(first[i]));
            temp = temp.next;
        }
        ListNode secondHead = new ListNode(Integer.valueOf(second[0]));
        temp = secondHead;
        for (int i = 1; i < second.length; i++) {
            temp.next = new ListNode(Integer.valueOf(second[i]));
            temp = temp.next;
        }
        ListNode head = mergeList(firstHead,secondHead);
        while (head != null) {
            if (head.next == null) {
                System.out.print(head.val);
                head = head.next;
                continue;
            }
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
    private static ListNode mergeList(ListNode node1, ListNode node2) {
        if (node1 == null && node2 != null) {
            return node2;
        }
        if (node2 == null && node1 != null) {
            return node1;
        }
        if (node1 == null && node2 == null) {
            return null;
        }
        if (node1.val >= node2.val) {
            node2.next = mergeList(node1,node2.next);
            return node2;
        } else {
            node1.next = mergeList(node1.next, node2);
            return node1;
        }
    }
}

class ListNode  {
    int val;
    ListNode next;
    public ListNode(int val) {
        this.val = val;
    }
}
