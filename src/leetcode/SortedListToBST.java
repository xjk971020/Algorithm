package leetcode;

/**
 * @Author:cathetine
 * @Date:19-10-24
 * @Time:下午1:46
 * 109. 有序链表转换二叉搜索树
 *
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 *
 * 给定的有序链表： [-10, -3, 0, 5, 9],
 *
 * 一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SortedListToBST {
    private ListNode findMiddleNode(ListNode listNode) {
        if (listNode == null || listNode.next == null) {
            return listNode;
        }
        ListNode pre = listNode;
        ListNode cur = null;
        ListNode next = listNode;
        //注意此处不能用next.next != null && next.next.next != null 作为条件,当链表中只有两个节点的时候会出问题
        while (next != null && next.next != null) {
            cur = pre;
            pre = pre.next;
            next = next.next.next;
        }
        if (cur != null) {
            cur.next = null;
        }
        return pre;
    }
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode middleNode = findMiddleNode(head);
        TreeNode root = new TreeNode(middleNode.val);
        if (middleNode == head) {
            return root;
        }
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(middleNode.next);
        return root;
    }
}
