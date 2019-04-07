package niuke.xjk.Tree;

/**
 * @author xjk
 * @date 2019/3/30 -  22:28
 * 测试树的主方法
 **/
public class Main {
    public static void main(String[] args) {
        Node head = new Node(6);
        head.parent = null;
        head.left = new Node(3);
        head.left.parent = head;
        head.left.left = new Node(1);
        head.left.left.parent = head.left;
        head.left.left.right = new Node(2);
        head.left.left.right.parent = head.left.left;
        head.left.right = new Node(4);
        head.left.right.parent = head.left;
        head.left.right.right = new Node(5);
        head.left.right.right.parent = head.left.right;
        head.right = new Node(9);
        head.right.parent = head;
        head.right.left = new Node(8);
        head.right.left.parent = head.right;
        head.right.left.left = new Node(7);
        head.right.left.left.left = new Node(11);
        head.right.left.left.parent = head.right.left;
        head.right.right = new Node(10);
        head.right.right.parent = head.right;

        //测试是否是平衡二叉树
        System.out.println("是否为平衡二叉树: " + BlancedTree.isBlancedTree(head));
        //测试树的深度
        System.out.println("二叉树的深度为:" + TreeMethod  .getMaxDepth(head));
        //测试树中叶子节点的个数
        System.out.println("二叉树叶子节点的个数: " + TreeMethod.numsOfNoChildNode(head));
    }
}
