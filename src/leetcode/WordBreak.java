package leetcode;

import java.util.Set;

/**
 * @author:xjk 2019/8/23 9:24
 * leetcode
 * 139. 单词拆分
 * 题目描述
 * 给定一个字符串s和一组单词dict，判断s是否可以用空格分割成一个单词序列，使得单词序列中所有的单词都是dict中的单词（序列可以包含一个或多个单词）。
 * 例如:
 * 给定s=“leetcode”；
 * dict=["leet", "code"].
 * 返回true，因为"leetcode"可以被分割成"leet code".
 *
 * Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 * For example, given
 * s ="leetcode",
 * dict =["leet", "code"].
 *
 * Return true because"leetcode"can be segmented as"leet code".
 */
public class WordBreak {
    /**
     * 动态规划
     * @param s
     * @param dict
     * @return
     */
    public boolean wordBreak(String s, Set<String> dict) {
        if (s == null || s.length() == 0) {
            return false;
        }
        boolean[] flag = new boolean[s.length() + 1];
        flag[0] = true;
        for (int i = 1; i <= s.length(); ++i) {
            for (int j = 0; j < i; ++j) {
                if (flag[j] && dict.contains(s.substring(j,i))) {
                    flag[i] = true;
                    break;
                }
            }
        }
        return flag[s.length()];
    }

    /**
     * 记忆化回溯
     * @param s
     * @param dict
     * @return
     */
    public boolean wordBreak_(String s, Set<String> dict) {
        return wordBreakProcess(s, dict, 0, new Boolean[s.length()]);
    }
    private boolean wordBreakProcess(String s, Set<String> dict, int start, Boolean[] flag) {
        if (start == s.length()) {
            return true;
        }
        if (flag[start] != null) {
            return flag[start];
        }
        for (int end = start + 1; end <= s.length(); ++ end) {
            if (dict.contains(s.substring(start, end)) && wordBreakProcess(s, dict, end, flag)) {
                flag[start] = true;
                return flag[start];
            }
        }
        flag[start] = false;
        return flag[start];
    }
}
