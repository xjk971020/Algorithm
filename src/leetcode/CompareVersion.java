package leetcode;

import java.util.Arrays;

/**
 * @Author:cathetine
 * @Date:19-8-27 下午3:32
 * https://leetcode-cn.com/problems/compare-version-numbers/
 * 示例 1:
 * <p>
 * 输入: version1 = "0.1", version2 = "1.1"
 * 输出: -1
 * 示例 2:
 * <p>
 * 输入: version1 = "1.0.1", version2 = "1"
 * 输出: 1
 * 示例 3:
 * <p>
 * 输入: version1 = "7.5.2.4", version2 = "7.5.3"
 * 输出: -1
 * 示例 4：
 * <p>
 * 输入：version1 = "1.01", version2 = "1.001"
 * 输出：0
 * 解释：忽略前导零，“01” 和 “001” 表示相同的数字 “1”。
 * 示例 5：
 * <p>
 * 输入：version1 = "1.0", version2 = "1.0.0"
 * 输出：0
 * 解释：version1 没有第三级修订号，这意味着它的第三级修订号默认为 “0”。
 */
public class CompareVersion {
    public int compareVersion(String version1, String version2) {
        String[] str1s = version1.split("\\.");
        String[] str2s = version2.split("\\.");
        System.out.println(Arrays.toString(str1s));
        System.out.println(Arrays.toString(str2s));
        return process(str1s,str2s);
    }
    private int process(String[] str1s, String[] str2s) {
        int length = 0;
        boolean oneLonger;
        if (str1s.length > str2s.length) {
            oneLonger = true;
            length = str2s.length;
        } else {
            length = str1s.length;
            oneLonger = false;
        }
        int index = 0;
        for (; index < length; ++index) {
            int a1 = Integer.parseInt(str1s[index]);
            int a2 = Integer.parseInt(str2s[index]);
            if (a1 == a2) {
                continue;
            } else if (a1 > a2) {
                return 1;
            } else {
                return -1;
            }
        }
        if (oneLonger) {
            for (; index < str1s.length; ++index) {
                if (Integer.valueOf(str1s[index]) != 0) {
                    return 1;
                }
            }
        } else {
            for (; index < str2s.length; ++index) {
                if (Integer.valueOf(str2s[index]) != 0) {
                    return -1;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        CompareVersion compareVersion = new CompareVersion();
        System.out.println(compareVersion.compareVersion("0.1", "1.1"));
    }
}
