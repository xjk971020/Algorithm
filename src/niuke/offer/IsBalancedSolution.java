package niuke.offer;

/**
 * @author:xjk 2019/7/18 14:19
 * niuke.offer
 * 平衡二叉树
 * 题目描述
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 */
public class IsBalancedSolution {

    /**
     * 定义每次递归返回的判断数据
     */
    class ReturnData {
        boolean isBalance;
        int height;
        ReturnData(boolean isBalance, int height) {
            this.isBalance = isBalance;
            this.height = height;
        }
    }

    public boolean isBalancedSolution(TreeNode root) {
        return isBalance(root).isBalance;
    }

    private ReturnData isBalance(TreeNode root) {
        if (root == null) {
            return new ReturnData(true, 0);
        }
        ReturnData leftData = isBalance(root.left);
        if (!leftData.isBalance) {
            return new ReturnData(false, 0);
        }
        ReturnData rightData = isBalance(root.right);
        if (!rightData.isBalance) {
            return new ReturnData(false, 0);
        }
        if (Math.abs(leftData.height - rightData.height) > 1) {
            return new ReturnData(false, 0);
        }
        return new ReturnData(true, Math.max(leftData.height, rightData.height) + 1);
    }
}
