package niuke.offer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author xjk
 * @date 2019/4/1 -  16:26
 * 顺时针打印矩阵
 * 题目描述
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 **/
public class PrintMatrix {
    /**
     * 从外到里一圈一圈打印
     * 四个角为边界
     * @param matrix
     * @return
     */
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        int a = 0;
        int b = 0;
        int c = matrix[0].length - 1;
        int d = matrix.length - 1;
        ArrayList<Integer> result = new ArrayList<>();
        while ((a <= d) && (b <= c)) {
            getResult(a++, b++ ,c--, d--, result, matrix);
        }
        return result;
    }

    /**
     * 打印过程
     * @param a
     * @param b
     * @param c
     * @param d
     * @param result
     * @param matrix
     */
    private void getResult(int a, int b, int c, int d, ArrayList<Integer> result, int[][] matrix) {
        if (a == d) {
            for (;b <= c; ++b) {
                result.add(matrix[a][b]);
            }
        } else if (b == c) {
            for (;a <= d; ++a) {
                result.add(matrix[a][b]);
            }
        } else {
            int curHeng = b;
            int curShu = a;
            while (curHeng != c) {
                result.add(matrix[curShu][curHeng++]);
            }
            while (curShu != d) {
                result.add(matrix[curShu++][curHeng]);
            }
            while (curHeng != b) {
                result.add(matrix[curShu][curHeng--]);
            }
            while (curShu != a) {
                result.add(matrix[curShu--][curHeng]);
            }
        }
    }
}
