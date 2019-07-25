package niuke.offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author:xjk
 * @Date 2019/7/24 21:57
 * 序列化二叉树
 * 题目描述
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 */
public class SerializeTree {
    public String Serialize(TreeNode root) {
        if (root == null) {
            return "#!";
        }
        String str = root.val + "!";
        str = str + Serialize(root.left);
        str = str + Serialize(root.right);
        return str;
    }
    public TreeNode Deserialize(String str) {
        String[] strs = str.split("!");
        Queue<String> queue = new LinkedList<>();
        for (String s : strs) {
            queue.add(s);
        }
        return reDeserialize(queue);
    }

    private TreeNode reDeserialize(Queue<String> queue) {
        String s = queue.poll();
        if (s.equals("#")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(s));
        root.left = reDeserialize(queue);
        root.right = reDeserialize(queue);
        return root;
    }
}
