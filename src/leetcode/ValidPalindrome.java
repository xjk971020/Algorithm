package leetcode;

/**
 * cathetine
 * 19-8-22 下午9:33
 * valid-palindrome
 * 题目描述
 * 判断题目给出的字符串是不是回文，仅考虑字符串中的字母字符和数字字符，并且忽略大小写
 * 例如："A man, a plan, a canal: Panama"是回文
 * "race a car"不是回文
 * 注意：
 * 你有没有考虑过字符串可能为空？这是面试时应该提出的一个好问题。
 * 针对这个问题，我们定义空字符串是回文
 *
 *
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * For example,
 * "A man, a plan, a canal: Panama"is a palindrome.
 * "race a car"is not a palindrome.
 *
 * Note:
 * Have you consider that the string might be empty? This is a good question to ask during an interview.
 *
 * For the purpose of this problem, we define empty string as valid palindrome.
 */
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if (s == null || s.equals("")) {
            return true;
        }
        char[] chars = s.toLowerCase().toCharArray();
        for (int i = 0, j = chars.length - 1;i < j; ++i,--j) {
            while (i < j && (chars[i] > 'z' || chars[i] < 'a')) {
                if (chars[i] > '9' || chars[i] < '0') {
                    i++;
                    continue;
                }
                break;
            }
            while (i < j && (chars[j] > 'z' || chars[j] < 'a')) {
                if (chars[j] > '9' || chars[j] < '0') {
                    j--;
                    continue;
                }
                break;
            }
            if (chars[i] != chars[j]) {
                return false;
            }
        }
        return true;
    }
//    public boolean isPalindrome(String s) {
//        if (s == null || s.equals("")) {
//            return true;
//        }
//        char[] chars = s.toLowerCase().toCharArray();
//        return process(chars, 0, chars.length - 1);
//    }
//    private boolean process(char[] chars, int step, int length) {
//        if (step == chars.length/2) {
//            return chars[step] <= 'z' && chars[step] >= 'a' && chars[step] == chars[length - step];
//        }
//        return process(chars, step + 1, length);
//    }
}
