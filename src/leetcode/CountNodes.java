package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author:cathetine
 * @Date:19-9-12
 * @Time:下午3:11
 * 222. 完全二叉树的节点个数
 * 给出一个完全二叉树，求出该树的节点个数。
 *
 * 说明：
 *
 * 完全二叉树的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。
 *
 * 示例:
 *
 * 输入:
 *     1
 *    / \
 *   2   3
 *  / \  /
 * 4  5 6
 *
 * 输出: 6
 */
public class CountNodes {

    /**
     * 二分法, 判断左右节点的最大高度, 如果最大高度相等, 说明底层最右边的节点为右子树，否则为左子树
     * 二分法的思想在于:每一次计算都有一半的节点不用再计算
     * @param root
     * @return
     */
    public int countNodes_(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = countNodes_(root.left);
        int rightDepth = countNodes_(root.right);
        if (leftDepth == rightDepth) {
            return countNodes_(root.right) + (1 << leftDepth);
        } else {
            return countNodes_(root.left) + (1 << rightDepth);
        }
    }

    /**
     * 获得某颗树的最大高度
     * @param node
     * @return
     */
    private int getDepth(TreeNode node) {
        int height = 0;
        while (node != null) {
            height++;
            node = node.left;
        }
        return height;
    }

    /**
     * 层序遍历
     * @param root
     * @return
     */
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                TreeNode temp = queue.poll();
                count++;
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }
        }
        return count;
    }

}
