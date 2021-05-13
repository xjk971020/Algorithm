package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:xjk
 * @Description: 1305. 两棵二叉搜索树中的所有元素
 * 给你 root1 和 root2 这两棵二叉搜索树。
 * <p>
 * 请你返回一个列表，其中包含 两棵树 中的所有整数并按 升序 排序。.
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：root1 = [2,1,4], root2 = [1,0,3]
 * 输出：[0,1,1,2,3,4]
 * 示例 2：
 * <p>
 * 输入：root1 = [0,-10,10], root2 = [5,1,7,0,2]
 * 输出：[-10,0,0,1,2,5,7,10]
 * 示例 3：
 * <p>
 * 输入：root1 = [], root2 = [5,1,7,0,2]
 * 输出：[0,1,2,5,7]
 * 示例 4：
 * <p>
 * 输入：root1 = [0,-10,10], root2 = []
 * 输出：[-10,0,10]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/all-elements-in-two-binary-search-trees
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2021/4/29
 */
public class _1305_GetAllElements {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    List<Integer> result = new ArrayList<>();

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return result;
        }

        if (root1 == null) {
            getAllElements(root1, root2.left);
            result.add(root2.val);
            getAllElements(root1, root2.right);
            return result;
        }

        if (root2 == null) {
            getAllElements(root1.left, root2);
            result.add(root1.val);
            getAllElements(root1.right, root2);
            return result;
        }

        if (root1.val >= root2.val) {
            getAllElements(root1.left, root2);
            result.add(root2.val);
            getAllElements(root1, root2.right);
        } else {
            getAllElements(root1, root2.left);
            result.add(root1.val);
            getAllElements(root1, root2.right);
        }

        return result;
    }

}
