package niuke.xjk.advance;

/**
 * cathetine
 * 19-8-24 下午4:14
 * KMP算法
 * 左程云进阶班第一节
 */
public class KMP {

    /**
     * 判断str1中是否存在str2, 存在的话返回第一个位置的下标, 不存在的话返回-1
     *
     * @param str1
     * @param str2
     * @return
     */
    public int getIndexOf(String str1, String str2) {
        if (str1 == null || str2 == null || str1.length() == 0 || str1.length() < str2.length()) {
            return -1;
        }
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        int i = 0, j = 0;
        int[] next = getNextArray(chars2);
        while (i < chars1.length && j < chars2.length) {
            if (chars1[i] == chars2[j]) {
                i++;
                j++;
            } else if (next[j] == -1) {
                i++;
            } else {
                j = next[j];
            }
        }
        return j == chars2.length ? i - j : -1;
    }

    /**
     * 得到每一个字符的最长前缀和最长后缀的匹配数
     *
     * @param str2
     * @return
     */
    public int[] getNextArray(char[] str2) {
        if (str2 == null) {
            throw new RuntimeException("str2不能为空");
        }
        if (str2.length == 0 || str2.length == 1) {
            return new int[]{-1};
        }
        int[] next = new int[str2.length];
        next[0] = -1;
        next[1] = 0;
        //遍历的下标位
        int i = 2;
        //表示字符的最长前缀和最长后缀的匹配数
        int cn = 0;
        while (i < str2.length) {
            if (str2[i - 1] == str2[cn]) {
                next[i++] = ++cn;
            } else if (cn > 0) {
                cn = next[cn];
            } else if (cn == 0) {
                next[i++] = 0;
            }
        }
        return next;
    }
}
