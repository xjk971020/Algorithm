package niuke.xjk.Tree;

/**
 * @author xjk
 * @date 2019/3/29 -  9:29
 * 在二叉树中找到一个一个节点的后继节点
 **/
public class SuccessorNode {

    /**
     * 获取后继节点
     * @param node
     * @return
     */
    public static Node getSuccessorNode(Node node) {
        if (node == null) {
            return null;
        }
        if (node.right != null) {
            return getMostLeftNode(node.right);
        } else {
            Node parent = node.parent;
            while (parent != null && parent.left != node) {
                node = parent;
                parent = node.parent;
            }
            return parent;
        }
    }

    /**
     * 获得一个节点的最左孩子
     * @param node
     * @return
     */
    public static Node getMostLeftNode(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}
