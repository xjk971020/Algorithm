package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: xjk
 * @Date: 2019/10/25
 * @Time: 11:33
 * 257. 二叉树的所有路径
 *
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 *
 * 输入:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * 输出: ["1->2->5", "1->3"]
 *
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-paths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _257_BinaryTreePaths {
    /**
     * dfs+回溯
     * @param root
     * @return
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new LinkedList<>();
        process("",root,result);
        return result;
    }
    private void process(String path, TreeNode root, List<String> result) {
        if (root == null) {
            return;
        }
        path = path + root.val;
        if (root.left == null && root.right == null) {
            result.add(path);
            return;
        }
        path = path + "->";
        process(path,root.left,result);
        process(path,root.right,result);
    }

    /**
     * bfs
     * @param root
     * @return
     */
    public List<String> binaryTreePaths_(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        LinkedList<String> strs = new LinkedList<>();
        LinkedList<TreeNode> nodes = new LinkedList<>();
        String path;
        nodes.add(root);
        strs.add(String.valueOf(root.val));
        while (!nodes.isEmpty()) {
            TreeNode node = nodes.poll();
            path = strs.poll();
            if (node.left == null && node.right == null) {
                result.add(path);
            }
            if (node.left != null) {
                nodes.add(node.left);
                strs.add(path + "->" + node.left.val);
            }
            if (node.right != null) {
                nodes.add(node.right);
                strs.add(path + "->" + node.right.val);
            }
        }
        return result;
    }
}
