package niuke.offer;

import java.util.LinkedList;

/**
 * @author:xjk 2019/7/24 9:58
 * niuke.offer
 * 孩子们的游戏(圆圈中最后剩下的数)
 * 题目描述
 * 每年六一儿童节,牛客都会准备一些小礼物去看望孤儿院的小朋友,今年亦是如此。
 * HF作为牛客的资深元老,自然也准备了一些小游戏。其中,有个游戏是这样的:
 * 首先,让小朋友们围成一个大圈。然后,他随机指定一个数m,让编号为0的小朋友开始报数。
 * 每次喊到m-1的那个小朋友要出列唱首歌,然后可以在礼品箱中任意的挑选礼物,并且不再回到圈中,
 * 从他的下一个小朋友开始,继续0...m-1报数....这样下去....
 * 直到剩下最后一个小朋友,可以不用表演,并且拿到牛客名贵的“名侦探柯南”典藏版(名额有限哦!!^_^)。
 * 请你试着想下,哪个小朋友会得到这份礼品呢？(注：小朋友的编号是从0到n-1)
 */
public class LastRemainingSolution {
    /**
     * 用链表模拟环
     * @param n
     * @param m
     * @return
     */
    public int lastRemainingSolution(int n, int m) {
        if (n < 0 || m < 0) {
            throw new RuntimeException("n或者m不能小于0");
        }
        if (n == 0) {
            return -1;
        }
        if (n == 1 || m == 1) {
            return n;
        }
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int index = -1;
        while (list.size() > 1) {
            index = (index + m)%list.size();
            list.remove(index);
            index--;
        }
        return list.get(0);
    }

    /**
     * 用数组模拟环
     * 时间复杂度高，为O(mn)
     * @param n
     * @param m
     * @return
     */
    public int lastRemainingSolution_(int n, int m) {
        if (n < 0 || m < 0) {
            throw new RuntimeException("n或者m不能小于0");
        }
        if (n == 0) {
            return -1;
        }
        if (n == 1 || m == 1) {
            return n;
        }
        int[] help = new int[n];
        int i = -1, count = n, step = 0;
        while (count > 0) {
            i++;
            if (i >= n) {
                i = 0;
            }
            if (help[i] == -1) {
                continue;
            }
            step++;
            if (step == m) {
                help[i] = -1;
                step = 0;
                count--;
            }
        }
        return i;
    }
}
