package niuke.offer;

import java.util.ArrayList;

/**
 * author:xjk
 * 2019/6/19 09:42
 * niuke.offer
 * 二叉树中和为某一值的路径
 * 题目描述:
 * 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)
 */
public class FindPath {
  private ArrayList<ArrayList<Integer>> result = new ArrayList<>();
  private ArrayList<Integer> path = new ArrayList<>();
  public ArrayList<ArrayList<Integer>> findPath(TreeNode root, int target) {
     if (root == null) {
         return result;
     }
     path.add(root.val);
     target -= root.val;
     if (target == 0 && root.left == null && root.right == null) {
         result.add(new ArrayList<>(path));
     }
     FindPath(root.left, target);
     FindPath(root.right, target);
     path.remove(path.size() - 1);
     return result;
  }
}
