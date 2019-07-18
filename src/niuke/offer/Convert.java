package niuke.offer;

/**
 * @author:xjk 2019/7/18 15:16
 * niuke.offer
 * 二叉搜索树与双向链表
 * 题目描述
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class Convert {
    private TreeNode head = null;
    private TreeNode realHead = null;
    /**
     * 利用二叉搜索树的特点, 进行中序遍历, 当递归到左子树第一个节点时设置为头节点, 接着每次递归过程中root节点和head节点的关系都为root>head
     * 此时只需要修改head的右指针指向root, root的左指针指向head, 再令head = root即可
     * @param root
     * @return
     */
    public TreeNode convert(TreeNode root) {
        convertSub(root);
        return realHead;
    }

    private void convertSub(TreeNode root) {
        if (root == null) {
            return;
        }
        convertSub(root.left);
        if (realHead == null) {
            head = root;
            realHead = root;
        } else {
            head.right = root;
            root.left = head;
            head = root;
        }
        convertSub(root.right);
    }
}
