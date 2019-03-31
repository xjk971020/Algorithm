package niuke.xjk.Tree;

/**
 * @author xjk
 * @date 2019/3/30 -  10:03
 * 判断一棵树是否是平衡二叉树
 **/
public class BlancedTree {
    /**
     * 定义每次返回的判断数据
     */
    public static class ReturnData {
        private int height;
        private boolean isBalance;
        public ReturnData(int height, boolean isBalance) {
            this.height = height;
            this.isBalance = isBalance;
        }
    }

    public static boolean isBlancedTree(Node node) {
        return isBlance(node).isBalance;
    }

    private static ReturnData isBlance(Node node) {
        if (node == null) {
            return new ReturnData(0,true);
        }
        ReturnData leftData = isBlance(node.left);
        if (!leftData.isBalance) {
            return new ReturnData(0,false);
        }
        ReturnData rightData = isBlance(node.right);
        if (!rightData.isBalance) {
            return new ReturnData(0,false);
        }
        if (Math.abs(leftData.height - rightData.height) > 1) {
            return new ReturnData(0,false);
        }
        return new ReturnData(Math.max(rightData.height,leftData.height) + 1,true);
    }
}
