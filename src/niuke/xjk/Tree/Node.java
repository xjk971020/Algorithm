package niuke.xjk.Tree;

/**
 * @author xjk
 * @date 2019/3/28 -  10:11
 * 有父节点的数
 **/
public class Node {
    public Node parent;
    public Node left;
    public Node right;
    public int value;
    public Node(int value) {
        this.value = value;
    }

}
