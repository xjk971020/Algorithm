package leetcode;

import java.util.Arrays;

/**
 * @Author:cathetine
 * @Date:19-10-20
 * @Time:上午10:31
 * 106. 从中序与后序遍历序列构造二叉树
 *
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BuildTree {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length == 0) {
            return null;
        }
        if (inorder.length != postorder.length) {
            return null;
        }
        if (postorder.length == 1) {
            return new TreeNode(postorder[0]);
        }
        int length = postorder.length;
        TreeNode root = new TreeNode(postorder[length-1]);
        for (int i = 0;i < length; ++i) {
            if (inorder[i] == postorder[length - 1]) {
                root.left = buildTree(Arrays.copyOfRange(inorder,0,i),Arrays.copyOfRange(postorder,0,i));
                root.right = buildTree(Arrays.copyOfRange(inorder,i+1,length),Arrays.copyOfRange(postorder,i,length - 1));
            }
        }
        return root;
    }
}
