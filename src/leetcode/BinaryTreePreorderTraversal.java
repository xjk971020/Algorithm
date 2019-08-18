package leetcode;

import java.util.ArrayList;

/**
 * cathetine
 * 19-8-18 下午11:48
 * binary-tree-preorder-traversal
 * 题目描述
 * 求给定的二叉树的前序遍历。
 * 例如：
 * 给定的二叉树为{1,#,2,3},
 *    1↵    ↵     2↵    /↵   3↵
 * 返回：[1,2,3].
 * 备注；用递归来解这道题太没有新意了，可以给出迭代的解法么？
 *
 * Given a binary tree, return the preorder traversal of its nodes' values.
 * For example:
 * Given binary tree{1,#,2,3},
 *
 *    1↵    ↵     2↵    /↵   3↵
 *
 * return[1,2,3].
 *
 * Note: Recursive solution is trivial, could you do it iteratively?
 */
public class BinaryTreePreorderTraversal {
    private ArrayList<Integer> list = new ArrayList<>();
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return list;
        }
        if (root.left == null && root.right == null) {
            list.add(root.val);
            return list;
        }
        list.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return list;
    }
}
