package niuke.offer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * author:xjk
 * 2019/6/13 15:32
 * niuke.offer
 * 按之字形顺序打印二叉树
 * 题目描述
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，
 * 第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 */
public class PrintZhi {
    public ArrayList<ArrayList<Integer>> print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (pRoot == null) {
            return result;
        }
        int levelCount = 1;
        Stack<TreeNode> left = new Stack<>();
        Stack<TreeNode> right = new Stack<>();
        right.add(pRoot);
        while (!left.isEmpty() || !right.isEmpty()) {
            ArrayList<Integer> level = new ArrayList<>();
            if (levelCount % 2 == 0) {
                while (!left.isEmpty()) {
                    TreeNode tempLeft = left.pop();
                    if (tempLeft != null) {
                        right.add(tempLeft.right);
                        right.add(tempLeft.left);
                        level.add(tempLeft.val);
                    }
                }
            } else {
                while (!right.isEmpty()) {
                    TreeNode tempRight = right.pop();
                    if (tempRight != null) {
                        left.add(tempRight.left);
                        left.add(tempRight.right);
                        level.add(tempRight.val);
                    }
                }
            }
            levelCount++;
            if (!level.isEmpty()) {
                result.add(level);
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
