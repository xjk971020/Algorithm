package leetcode;

import java.util.Arrays;

/**
 * @author xjk
 * @date 2019/4/5 -  10:28
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 **/
public class SortList {

    public static ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode lengthNodeTemp = head;
        int length = 0;
        while (lengthNodeTemp != null) {
            length++;
            lengthNodeTemp = lengthNodeTemp.next;
        }
        int[] arr = new int[length];
        int i = 0;
        while (head != null) {
            arr[i++] = head.val;
            head = head.next;
        }
        Arrays.sort(arr);
        ListNode node = new ListNode(arr[0]);
        ListNode nodeTemp = node;
        for (i = 1; i < arr.length; i++) {
            node.next = new ListNode(arr[i]);
            node = node.next;
        }
        return nodeTemp;
    }
    /**
     * 参考：Sort List——经典（链表中的归并排序） https://www.cnblogs.com/qiaozhoulin/p/4585401.html
     *
     * 归并排序法：在动手之前一直觉得空间复杂度为常量不太可能，因为原来使用归并时，都是 O(N)的，
     * 需要复制出相等的空间来进行赋值归并。对于链表，实际上是可以实现常数空间占用的（链表的归并
     * 排序不需要额外的空间）。利用归并的思想，递归地将当前链表分为两段，然后merge，分两段的方
     * 法是使用 fast-slow 法，用两个指针，一个每次走两步，一个走一步，知道快的走到了末尾，然后
     * 慢的所在位置就是中间位置，这样就分成了两段。merge时，把两段头部节点值比较，用一个 p 指向
     * 较小的，且记录第一个节点，然后 两段的头一步一步向后走，p也一直向后走，总是指向较小节点，
     * 直至其中一个头为NULL，处理剩下的元素。最后返回记录的头即可。
     *
     * 主要考察3个知识点，
     * 知识点1：归并排序的整体思想
     * 知识点2：找到一个链表的中间节点的方法
     * 知识点3：合并两个已排好序的链表为一个新的有序链表
     */
    StringBuffer stringBuffer;

    public ListNode mergeSortList(ListNode head) {
        return head == null ? null : mergeSort(head);
    }

    private ListNode mergeSort(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode p = head, q = head, pre = null;
        while (q != null && q.next != null) {
            pre = p;
            p = p.next;
            q = q.next.next;
        }
        pre.next = null;
        ListNode l = mergeSort(head);
        ListNode r = mergeSort(p);
        return merge(l, r);
    }

    ListNode merge(ListNode l, ListNode r) {
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        while (l != null && r != null) {
            if (l.val <= r.val) {
                cur.next = l;
                cur = cur.next;
                l = l.next;
            } else {
                cur.next = r;
                cur = cur.next;
                r = r.next;
            }
        }
        if (l != null) {
            cur.next = l;
        }
        if (r != null) {
            cur.next = r;
        }
        return dummyHead.next;
    }
    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(235);
        ListNode three = new ListNode(123);
        ListNode four = new ListNode(14);
        ListNode five = new ListNode(11);
        ListNode six = new ListNode(16);
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = six;
        ListNode head = SortList.sortList(one);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
