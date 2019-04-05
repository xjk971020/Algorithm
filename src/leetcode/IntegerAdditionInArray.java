package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author xjk
 * @date 2019/4/5 -  11:55
 * 对于非负整数 X 而言，X 的数组形式是每位数字按从左到右的顺序形成的数组。例如，如果 X = 1231，那么其数组形式为 [1,2,3,1]。
 *
 * 给定非负整数 X 的数组形式 A，返回整数 X+K 的数组形式。
 **/
public class IntegerAdditionInArray {
    public static List<Integer> addToArrayForm(int[] A, int K) {
        int jin = 0;
        int l = ("" + K).length();
        int t;
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < A.length || i < l; i++){
            if ( i < A.length) {
                t = K % 10 + A[A.length - i - 1] + jin;
            } else {
                t = K % 10 + jin;
            }
            list.add(0,t % 10);
            jin = t / 10;
            K = K / 10;
        }
        if (jin > 0 ) {
            list.add(0, jin);
        }
        return list;
    }

    public static void main(String[] args) {
        int[] A = {1,2,0,0};
        int k = 34;
        List<Integer> list = IntegerAdditionInArray.addToArrayForm(A,k);
        System.out.println(list.toString());
    }
}
