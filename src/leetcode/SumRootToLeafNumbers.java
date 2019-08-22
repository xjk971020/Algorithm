package leetcode;

import java.util.ArrayList;

/**
 * cathetine
 * 19-8-22 下午8:13
 * sum-root-to-leaf-numbers
 * 题目描述
 * 给定一个仅包含数字0-9的二叉树，每一条从根节点到叶子节点的路径都可以用一个数字表示。
 * 例如根节点到叶子节点的一条路径是1->2->3,那么这条路径就用123来代替。
 * 找出根节点到叶子节点的所有路径表示的数字之和
 * 例如：
 *     1↵   / ↵  2   3
 * 根节点到叶子节点的路径1->2用数字12代替
 * 根节点到叶子节点的路径1->3用数字13代替
 * 所以答案为12+13=25
 *
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 * An example is the root-to-leaf path1->2->3which represents the number123.
 * Find the total sum of all root-to-leaf numbers.
 * For example,
 *     1↵   / ↵  2   3
 * The root-to-leaf path1->2represents the number12.
 * The root-to-leaf path1->3represents the number13.
 * Return the sum = 12 + 13 =25.
 */
public class SumRootToLeafNumbers {
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        ArrayList<Integer> results = new ArrayList<>();
        process(root, "", results);
        int total = 0;
        for (int i = 0; i < results.size(); i++) {
            total += results.get(i);
        }
        return total;
    }

    private void process(TreeNode node, String num, ArrayList<Integer> results) {
        if (node.left == null && node.right == null) {
            results.add(Integer.valueOf(num + node.val));
            return;
        }
        num = num + node.val;
        if (node.left != null) {
            process(node.left, num, results);
        }
        if (node.right != null) {
            process(node.right, num, results);
        }
    }
}