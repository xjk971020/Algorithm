package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author:cathetine
 * @Date:19-8-27
 * @Time:下午10:36
 * combination-sum-ii
 * 题目描述
 * 给出一组候选数C和一个目标数T，找出候选数中起来和等于T的所有组合。
 * C中的每个数字在一个组合中只能使用一次。
 * 注意：
 * 题目中所有的数字（包括目标数T）都是正整数
 * 组合中的数字 (a 1, a 2, … , a k) 要按非递增排序 (ie, a 1 ≤ a 2 ≤ … ≤ a k).
 * 结果中不能包含重复的组合
 * 例如：给定的候选数集是[10,1,2,7,6,1,5]，目标数是8
 * 解集是：
 * [1, 7]
 * [1, 2, 5]
 * [2, 6]
 * [1, 1, 6]
 *
 * Given a collection of candidate numbers ( C ) and a target number ( T ), find all unique combinations in Cwhere the candidate numbers sums to T .
 * Each number in C may only be used once in the combination.
 *
 * Note:
 *
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a 1, a 2, … , a k) must be in non-descending order. (ie, a 1 ≤ a 2 ≤ … ≤ a k).
 * The solution set must not contain duplicate combinations.
 *
 * For example, given candidate set10,1,2,7,6,1,5and target8,
 * A solution set is:
 * [1, 7]
 * [1, 2, 5]
 * [2, 6]
 * [1, 1, 6]
 */
public class CombinationSumII {
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (num.length == 0) {
            return result;
        }
        Arrays.sort(num);
        ArrayList<Integer> list = new ArrayList<>();
        combination(num, target, result, list, 0);
        return result;
    }
    private void combination(int[] num ,int target, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list, int step) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = step; i < num.length; ++i) {
            if (i > step && num[i] == num[i-1]) {
                continue;
            }
            list.add(num[i]);
            combination(num, target - num[i], result, list, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
