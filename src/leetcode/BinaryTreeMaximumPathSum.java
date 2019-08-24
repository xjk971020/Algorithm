package leetcode;

/**
 * cathetine
 * 19-8-23 下午10:54
 * binary-tree-maximum-path-sum
 * 题目描述
 * 给定一个二叉树，请计算节点值之和最大的路径的节点值之和是多少。
 * 这个路径的开始节点和结束节点可以是二叉树中的任意节点
 * 例如：
 * 给出以下的二叉树，
 *        1↵      / ↵     2   3
 * 返回的结果为6
 *
 * Given a binary tree, find the maximum path sum.
 * The path may start and end at any node in the tree.
 *
 * For example:
 * Given the below binary tree,
 *
 *        1↵      / ↵     2   3↵
 *
 * Return6.
 */
public class BinaryTreeMaximumPathSum {
    private int maxValue;
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        maxValue = Integer.MIN_VALUE;
        process(root);
        return maxValue;
    }
    private int process(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMax = Math.max(0, process(root.left));
        int rightMax = Math.max(0,process(root.right));
        maxValue = Math.max(maxValue, root.val + leftMax + rightMax);
        return Math.max(0, root.val + Math.max(leftMax,rightMax));
    }
}
