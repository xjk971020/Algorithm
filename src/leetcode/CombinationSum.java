package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author:cathetine
 * @Date:19-8-27 下午9:45
 * combination-sum
 * 题目描述
 * 给出一组候选数C和一个目标数T，找出候选数中加起来和等于T的所有组合。
 * C中的数字在组合中可以被无限次使用
 * 注意：
 * 题目中所有的数字（包括目标数T）都是正整数
 * 你给出的组合中的数字 (a 1, a 2, … , a k) 要按非递增排序 (ie, a 1 ≤ a 2 ≤ … ≤ a k).
 * 结解集中不能包含重复的组合
 * 例如：给定的候选数集是[2,3,6,7]，目标数是7
 * 解集是：
 * [7]
 * [2, 2, 3]
 *
 * Given a set of candidate numbers ( C ) and a target number ( T ), find all unique combinations in C where the candidate numbers sums to T .
 *
 * The same repeated number may be chosen from C unlimited number of times.
 *
 * Note:
 *
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a 1, a 2, … , a k) must be in non-descending order. (ie, a 1 ≤ a 2 ≤ … ≤ a k).
 * The solution set must not contain duplicate combinations.
 *
 * For example, given candidate set2,3,6,7and target7,
 * A solution set is:
 * [7]
 * [2, 2, 3]
 */
public class CombinationSum {
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (candidates.length == 0) {
            return result;
        }
        Arrays.sort(candidates);
        ArrayList<Integer> list = new ArrayList<>();
        combination(result, list, candidates, target, 0);
        return result;
    }
    private void combination(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list, int[] candidates, int target, int step) {
        if (target == 0) {
            result.add(new ArrayList<>(list));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = step; i < candidates.length; ++i) {
            list.add(candidates[i]);
            combination(result, list, candidates, target - candidates[i], i);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] candidates = {7,2,3,6};
        int target = 7;
        CombinationSum combinationSum = new CombinationSum();
        combinationSum.combinationSum(candidates, target).forEach(item -> {
            for (Integer i: item) {
                System.out.print(i + " ");
            }
            System.out.println();
        });

    }
}
