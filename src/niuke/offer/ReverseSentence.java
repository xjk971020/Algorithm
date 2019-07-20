package niuke.offer;

/**
 * @Author:xjk
 * @Date 2019/6/30 14:46
 * 翻转单词顺序列
 * 题目描述
 * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。
 * 同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。
 * 例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，
 * 正确的句子应该是“I am a student.”。
 * Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 */
public class ReverseSentence {
    public String reverseSentence(String str) {
        if (str == null || str.length() == 0 || str.length() == 1) {
            return str;
        }
        char[] chars = str.toCharArray();
        reverse(chars, 0, chars.length - 1);
        int blank = -1;
        int nextBlank;
        int count = 0;
        /**
         * 需考虑两种情况:
         * 第一种: 整个字符串都没有空格的情况
         * 第二种: 最后一个不是字符串的情况
         */
        for (int i = 0; i <= chars.length; ++i) {
            if (chars[i] == ' ' || i == chars.length) {
                count++;
                nextBlank = i;
                reverse(chars, blank + 1, nextBlank - 1);
                blank = nextBlank;
            }
        }
        if (count == 0) {
            return str;
        }
        return new String(chars);
    }

    private void reverse(char[] chars, int i, int j) {
        while (i < j) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            ++i;
            --j;
        }
    }
}
