package niuke.offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author:xjk 2019/7/17 10:59
 * niuke.offer
 * 二叉树的深度
 * 题目描述
 * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度
 */
public class TreeDepth {
    /**
     * 递归做法
     * @param root
     * @return
     */
    public int treeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = treeDepth(root.left);
        int right = treeDepth(root.right);
        return Math.max(left, right) + 1;
    }

    /**
     * 非递归做法,层次遍历
     * @param root
     * @return
     */
    public int treeDepth_(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0, count = 0, nextCount = 1;
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            count++;
            if (temp.left != null) {
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }
            if (count == nextCount) {
                count = 0;
                nextCount = queue.size();
                depth++;
            }
        }
        return depth;
    }
}
