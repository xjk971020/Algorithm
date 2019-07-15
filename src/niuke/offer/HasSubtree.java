package niuke.offer;

/**
 * @author xjk
 * @date 2019/6/17 -  12:41
 * 题目描述
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 **/
public class HasSubtree {
    /**
     * 从A树根节点递归往下找与B树相同的节点并比较
     * @param root1
     * @param root2
     * @return
     */
    public boolean hasSubtree(TreeNode root1,TreeNode root2) {
        boolean result = false;
        if (root1 != null && root2 != null) {
            result = doesTree1HaveTree2(root1, root2);
            if (!result) {
                hasSubtree(root1.left, root2);
            }
            if (!result) {
                hasSubtree(root1.right, root2);
            }
        }
        return result;
    }

    /**
     * 比较两颗树是否相同
     * 如果B树为空说明已经比较完了, 此时已经可以保证A树中拥有B树
     * B树不为空A树为空则说明A树不拥有B树
     * 如果两个节点的值不相同则说明两个比较的节点不同
     * @param root1
     * @param root2
     * @return
     */
    private boolean doesTree1HaveTree2(TreeNode root1,TreeNode root2) {
        if (root2 == null) {
            return true;
        }
        if (root1 == null) {
            return false;
        }
        if (root1.val != root2.val) {
            return false;
        }
        return doesTree1HaveTree2(root1.left,root2.left) && doesTree1HaveTree2(root1.right, root2.right);
    }
}
