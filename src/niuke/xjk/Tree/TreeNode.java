package niuke.xjk.Tree;

import java.util.Stack;

/**
 * @author xjk
 * @date 2019/3/27 -  15:14
 * 二叉树的遍历
 **/
public class TreeNode {

    public TreeNode left;
    public TreeNode right;
    public int val;
    public TreeNode(int val) {
        this.val = val;
    }

    /**
     * 先序遍历
     * @param treeNode
     */
    public static void preOrderRecur(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        System.out.print(treeNode.val + " ");
        preOrderRecur(treeNode.left);
        preOrderRecur(treeNode.right);
    }

    /**
     * 中序遍历
     * @param treeNode
     */
    public static void inOrderRecur(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        inOrderRecur(treeNode.left);
        System.out.print(treeNode.val + "");
        inOrderRecur(treeNode.right);
    }

    /**
     * 后序遍历
     * @param treeNode
     */
    public static void posOrderRecur(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        posOrderRecur(treeNode.left);
        posOrderRecur(treeNode.right);
        System.out.print(treeNode.val + " ");
    }

    /**
     * 非递归先序遍历
     * @param treeNode
     */
    public static void preOrderUnrecur(TreeNode treeNode) {
        System.out.println("pre-order-unrecur:");
        if (treeNode != null) {
            Stack<TreeNode> stack = new Stack<>();
                stack.add(treeNode);
                while (!stack.isEmpty()) {
                    treeNode = stack.pop();
                    System.out.print(treeNode.val + " ");
                    if (treeNode.right != null) {
                        stack.push(treeNode.right);
                    }
                    if (treeNode.left != null) {
                        stack.push(treeNode.left);
                    }
            }
        }
        System.out.println();
    }

    /**
     * 非递归中序遍历二叉数
     * @param treeNode
     */
    public static void inOrderUnrecur(TreeNode treeNode) {
        if (treeNode != null) {
            Stack<TreeNode> stack = new Stack<>();
            while (!stack.isEmpty() || treeNode != null) {
                if (treeNode != null) {
                    stack.push(treeNode);
                    treeNode = treeNode.left;
                } else {
                    treeNode = stack.pop();
                    System.out.print(treeNode.val + " ");
                    treeNode = treeNode.right;
                }
            }
        }
        System.out.println();
    }

    /**
     * 非递归后序遍历
     * 神奇思路
     * @param treeNode
     */
    public static void posOrderUnrecur(TreeNode treeNode) {
        if (treeNode != null) {
            Stack<TreeNode> stack = new Stack<>();
            Stack<TreeNode> help = new Stack<>();
            stack.push(treeNode);
            while (!stack.isEmpty()) {
                treeNode = stack.pop();
                help.push(treeNode);
                if (treeNode.left != null) {
                    stack.push(treeNode.left);
                }
                if (treeNode.right != null) {
                    stack.push(treeNode.right);
                }
            }
            while (!help.isEmpty()) {
                System.out.print(help.pop().val + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);
        System.out.print("pre order recur: ");
        posOrderRecur(treeNode);
        System.out.println();
        System.out.print("pre order unrecur: ");
        posOrderUnrecur(treeNode);
    }
}
