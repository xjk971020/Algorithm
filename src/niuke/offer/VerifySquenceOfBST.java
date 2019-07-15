package niuke.offer;

/**
 * @author xjk
 * @date 2019/6/20 -  12:59
 * 二叉搜索树的后序遍历序列
 * 题目描述
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。
 * 假设输入的数组的任意两个数字都互不相同
 **/
public class VerifySquenceOfBST {
    /**
     * 利用二叉搜索树的特点
     * 后序遍历最后一个节点为根节点, 然后往前遍历找到左子树和右子树的节点
     * 递归
     * @param sequence
     * @return
     */
    public boolean verifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        if (sequence.length == 1) {
            return true;
        }
        return process(sequence, 0, sequence.length - 1);
    }

    public boolean process(int[] sequence, int start, int root) {
        if (start >= root) {
            return true;
        }
        int i = root;
        while (i > start && sequence[i - 1] > sequence[root]) {
            i--;
        }
        for (int j = start; j < i; ++j) {
            if (sequence[j] > sequence[root]) {
                return false;
            }
        }
        return process(sequence, start, i - 1) && process(sequence, i, root - 1);
    }
}
