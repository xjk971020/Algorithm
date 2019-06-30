package niuke.offer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @Author:xjk
 * @Date 2019/6/30 17:13
 * 二叉搜索树的第k个结点
 * 题目描述
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。
 * 例如，（5，3，7，2，4，6，8） 中，按结点数值大小顺序第三小结点的值为4。
 */
public class KthNode {
    private ArrayList<TreeNode> vals;
    public KthNode() {
        vals = new ArrayList<>();
    }

    /**
     * 笨方法
     * @param pRoot
     * @param k
     * @return
     */
    public TreeNode KthNode_bad(TreeNode pRoot, int k) {
        if (pRoot == null) {
            return null;
        }
        if (pRoot.left == null && pRoot.right == null) {
            return pRoot;
        }
        addVal(pRoot);
        return vals.get(k);
    }
    private void addVal(TreeNode pRoot) {
        if (pRoot == null) {
            return;
        }
        addVal(pRoot.left);
        vals.add(pRoot);
        addVal(pRoot.right);
    }

    /**
     * 非递归中序遍历二叉树
     * @param pRoot
     * @param k
     * @return
     */
    public static TreeNode kthNode(TreeNode pRoot, int k) {
        if (pRoot == null || k == 0) {
            return null;
        }
        if (pRoot.left == null && pRoot.right == null && k == 1) {
            return pRoot;
        }
        Stack<TreeNode> stack = new Stack<>();
        int count = 0;
        while (!stack.isEmpty() || pRoot != null) {
            if (pRoot != null) {
                stack.push(pRoot);
                pRoot = pRoot.left;
            } else {
                pRoot = stack.pop();
                count++;
                if (count == k) {
                    return pRoot;
                }
                pRoot = pRoot.right;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        System.out.println(KthNode.kthNode(node,2).val);
    }
}
