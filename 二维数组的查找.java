// 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到
// 右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一
// 个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
public class Solution {
    public boolean Find(int target, int [][] array) {
        int i,j;
        for (i = 0; i < array.length; i++) {
            for (j = 0; j < array[i].length; j++) {
                if (array[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    } 
    /**
     *二维数组从左到右从上到下递增
     *遍历每一行，再利用二分查找
     */
    public boolean Find(int target, int [][] array) {
        int mid;
        for (int i = 0; i < array.length; i ++) {
            int start = 0;
            int end = array[i].length - 1;
            while (start <= end) {
                mid = (start + end)/2;
                if (target > array[i][mid]) {
                    start = mid + 1;
                }else if (target < array[i][mid]) {
                    end = mid -1;
                } else {
                    return true;
                }

            }
        }
        return false;
    }
}
