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
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        int a = 0;
        int b = 0;
        int c = matrix[0].length - 1;
        int d = matrix.length - 1;
        ArrayList<Integer> list = new ArrayList<Integer>();
        while ((a <= d) && (b <= c)) {
            getList(matrix,a++,b++,c--,d--,list);
        }
        return list;
    }
    private void getList(int[][] matrix,int a,int b,int c,int d,ArrayList<Integer> list) {
        if (a == d) {
            for (int i = b; i <= c; i++) {
                list.add(matrix[a][i]);
            }
        }else if (b == c) {
            for (int i = a; i <= d; i++) {
                list.add(matrix[i][b]);
            }
        } else {
            int curHeng = b;
            int curShu = a;
            while (curHeng != c) {
                list.add(matrix[curShu][curHeng]);
                curHeng++;
            }
            while (curShu != d) {
                list.add(matrix[curShu][curHeng]);
                curShu++;
            }
            while (curHeng != a) {
                list.add(matrix[curShu][curHeng]);
                curHeng--;
            }
            while (curShu != b) {
                list.add(matrix[curShu][curHeng]);
                curShu--;
            }
        }

    }

    public static void main(String[] args) {
        int[][] matrix = {{1}, {2}, {3}, {4}, {5}};
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
        PrintMatrix printMatrix = new PrintMatrix();
        System.out.println(printMatrix.printMatrix(matrix));
    }
}
