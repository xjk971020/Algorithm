package niuke.xjk.other;

import java.util.Arrays;

/**
 * @author xjk
 * @date 2019/3/27 -  14:27
 * 旋转打印矩阵
 **/
public class PrintEdge {

    public static void solution(int[][] matrix) {
        int a = 0;
        int b = 0;
        int c = matrix.length - 1;
        int d = matrix[0].length - 1;
        while (a <= c && b <= d) {
            printEdge(matrix, a++, b++, c--, d--);
        }
    }

    private static void printEdge(int[][] matrix, int a, int b, int c, int d) {
        //说明只有一行
        if (a == c) {
            for (int i = b; i <= d; i++) {
                System.out.print(matrix[a][i]);
            }
        } else if (b == d) {
            for (int i = a; i <= c; i++) {
                System.out.println(matrix[i][d]);
            }
        } else {
            int curA = a;
            int curB = b;
            while (curB != d) {
                System.out.print(matrix[curA][curB++] + " ");
            }
            System.out.println();
            while (curA != c) {
                System.out.print(matrix[curA++][curB] + " ");
            }
            System.out.println();
            while (curB != b) {
                System.out.print(matrix[curA][curB--] + " ");
            }
            System.out.println();
            while (curA != a) {
                System.out.print(matrix[curA--][curB] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
//        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] matrix = {{1}, {2}, {3}, {4}, {5}};
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
        solution(matrix);
    }
}
