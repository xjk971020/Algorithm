package niuke.offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/**
 * @author xjk
 * @date 2019/6/27 -  23:09
 * 字符串的排列
 * 题目描述
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 **/
public class Permutation {
    public ArrayList<String> permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        if (str == null || str.length() == 0) {
            return res;
        }
        char[] chars = str.toCharArray();
        findPermutation(res, chars, 0);
        Collections.sort(res);
        return res;
    }

    private void findPermutation(ArrayList<String> res, char[] chars, int index) {
        if (index == chars.length) {
            res.add(new String(chars));
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for (int i = index; i < chars.length; i++) {
            if (!set.contains(chars[i])) {
                set.add(chars[i]);
                swap(chars, i, index);
                findPermutation(res, chars, index++);
                swap(chars, index, i);
            }
        }
        return;
    }

    private void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
