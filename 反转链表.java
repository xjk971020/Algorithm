/**
 *反转链表
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution{
	/**
	 *栈
	 */
	public ListNode reverseList(ListNode listNode) {
		if (listNode != null) {
			Stack<Integer> stack = new Stack<Integer>();
			ListNode temp = listNode;
			while(temp.next != null) {
				stack.push(temp.val);
				temp = temp.next;
			}
			listNode = temp;
			while (!stack.isEmpty()) {
				temp.next = new ListNode(stack.pop());
				temp = temp.next;
			}
			return listNode;
		} else {
			return listNode;
		}
	}
	/**
	 *迭代
	 */
	public ListNode ReverseList(ListNode head) {
        ListNode pre = null;
        ListNode next = null;
        if (head == null) {
            return null;
        }
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}