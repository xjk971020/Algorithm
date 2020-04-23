package leetcode;

/**
 * cathetine
 * 19-8-17 下午3:47
 * minimum-depth-of-binary-tree
 * 题目描述
 * 求给定二叉树的最小深度。
 * 最小深度是指树的根结点到最近叶子结点的最短路径上结点的数量。
 * Given a binary tree,find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 */
public class _111_MinimumDepthOfBinaryTree {
    public int run(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        if (treeNode.left == null && treeNode.right == null) {
            return 1;
        }
        if (treeNode.left == null || treeNode.right == null) {
            return Math.max(run(treeNode.left), run(treeNode.right)) + 1;
        }
        return Math.min(run(treeNode.left), run(treeNode.right)) + 1;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
