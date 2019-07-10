package niuke.offer;

/**
 * @Author:xjk
 * @Date 2019/7/10 21:17
 * 正则表达式匹配
 * 题目描述
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。
 * 模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。
 * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 */
public class Match {

    public boolean match(char[] str, char[] pattern) {
        if (str == null || pattern == null) {
            return false;
        }
        if (str.length == 0 && pattern.length == 0) {
            return true;
        }
        if (str.length != 0 && pattern.length == 0) {
            return false;
        }
        int strIndex = 0;
        int patternIndex = 0;
        return matchCore(str, strIndex, pattern, patternIndex);
    }

    private boolean matchCore(char[] str, int strIndex, char[] pattern, int patternIndex) {
        if (str.length == strIndex && pattern.length == patternIndex) {
            return true;
        }
        if (str.length != strIndex && pattern.length == patternIndex) {
            return false;
        }
        //str到尾，pattern未到尾(不一定匹配失败，因为a*可以匹配0个字符)
        if (str.length == strIndex && pattern.length != patternIndex) {
            //只有pattern剩下的部分类似a*b*c*的形式，才匹配成功
            if (patternIndex + 1 < patternIndex && pattern[patternIndex+1] == '*') {
                return matchCore(str, strIndex, pattern, patternIndex+2);
            }
            return false;
        }
        if (patternIndex + 1 < pattern.length && pattern[patternIndex+1] == '*') {
            if (pattern[patternIndex] == str[strIndex] || pattern[patternIndex] == '.' && strIndex != str.length) {
                //*匹配0个，跳过
                return matchCore(str, strIndex, pattern, patternIndex+2)
                        //*匹配1个，跳过
                        || matchCore(str, strIndex+1, pattern, patternIndex+2)
                        //*匹配1个，再匹配str中的下一个
                        || matchCore(str, strIndex+1, pattern, patternIndex);
            } else {
                //直接跳过*（*匹配到0个）
                return matchCore(str, strIndex, pattern, patternIndex+2);
            }
        }
        if (pattern[patternIndex] == str[strIndex] || pattern[patternIndex] == '.' && strIndex != str.length) {
            return matchCore(str, strIndex+1, pattern, patternIndex+1);
        }
        return false;
    }
}
