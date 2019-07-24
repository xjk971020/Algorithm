package niuke.offer;

/**
 * @author:xjk 2019/7/24 10:38
 * niuke.offer
 * 对称的二叉树
 * 题目描述
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。
 * 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 */
public class IsSymmetrical {
    public boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }
        if (pRoot.left == null && pRoot.right == null) {
            return true;
        }
        return symmetrical(pRoot.left, pRoot.right);
    }
    private boolean symmetrical(TreeNode left, TreeNode right) {
        if (left == null) {
            return right == null;
        }
        if (right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return symmetrical(left.left,right.right) && symmetrical(left.right, right.left);
    }
}
