package niuke.offer;

/**
 * author:xjk
 * 2019/7/2 10:11
 * niuke.offer
 * 复杂链表的复制
 * 题目描述
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */
public class Clone{
    public RandomListNode clone(RandomListNode pHead) {
        cloneNode(pHead);
        cloneNode(pHead);
        return reConnectNodes(pHead);
    }
    /**
     * 复制链表，使每个N节点的下一个为N`节点
     */
    private void cloneNode(RandomListNode pHead) {
        RandomListNode node = pHead;
        while (node != null) {
            RandomListNode pCloned = new RandomListNode(node.label);
            pCloned.next = node.next;
            pCloned.random = null;
            node.next = pCloned;
            node = pCloned.next;
        }
    }
    /**
     * 复制N`节点连接S`节点
     */
    private void connectCloneNode(RandomListNode pHead) {
        RandomListNode node = pHead;
        while (node != null) {
            RandomListNode pClone = node.next;
            if (node.random != null) {
                pClone.random = node.random;
            }
            node = pClone.next;
        }
    }
    /**
     * 拆分两个链表
     */
    private RandomListNode reConnectNodes(RandomListNode pHead) {
        RandomListNode pClonedHead = null;
        RandomListNode pClonedNode = null;
        RandomListNode node = pHead;
        if (node != null) {
            pClonedHead = node.next;
            pClonedNode = node.next;
            node.next = pClonedHead.next;
            node = node.next;
        }

        while (node != null) {
            pClonedNode.next = node.next;
            pClonedNode = pClonedNode.next;
            node.next = pClonedNode.next;
            node = node.next;
        }
        return pClonedHead;
    }
}

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
