/**
 *输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 *    public class ListNode {
 *        int val;
 *        ListNode next = null;
 *
 *        ListNode(int val) {
 *            this.val = val;
 *        }
 *    }
 *
 */
public class Solution{

	private ArrayList<Integer> list = new ArrayList<Integer>();
	/**
	 *递归
	 */
	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		if (listNode != null) {
			printListFromTailToHead(listNode.next);
			list.add(listNode.val);
		}
		return list;
	}
	/**
	 *迭代
	 */
	public ArrayList<Integer> iteration(ListNode listNode) {
		if (listNode != null) {
			list.add(listNode.val);
			ListNode nextNode = listNode.next;
			while (nextNode != null) {
				list.add(nextNode.val);
				nextNode = nextNode.next;
			}
		}
		Colliections.reverse(list);
		return list;
	}
}