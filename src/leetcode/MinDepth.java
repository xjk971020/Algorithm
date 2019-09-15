package leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author:cathetine
 * @Date:19-9-15
 * @Time:下午10:54
 * 111. 二叉树的最小深度
 *
 * 给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 *
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最小深度  2.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-depth-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinDepth {
    /**
     * 广度优先遍历
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        if (root == null)
            return 0;
        queue.offer(root);
        /**********修改的地方*****************/
        int level = 1;
        /***********************************/
        while (!queue.isEmpty()) {
            int levelNum = queue.size(); // 当前层元素的个数
            for (int i = 0; i < levelNum; i++) {
                TreeNode curNode = queue.poll();
                if (curNode != null) {
                    /**********修改的地方*****************/
                    if (curNode.left == null && curNode.right == null) {
                        return level;
                    }
                    /***********************************/
                    if (curNode.left != null) {
                        queue.offer(curNode.left);
                    }
                    if (curNode.right != null) {
                        queue.offer(curNode.right);
                    }
                }
            }
            level++;
        }
        return level;
    }
}
