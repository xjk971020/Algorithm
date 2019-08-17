package leetcode;

import java.util.Stack;

/**
 * 判断是否回文数
 */
public class Palindrome {
    public static boolean isPalindrome(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode node = head;
        while (node != null) {
            stack.push(node.val);
            node = node.next;
        }
        int stackLength = stack.size();
        int[] arr = new int[stack.size() / 2];
        for (int i = stack.size() / 2 - 1; i >= 0; -- i) {
            arr[i] = stack.pop();
        }
        if (stackLength % 2 != 0) {
            stack.pop();
        }
        int length = 0;
        while (!stack.isEmpty()) {
            if (stack.pop() != arr[length]) {
                return false;
            }
            length++;
        }
        return true;
    }

     public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node1.next = node2;
         System.out.println(Palindrome.isPalindrome(node1));
     }
}