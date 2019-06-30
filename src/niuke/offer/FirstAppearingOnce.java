package niuke.offer;

/**
 * @Author:xjk
 * @Date 2019/6/30 11:09
 * 字符流中第一个不重复的字符
 * 题目描述
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 * 输出描述:
 * 如果当前字符流没有存在出现一次的字符，返回#字符。
 */
public class FirstAppearingOnce {

    private int[] charCount;
    private StringBuffer stringBuffer;

    public FirstAppearingOnce() {
        charCount = new int[256];
        stringBuffer = new StringBuffer();
    }

    //Insert one char from stringstream
    public void insert(char ch) {
        stringBuffer.append(ch);
        charCount[ch]++;
    }

    //return the first appearence once char in current stringstream
    public char firstAppearingOnce() {
         char[] chars = stringBuffer.toString().toCharArray();
        for (char c : chars) {
            if (charCount[c] == 1) {
                return c;
            }
        }
        return '#';
    }
}
