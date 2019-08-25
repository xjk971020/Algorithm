package leetcode;

import java.util.Arrays;

/**
 * cathetine
 * 19-8-25 上午11:26
 * implement-strstr
 * 题目描述
 * 实现函数 strStr。
 * 函数声明如下：
 * char *strStr(char *haystack, char *needle)
 * 返回一个指针，指向needle第一次在haystack中出现的位置，如果needle不是haystack的子串，则返回null。
 *
 * Implement strStr().
 * Returns a pointer to the first occurrence of needle in haystack, or null if needle is not part of haystack.
 */
public class ImplementStrstr {
    //KMP算法求解
    public String strStr(String haystack, String needle) {
        if (haystack == null || needle == null || haystack.length() == 0 || haystack.length() < needle.length()) {
            return null;
        }
        char[] chars1 = haystack.toCharArray();
        char[] chars2 = needle.toCharArray();
        int[] next = getNextArray(chars2);
        int i = 0, j = 0;
        while (i < chars1.length && j  < chars2.length) {
            if (chars1[i] == chars2[j]) {
                i++;
                j++;
            } else if (next[j] == -1) {
                i++;
            } else {
                j = next[j];
            }
        }
        if (j == chars2.length) {
            return haystack.substring(i - j);
        } else {
            return null;
        }
    }
    private int[] getNextArray(char[] str2) {
        if (str2 == null) {
            return null;
        }
        if (str2.length == 1) {
            return new int[]{-1};
        }
        int[] next = new int[str2.length];
        next[0] = -1;
        next[1] = 0;
        int i = 2;
        int cn = 0;
        while (i < str2.length) {
            if (str2[i - 1] == str2[cn]) {
                next[i++] = ++cn;
            } else if (cn > 0) {
                cn = next[cn];
            } else {
                next[i++] = cn;
            }
        }
        System.out.println(Arrays.toString(next));
        return next;
    }
}
