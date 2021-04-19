package leetcode;

/**
 * @Author:cathetine
 * @Date:19-10-20
 * @Time:下午12:23
 * 129. 求根到叶子节点数字之和
 * <p>
 * 给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。
 * <p>
 * 例如，从根到叶子节点路径 1->2->3 代表数字 123。
 * <p>
 * 计算从根到叶子节点生成的所有数字之和。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3]
 * 1
 * / \
 * 2   3
 * 输出: 25
 * 解释:
 * 从根到叶子节点路径 1->2 代表数字 12.
 * 从根到叶子节点路径 1->3 代表数字 13.
 * 因此，数字总和 = 12 + 13 = 25.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-root-to-leaf-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SumNumbers {
    int total = 0;

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return total;
        }
        getAllPathTotal(0, root);
        return total;
    }

    private void getAllPathTotal(int sum, TreeNode root) {
        if (root.left == null && root.right == null) {
            total = total + sum + root.val;
            return;
        }
        if (root.left != null) {
            getAllPathTotal(sum * 10 + root.val * 10, root.left);
        }
        if (root.right != null) {
            getAllPathTotal(sum * 10 + root.val * 10, root.right);
        }
    }

    /**
     * 2021-04-12 深度搜索
     * @param root
     * @return
     */
    public int sumNumbers_1(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int curResult = 0;
        return sum(root, "", curResult);
    }

    private int sum(TreeNode node, String curNum, int result) {
        curNum = curNum + node.val;

        if (node.left != null && node.right != null) {
            return sum(node.left, curNum, result) + sum(node.right, curNum, result);
        }

        if (node.left != null) {
            return sum(node.left, curNum, result);
        }

        if (node.right != null) {
            return sum(node.right, curNum, result);
        }

        return result + Integer.parseInt(curNum);
    }
}
