package book.zuo;

import java.util.*;

/**
 * @Description: 【题目】给定一个不含有重复值的数组arr，找到每一个i位置左边和右边离i位置最近且值比arr[i]小的位置。返回所有位置相应的信息。
 * <p>
 * 进阶问题：给定一个可能含有重复值的数组arr，找到每一个i位置左边和右边离i位置最近且值比arr[i]小的位置。返回所有位置相应的信息。
 * <p>
 * 第一章、栈和队列   -- 单调栈结构
 * @Date: 2021/4/19
 */
public class NearLessNoRepeat {

    /**
     * 普通版解法
     * @param numbers
     * @return
     */
    public int[][] getNearLessNoRepeat(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return null;
        }

        int[][] result = new int[numbers.length][2];
        Stack<Integer> indexStack = new Stack<>();

        for (int i = 0; i < numbers.length; i++) {

            while (!indexStack.isEmpty() && numbers[indexStack.peek()] > numbers[i]) {
                int curIndex = indexStack.pop();
                int leftSmallIndex = indexStack.isEmpty() ? -1 : indexStack.peek();
                int rightSmallIndex = i;

                result[curIndex][0] = leftSmallIndex;
                result[curIndex][1] = rightSmallIndex;

            }

            indexStack.push(i);
        }

        while (!indexStack.isEmpty()) {
            int curIndex = indexStack.pop();
            int leftSmallIndex = indexStack.isEmpty() ? -1 : indexStack.peek();
            int rightSmallIndex = -1;
            result[curIndex][0] = leftSmallIndex;
            result[curIndex][1] = rightSmallIndex;
        }

        return result;
    }

    /**
     * 进阶版解法
     * @param numbers
     * @return
     */
    public int[][] getNearLessRepeat(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return null;
        }

        int[][] result = new int[numbers.length][2];
        //存放相同的数组下标的栈
        Stack<List<Integer>> indexStack = new Stack<>();

        for (int i = 0; i < numbers.length; i++) {
            while (!indexStack.isEmpty() && numbers[indexStack.peek().get(0)] > numbers[i]) {
                List<Integer> currEqIndexList = indexStack.pop();
                int leftSmallIndex = indexStack.isEmpty() ? -1 : indexStack.peek().get(0);
                int rightSmallIndex = i;

                for (Integer currEqIndex : currEqIndexList) {
                    result[currEqIndex][0] = leftSmallIndex;
                    result[currEqIndex][1] = rightSmallIndex;
                }
            }

            if (indexStack.isEmpty() || numbers[indexStack.peek().get(0)] != numbers[i]) {
                List<Integer> newEqIndexList = new ArrayList<>();
                newEqIndexList.add(i);
                indexStack.add(newEqIndexList);
            } else {
                List<Integer> currEqIndexList = indexStack.peek();
                currEqIndexList.add(i);
            }
        }

        while (!indexStack.isEmpty()) {
            List<Integer> currEqIndexList = indexStack.pop();
            int leftSmallIndex = indexStack.isEmpty() ? -1 : indexStack.peek().get(0);
            int rightSmallIndex= -1;
            for (Integer currEqIndex : currEqIndexList) {
                result[currEqIndex][0] = leftSmallIndex;
                result[currEqIndex][1] = rightSmallIndex;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] numbers = {3,4,1,5,6,2,7};
        NearLessNoRepeat algorithm = new NearLessNoRepeat();
        //[[-1, 2], [0, 2], [-1, -1], [2, 5], [3, 5], [2, -1], [5, -1]]
        System.out.println(Arrays.deepToString(algorithm.getNearLessNoRepeat(numbers)));
    }

}
