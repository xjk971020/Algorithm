package niuke.offer;

/**
 * @author xjk
 * @date 2019/5/17 -  23:26
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 **/
public class SymmetricalTree {
    boolean isSymmetrical(TreeNode pRoot)
    {
        if (pRoot == null) {
            return true;
        }
        if (pRoot.left == null && pRoot.right == null) {
            return true;
        }
        return isSameTree(pRoot.left,pRoot.right);
    }
    private boolean isSameTree(TreeNode left,TreeNode right) {
        if (left == null) {
            return right == null;
        }
        if (right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return isSameTree(left.left,right.right) && isSameTree(left.right,right.left);
    }
}