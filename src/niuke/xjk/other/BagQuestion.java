package niuke.xjk.other;

/**
 * @Author:cathetine
 * @Date:19-11-11
 * @Time:上午10:47
 * 01 背包问题
 * <p>
 * 最多可以放8公斤的物品
 * 物品1:6公斤   价值48元
 * 物品2:1公斤   价值7元
 * 物品3:5公斤   价值40元
 * 物品4:2公斤   价值12元
 * 物品5:1公斤   价值8元
 * <p>
 *       0  1  2  3  4  5   6    7    8
 *       0  0  0  0  0  0   0    0    0
 * 6 48  0  0  0  0  0  0   48  48   48
 * 1 7   0  7  7  7  7  7   48  55   55
 * 5 40  0  7  7  7  7  40  48  55   55
 * 2 12  0  7  12 19 19 40  48  55   60
 * 1 8   0  8  15 20 27 40  48  56   63
 */
public class BagQuestion {
    /**
     * https://www.cnblogs.com/zzlback/p/8596677.html
     * @param w      　     表示物品的重量数组
     * @param v      　     表示物品的价格数组
     * @param weight 　     表示背包能承受的最大重量
     * @return　            表示能获取的最大价值
     */
    public int getBigValue(int[] w, int[] v, int weight) {
        if (w == null || v == null || w.length == 0 || v.length == 0 || weight <= 0) {
            return 0;
        }
        int[][] temp = new int[w.length][weight + 1];
        for (int i = 1; i < w.length; ++i) {
            for (int j = 1; j <= weight; ++j) {
                if (w[i] <= j) {
                    temp[i][j] = Math.max(temp[i - 1][j], temp[i - 1][j - w[i]] + v[i]);
                } else {
                    temp[i][j] = temp[i - 1][j];
                }
            }
        }
        return temp[w.length - 1][weight];
    }
}
