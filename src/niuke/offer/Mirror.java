package niuke.offer;

/**
 * @author xjk
 * @date 2019/6/16 -  22:19
 * 二叉树的镜像
 * 题目描述
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 **/
public class Mirror {
    /**
     * 递归交换节点
     * @param root
     */
    public void mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        mirror(root.left);
        mirror(root.right);
    }
}
