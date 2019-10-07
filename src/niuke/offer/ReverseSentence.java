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
        if (str == null || str.length() == 0 || str.trim().equals("") || !str.contains(" ")) {
            return str;
        }
        char[] strs = str.toCharArray();
        swap(strs,0,strs.length-1);
        int blank = 0;
        for (int i = 0; i <= strs.length; ++i) {
            if (i == strs.length || strs[i] == ' ') {
                swap(strs,blank,i - 1);
                blank = i + 1;
            }
        }
        return new String(strs);
    }
    private void swap(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }
}
