package niuke.offer;

/**
 * author:xjk
 * 2019/6/13 16:50
 * niuke.offer
 * 矩形覆盖
 * 题目描述
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 */
public class RectCover {
    private int[] arr = new int[1024];

    public RectCover() {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 0;
        }
    }

    public int rectCover(int target) {
        if (target < 0) {
            throw new IllegalArgumentException("target不能小于0");
        }
        if (target <= 2) {
            return target;
        }
        arr[target] = rectCover(target - 1) + rectCover(target - 2);
        return arr[target];
    }

    /**
     * 动态规划
     * @param target
     * @return
     */
    public int rectCover_(int target) {
        if (target <= 2) {
            return target;
        }
        int pre = 1;
        int next = 2;
        int total = 0;
        for (int i = 3; i <= target; ++i) {
            total = pre + next;
            pre = next;
            next = total;
        }
        return total;
    }
}
