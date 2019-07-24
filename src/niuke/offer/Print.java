package niuke.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author:xjk
 * @Date 2019/7/24 21:25
 * 把二叉树打印成多行
 * 题目描述
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 */
public class Print {
    public ArrayList<ArrayList<Integer>> print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (pRoot == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode temp;
        queue.add(pRoot);
        while (!queue.isEmpty()) {
            ArrayList<Integer> level = new ArrayList<>();
            //这里要注意把size分离成一个变量, 不能直接在for循环中使用queue.size()
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                temp = queue.poll();
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
                level.add(temp.val);
            }
            result.add(level);
        }
        return result;
    }
}
