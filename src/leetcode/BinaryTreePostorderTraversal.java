package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * cathetine
 * 19-8-18 下午9:06
 * binary-tree-postorder-traversal
 * 题目描述
 * 求给定的二叉树的后序遍历。
 * 例如：
 * 给定的二叉树为{1,#,2,3},
 *     1↵    ↵     2↵    /↵   3↵
 * 返回[3,2,1].
 * 备注；用递归来解这道题太没有新意了，可以给出迭代的解法么？
 *
 * Given a binary tree, return the postorder traversal of its nodes' values.
 * For example:
 * Given binary tree{1,#,2,3},
 *    1↵    ↵     2↵    /↵   3↵
 *
 * return[3,2,1].
 *
 * Note: Recursive solution is trivial, could you do it iteratively?
 */
public class BinaryTreePostorderTraversal {
    private ArrayList<Integer> list = new ArrayList<>();
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return list;
        }
        if (root.left == null && root.right == null) {
            list.add(root.val);
            return list;
        }
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        list.add(root.val);
        return list;
    }

    /**
     * 非递归
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal_(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        if (root == null) {
            return results;
        }
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> help = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            help.push(root);
            if (root.left != null) {
                stack.push(root.left);
            }
            if (root.right != null) {
                stack.push(root.right);
            }
        }
        while (!help.isEmpty()) {
            results.add(help.pop().val);
        }
        return results;
    }
}
