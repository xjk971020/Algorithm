package niuke.xjk.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author xjk
 * @date 2019/3/30 -  23:22
 * 判断是否是完全二叉树
 **/
public class IsCST {
    public static boolean isCST(Node head) {
        if (head == null) {
            return false;
        }
        Queue<Node> queue = new LinkedList<>();
        boolean leaf = false;
        queue.offer(head);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            Node left = node.left;
            Node right = node.right;
            boolean isCST = (leaf && (left!= null || right != null)) || (left == null && right != null);
            if (isCST) {
                return false;
            }
            if (left != null) {
                queue.offer(left);
            }
            if (right != null) {
                queue.offer(right);
            } else {
                leaf = true;
            }
        }
        return true;
    }
}
