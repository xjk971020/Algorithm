package niuke.xjk.dynamicProgramming;

import java.util.Random;

/**
 * @author xjk
 * @date 2019/4/26 -  9:30
 * 最小路问题
 **/
public class MinPath {
    public static int getMin(int[][] matrix) {
        return process(matrix,matrix.length - 1,matrix[0].length - 1);
    }

    public static int process(int[][] matrix,int i,int j) {
        int res = matrix[i][j];
        if (i == 0 && j == 0) {
            return matrix[i][j];
        }
        if (i == 0 && j != 0) {
            return res + matrix[i][j - 1];
        }
        if (j == 0 && i != 0) {
            return res + matrix[i - 1][j];
        }
        return res + Math.min(process(matrix,i - 1,j),process(matrix,i,j - 1));
    }


    public static int[][] generateRandomMatrix(int rowSize,int colSize) {
        int[][] test = new int[rowSize][colSize];
        for (int i = 0; i < rowSize; ++ i) {
            for (int j = 0; j < colSize; ++ j) {
                test[i][j] = new Random().nextInt(20);
            }
        }
        return test;
    }

    public static void main(String[] args) {
        int[][] matrix = {  { 1, 3, 5, 9 },
                             { 8, 1, 3, 4 },
                             { 5, 0, 6, 1 },
                             { 8, 8, 4, 0 } };
        System.out.println(getMin(matrix));
    }
}
