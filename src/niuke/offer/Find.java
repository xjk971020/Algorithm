package niuke.offer;

/**
 * @author:xjk 2019/7/11 16:02
 * niuke.offer
 * 二维数组中的查找
 * 题目描述
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class Find {
    /**
     * 思路:
     * 把每一行看成有序递增的数组，
     * 利用二分查找，
     * 通过遍历每一行得到答案，
     * 时间复杂度是nlogn
     * @param target
     * @param array
     * @return
     */
    public boolean find(int target, int[][] array) {
        if (target < 0) {
            throw new RuntimeException("target不能小于0");
        }
        if (array == null) {
            throw new NullPointerException("数组不能为空");
        }
        for (int i = 0; i < array.length; ++i) {
            int start = 0;
            int end = array[i].length - 1;
            while(start <= end) {
                int middle = ((start + end) >> 1);
                if (array[i][middle] < target) {
                    start = middle + 1;
                } else if (array[i][middle] > target) {
                    end = middle - 1;
                } else {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 利用二维数组由上到下，由左到右递增的规律，
     * 那么选取右上角或者左下角的元素a[row][col]与target进行比较，
     * 当target小于元素a[row][col]时，那么target必定在元素a所在行的左边,
     * 即col--；
     * 当target大于元素a[row][col]时，那么target必定在元素a所在列的下边,
     * 即row++；
     * @param target
     * @param array
     * @return
     */
    public boolean find2(int target, int[][] array) {
        if (target < 0) {
            throw new RuntimeException("target不能小于0");
        }
        if (array == null) {
            throw new NullPointerException("数组不能为空");
        }
        int row = 0;
        int col = array.length - 1;
        while (row < array.length && col >= 0) {
            if (array[row][col] > target) {
                col--;
            } else if (array[row][col] < target) {
                row++;
            } else {
                return true;
            }
        }
        return false;
    }
}
