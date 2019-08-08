package niuke.zhenti;

import java.util.Scanner;

/**
 * @Author:xjk
 * @Date 2019/8/4 15:46
 * 网易
 * 被3整除
 * 题目描述
 * 小Q得到一个神奇的数列: 1, 12, 123,...12345678910,1234567891011...。
 * <p>
 * 并且小Q对于能否被3整除这个性质很感兴趣。
 * <p>
 * 小Q现在希望你能帮他计算一下从数列的第l个到第r个(包含端点)有多少个数可以被3整除。
 * <p>
 * 输入描述:
 * 输入包括两个整数l和r(1 <= l <= r <= 1e9), 表示要求解的区间两端。
 * 输出描述:
 * 输出一个整数, 表示区间内能被3整除的数字个数。
 */
public class BeiSanZhengChu {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        int start = scanner.nextInt();
        int end = scanner.nextInt();
        long startNum = 1;
        long sum = 0;
        while (startNum <= start) {
            sum += startNum;
            startNum++;
        }
        if (sum % 3 == 0) {
            count++;
        }
        while (startNum <= end) {
            sum += startNum;
            startNum++;
            if (sum % 3 == 0) {
                count++;
            }
        }
        System.out.println(count);
    }
}