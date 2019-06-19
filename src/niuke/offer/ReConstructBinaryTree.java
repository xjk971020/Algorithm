package niuke.offer;

import java.util.Arrays;

/**
 * author:xjk
 * 2019/6/18 11:42
 * niuke.offer
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */
public class ReConstructBinaryTree {
    
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if (pre.length != in.length) {
            throw new RuntimeException("前序遍历数组长度与中序遍历数组长度不相等");
        }
        if (pre.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(pre[0]);
        for (int i = 0; i < in.length; ++i) {
            if (root.val == in[i]) {
                root.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, i+1),Arrays.copyOfRange(in, 0, i));
                root.right  = reConstructBinaryTree(Arrays.copyOfRange(pre, i+1, pre.length),Arrays.copyOfRange(in, i+1, in.length));
            }
        }
        return root;
    }
}
