package leetcode;

/**
 * @Author:cathetine
 * @Date:19-9-22
 * @Time:上午11:41
 * 7. 整数反转
 * <p>
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 123
 * 输出: 321
 *  示例 2:
 * <p>
 * 输入: -123
 * 输出: -321
 * 示例 3:
 * <p>
 * 输入: 120
 * 输出: 21
 * 注意:
 * <p>
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Reverse {
    public int reverse(int x) {
        if (x == 0) {
            return x;
        }
        int isFuShu = 0;
        if (x < 0) {
            isFuShu = 1;
            x = x * (-1);
        }
        int num = 0;
        while (x > 0) {
            //此处需用Integer.MAX_VALUE/10 < num而不能用Integer.MIN_VALUE < num * 10,
            //因为num*10会先溢出从而比Integer.MAX_VALUE小
            if (Integer.MAX_VALUE / 10 < num || (x % 10 > 7 && Integer.MAX_VALUE == num * 10)) {
                return 0;
            }
            num = num * 10 + x % 10;
            x = x / 10;
        }
        if (isFuShu == 0) {
            return num;
        } else {
            return num * (-1);
        }
    }
}
