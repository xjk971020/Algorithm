package niuke.zhenti;

import java.util.Scanner;

/**
 * @Author:cathetine
 * @Date:19-9-21
 * @Time:下午2:52
 *
 * 将一个正整数分解成质因数
 */
public class FenJieZhiYinShu {
    private static int k = 2;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        process(num);
    }
    private static void process(int num) {
        if (num == 1) {
            System.out.println(num);
            return;
        }
        if (num >= 2) {
            if (num%k == 0) {
                System.out.print(k + " ");
                num = num/k;
                process(num);
            } else {
                k++;
                process(num);
            }
        }
    }
}
