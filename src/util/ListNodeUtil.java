package util;

import leetcode.ListNode;

public class ListNodeUtil {

    public static ListNode createList(int... vals) {
        if (vals == null || vals.length <= 0) {
            throw new NullPointerException();
        }
        ListNode root = new ListNode(vals[0]);

        if (vals.length == 1) {
            return root;
        }

        ListNode next = new ListNode(vals[1]);
        root.next = next;

        for (int i = 2; i < vals.length; i++) {
            next.next = new ListNode(vals[i]);
            next = next.next;
        }

        return root;
    }

    public static void printNode(ListNode root) {
        if (root == null) {
            throw new NullPointerException();
        }

        while (root != null) {
            System.out.print(root.val + " ");
            root = root.next;
        }
        System.out.println();
    }

}
