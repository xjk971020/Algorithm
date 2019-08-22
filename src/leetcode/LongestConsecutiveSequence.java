package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * cathetine
 * 19-8-22 下午9:00
 * longest-consecutive-sequence
 * 题目描述
 * 给定一个无序的整数类型数组，求最长的连续元素序列的长度。
 * 例如：
 * 给出的数组为[100, 4, 200, 1, 3, 2],
 * 最长的连续元素序列为[1, 2, 3, 4]. 返回这个序列的长度：4
 * 你需要给出时间复杂度在O（n）之内的算法
 *
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 *
 * For example,
 * Given[100, 4, 200, 1, 3, 2],
 * The longest consecutive elements sequence is[1, 2, 3, 4]. Return its length:4.
 *
 * Your algorithm should run in O(n) complexity.
 */
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] num) {
        if (num == null || num.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int i : num) {
            set.add(i);
        }
        int max = 0;
        for (int i : num) {
            int sum = 0;
            if (set.remove(i)) {
                sum++;
                int numSmall = i - 1;
                int numMax = i + 1;
                while (set.remove(numSmall)) {
                    sum++;
                    numSmall--;
                }
                while (set.remove(numMax)) {
                    sum++;
                    numMax++;
                }
            }
            max = Math.max(sum, max);
        }
        return max;
    }
}