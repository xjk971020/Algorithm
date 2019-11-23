package leetcode;

/**
 * @Author:xjk
 * @Date 2019/11/23 21:30
 * 125. 验证回文串
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 *
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 *
 * 输入: "race a car"
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-palindrome
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _125_IsPalindromeStr {
    public boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }
        if (s.length() == 0) {
            return true;
        }
        char[] chars = s.toLowerCase().toCharArray();
        int i = 0;
        int j = chars.length - 1;
        while (i < j) {
            while (i < j && !judgeCharIsBetween(chars[i])) {
                i++;
            }
            while (i < j && !judgeCharIsBetween(chars[j])) {
                j--;
            }
            if (chars[i] != chars[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;

    }
    private boolean judgeCharIsBetween(char c) {
        if (c <= '9' && c >= '0') {
            return true;
        }
        if (c >= 'a' && c <= 'z') {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String str =  "A man, a plan, a canal: Panama";
        _125_IsPalindromeStr a = new _125_IsPalindromeStr();
        System.out.println(a.isPalindrome(str));
    }
}
