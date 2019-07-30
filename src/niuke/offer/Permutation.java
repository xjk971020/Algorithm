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
    /**
     * 对于无重复值的情况
     *
     * 固定第一个字符，递归取得首位后面的各种字符串组合；
     * 再把第一个字符与后面每一个字符交换，并同样递归获得首位后面的字符串组合；
     * 递归的出口，就是只剩一个字符的时候，递归的循环过程，就是从每个子串的第二个字符开始依次与第一个字符交换，然后继续处理子串。
     *
     * 假如有重复值呢？
     * 由于全排列就是从第一个数字起，每个数分别与它后面的数字交换，我们先尝试加个这样的判断——如果一个数与后面的数字相同那么这两个数就不交换了。
     * 例如abb，第一个数与后面两个数交换得bab，bba。然后abb中第二个数和第三个数相同，就不用交换了。
     * 但是对bab，第二个数和第三个数不 同，则需要交换，得到bba。
     * 由于这里的bba和开始第一个数与第三个数交换的结果相同了，因此这个方法不行。
     *
     * 换种思维，对abb，第一个数a与第二个数b交换得到bab，然后考虑第一个数与第三个数交换，此时由于第三个数等于第二个数，
     * 所以第一个数就不再用与第三个数交换了。再考虑bab，它的第二个数与第三个数交换可以解决bba。此时全排列生成完毕！
     **/
    public ArrayList<String> permutation(String str) {
        ArrayList<String> result = new ArrayList<>();
        if (str == null || str.length() == 0) {
            return result;
        }
        char[] chars = str.toCharArray();
        findPermutation(result, chars, 0);
        Collections.sort(result);
        return result;
    }
    private void findPermutation(ArrayList<String> result, char[] chars, int index) {
        if (index == chars.length - 1) {
            result.add(new String(chars));
        } else {
            HashSet<Character> set = new HashSet<>();
            //外层for循环将第一个字母与后面的字母依次交换, 比如 abb 中 a与第一个b交换，但是不与第二个b交换
            for (int i = index; i < chars.length; ++i) {
                if (!set.contains(chars[i])) {
                    set.add(chars[i]);
                    swap(chars, i, index);
                    //index位置后面的排列出来的结果
                    findPermutation(result, chars, index+1);
                    swap(chars, index, i);
                }
            }
        }
    }
    private void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
