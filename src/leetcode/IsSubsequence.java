package leetcode;

/**
 * @author: xjk
 * @Date: 2019/8/28
 * @Time: 11:20
 * 392.判断子序列
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 *
 * 你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长（长度 ~= 500,000），而 s 是个短字符串（长度 <=100）。
 *
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 *
 * 示例 1:
 * s = "abc", t = "ahbgdc"
 *
 * 返回 true.
 *
 * 示例 2:
 * s = "axc", t = "ahbgdc"
 *
 * 返回 false.
 *
 * 后续挑战 :
 *
 * 如果有大量输入的 S，称作S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/is-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsSubsequence {
    /**
     * 快慢指针
     * @param t
     * @param s
     * @return
     */
    public boolean isSubsequence_(String t, String s) {
        int t1 = 0;
        int s1 = 0;
        while (t1 < t.length() && s1 < s.length()) {
            if (t.charAt(t1) == s.charAt(s1)) {
                t1++;
                s1++;
            } else {
                s1++;
            }
        }
        if (t1 == t.length()) {
            return true;
        } else {
            return false;
        }
    }
    /**
     * 递归
     * @param t
     * @param s
     * @return
     */
    public boolean isSubsequence(String t, String s) {
        char[] s1 = s.toCharArray();
        char[] t1= t.toCharArray();
        return process(s1, t1, 0, 0);
    }
    private boolean process(char[] s1, char[] t1, int sStep, int tStep) {
        if (tStep == t1.length) {
            return true;
        }
        if (sStep == s1.length) {
            return false;
        }
        if (s1[sStep] == t1[tStep]) {
            return process(s1, t1, sStep + 1, tStep + 1);
        }
        return process(s1, t1, sStep + 1, tStep);
    }
}
