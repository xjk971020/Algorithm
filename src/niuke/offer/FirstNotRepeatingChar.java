package niuke.offer;

import java.util.LinkedHashMap;

/**
 * @author:xjk 2019/7/19 19:45
 * niuke.offer
 * 第一个只出现一次的字符
 * 题目描述
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
 */
public class FirstNotRepeatingChar {

    /**
     * 省空间，因为无序, 所以无法确定是不是第一个只出现一次的字符
     * @param str
     * @return
     */
    public int firstNotRepeatingChar(String str) {
        if (str == null) {
            return -1;
        }
        int[] help = new int[58];
        char[] chars = str.toCharArray();
        for (char c : chars) {
            help[(int)c - 65]++;
        }
        for (int i = 0; i < help.length; ++i) {
            if (help[i] == 1) {
                return chars[i];
            }
        }
        return -1;
    }

    /**
     * 占用空间较大
     * @param str
     * @return
     */
    public int firstNotRepeatingChar_(String str) {
        if (str == null) {
            return -1;
        }
        LinkedHashMap<Character,Integer> data = new LinkedHashMap<>();
        for (int i = 0; i < str.length(); ++i) {
            if (data.containsKey(str.charAt(i))) {
                int value = data.get(str.charAt(i));
                data.put(str.charAt(i), ++value);
            } else {
                data.put(str.charAt(i),1);
            }
        }
        for (int i = 0; i < str.length(); ++i) {
            int value = data.get(str.charAt(i));
            if (value == 1) {
                return i;
            }
        }
        return -1;
    }
}
