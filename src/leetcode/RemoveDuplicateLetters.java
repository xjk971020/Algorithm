package leetcode;

import java.util.Arrays;

/**
 * @author: xjk
 * @Date: 2019/8/30
 * @Time: 10:39
 * 316. 去除重复字母
 * <p>
 * 给定一个仅包含小写字母的字符串，去除字符串中重复的字母，使得每个字母只出现一次。需保证返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "bcabc"
 * 输出: "abc"
 * 示例 2:
 * <p>
 * 输入: "cbacdcbc"
 * 输出: "acdb"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicate-letters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RemoveDuplicateLetters {
    /**
     * 每次递归找出字符串中出现次数最少的字典序中最小的字符
     * 然后截取这个字符的下一个位置开始的字符串继续递归找出下一个最少的字符
     * @param s
     * @return
     */
    public String removeDuplicateLetters(String s) {
        //辅助数组，记录字符串中字符出现的次数
        int[] help = new int[26];
        char[] chars = s.toCharArray();
        Arrays.fill(help, 0);
        for (int i = 0; i < chars.length; i++) {
            help[s.charAt(i) - 'a']++;
        }
        //记录数组中最小数的位置
        int pos = 0;
        int i = 0;
        for (; i < s.length(); ++i) {
            if (chars[i] < chars[pos]) {
                pos = i;
            }
            --help[chars[i] - 'a'];
            if (help[chars[i] - 'a'] == 0) {
                break;
            }
        }
        return s.length() == 0 ? "" : s.charAt(pos) + removeDuplicateLetters(s.substring(pos + 1).replaceAll("" + s.charAt(pos), ""));
    }
}
