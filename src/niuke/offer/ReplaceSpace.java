package niuke.offer;

/**
 * @author:xjk 2019/7/11 17:31
 * niuke.offer
 * 替换空格
 * 题目描述
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class ReplaceSpace {
    public String replaceSpace(StringBuffer str) {
        if (str == null || str.toString().length() == 0) {
            return "";
        }
        char[] chars = str.toString().toCharArray();
        StringBuffer out = new StringBuffer();
        for (char aChar : chars) {
            if (aChar == ' ') {
                out.append("%20");
            } else {
                out.append(aChar);
            }
        }
        return out.toString();
    }
}
