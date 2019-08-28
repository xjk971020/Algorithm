package leetcode;

/**
 * @author: xjk
 * @Date: 2019/8/28
 * @Time: 16:39
 * path-sum
 * 题目描述
 * 给定一个二叉树和一个值sum，判断是否有从根节点到叶子节点的节点值之和等于sum的路径，
 * 例如：
 * 给出如下的二叉树，sum=22，
 *               5↵             / ↵            4   8↵           /   / ↵          11  13  4↵         /      / ↵        7    2  5   1
 * 返回true，因为存在一条路径5->4->11->2的节点值之和为22
 *
 *
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 * For example:
 * Given the below binary tree andsum = 22,
 *               5↵             / ↵            4   8↵           /   / ↵          11  13  4↵         /        ↵        7    2      1↵
 * return true, as there exist a root-to-leaf path5->4->11->2which sum is 22.
 */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null && root.val == sum) {
            return true;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}
