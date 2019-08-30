package leetcode;

/**
 * @author: xjk
 * @Date: 2019/8/28
 * @Time: 10:49
 * minimum-window-substring
 * 题目描述
 * 给出两个字符串S和T，要求在O（n）的时间复杂度内在S中找出最短的包含T中所有字符的子串。
 * 例如：
 * S ="ADOBECODEBANC"
 * T ="ABC"
 * 找出的最短子串为"BANC".
 * 注意：
 * 如果S中没有包含T中所有字符的子串，返回空字符串 “”；
 * 满足条件的子串可能有很多，但是题目保证满足条件的最短的子串唯一。
 *
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 * For example,
 * S ="ADOBECODEBANC"
 * T ="ABC"
 *
 * Minimum window is"BANC".
 *
 * Note:
 * If there is no such window in S that covers all characters in T, return the emtpy string"".
 *
 * If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
 */
public class MinimumWindowSubstring {
    public String minWindow(String S, String T) {
        if (S.length() < T.length()) {
            return "";
        }
        return null;
    }
}
