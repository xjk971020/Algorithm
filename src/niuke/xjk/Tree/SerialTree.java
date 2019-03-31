package niuke.xjk.Tree;

import niuke.xjk.util.PrintBinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author xjk
 * @date 2019/3/29 -  10:18
 * 序列化一棵树
 **/
public class SerialTree {

    /**
     * 序列化一颗二叉树
     * @param head
     * @return
     */
    public static String serialTree(Node head) {
        if (head == null) {
            return "#!";
        }
        String res = head.value + "!";
        res += serialTree(head.left);
        res += serialTree(head.right);
        return res;
    }

    /**
     * 反序列化一棵树
     * @param res
     * @return
     */
    public static Node reconSerialTreeByString(String res) {
        Queue<String> queue = new LinkedList<>();
        String[] values = res.split("!");
        for (int i = 0; i < values.length; i++) {
            queue.offer(values[i]);
        }
        return reconByOrder(queue);
    }

    /**
     * 传入放满树信息的队列，并返回头结点
     * @param queue
     * @return
     */
    public static Node reconByOrder(Queue<String> queue){
        String str = queue.poll();
        if ("#".equals(str)) {
            return null;
        }
        Node head = new Node(Integer.valueOf(str));
        head.left = reconByOrder(queue);
        head.right = reconByOrder(queue);
        return head;
    }

    public static void main(String[] args) {
        Node head = new Node(6);
        head.left = new Node(3);
        head.left.left = new Node(1);
        head.left.left.right = new Node(2);
        head.left.right = new Node(4);
        head.left.right.right = new Node(5);
        head.right = new Node(9);
        head.right.left = new Node(8);
        head.right.left.left = new Node(7);
        head.right.right = new Node(10);

        System.out.println(serialTree(head));
        Node node= reconSerialTreeByString(serialTree(head));
        PrintBinaryTree.printTree(node);
    }
}
