package niuke.xjk.Tree;

/**
 * @author xjk
 * @date 2019/4/5 -  18:41
 * 与树有关的方法
 **/
public class TreeMethod {
    /**
     * 求二叉树的最大深度
     * @param node
     * @return
     */
    public static int getMaxDepth(Node node) {
        if (node == null) {
            return 0;
        }
        int left = getMaxDepth(node.left);
        int right = getMaxDepth(node.right);
        return Math.max(left,right) + 1;
    }

    /**
     * 求二叉树中叶子节点的个数
     * @param head
     * @return
     */
    public static int numsOfNoChildNode(Node head) {
        if (head == null) {
            return 0;
        }
        if (head.left == null && head.right == null) {
            return 1;
        }
        return numsOfNoChildNode(head.left) + numsOfNoChildNode(head.right);
    }
}
