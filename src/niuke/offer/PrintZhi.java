package niuke.offer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * author:xjk
 * 2019/6/13 15:32
 * niuke.offer
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，
 * 第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 */
public class PrintZhi {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (pRoot == null) {
            return result;
        }
        int flag = 1;
        Stack<TreeNode> left = new Stack<>();
        Stack<TreeNode> right = new Stack<>();
        left.push(pRoot);

        while (!left.isEmpty() || !right.isEmpty()) {
            if (flag % 2 != 0) {
                ArrayList<Integer> level = new ArrayList<>();
                while (!left.isEmpty()) {
                    TreeNode node = left.pop();
                    if (node != null) {
                        level.add(node.val);
                        right.push(node.left);
                        right.push(node.right);
                    }
                }
                if (!level.isEmpty()) {
                    result.add(level);
                    flag++;
                }
            }
            if (flag % 2 == 0) {
                ArrayList<Integer> level = new ArrayList<>();
                while (!right.isEmpty()) {
                    TreeNode node = right.pop();
                    if (node != null) {
                        level.add(node.val);
                        left.add(node.right);
                        left.add(node.left);
                    }
                }
                if (!level.isEmpty()) {
                    result.add(level);
                    flag++;
                }
            }
        }
        return result;
    }
}
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
