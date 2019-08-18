package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * cathetine
 * 19-8-17 下午4:12
 * max-points-on-a-line
 * 题目描述
 * 对于给定的n个位于同一二维平面上的点，求最多能有多少个点位于同一直线上
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 */
public class MaxPointsOnALine {

    public int run(Point[] points) {
        if (points.length <= 1) {
            return points.length;
        }
        int max = 0;
        Map<Double, Integer> data = new HashMap<>();
        for (int i = 0; i < points.length; ++i) {
            int chongFu = 0;
            int chuiZhi = 0;
            int curMax = 0;
            for (int j = 0; j < points.length; ++j) {
                if (i == j) {
                    continue;
                }
                if (points[i].x == points[j].x && points[i].y == points[j].y) {
                    chongFu++;
                } else if (points[i].y == points[j].y) {
                    if (chuiZhi == 0) {
                        chuiZhi = 2;
                    } else {
                        chuiZhi++;
                    }
                    curMax = Math.max(curMax,chuiZhi);
                } else {
                    double xieLv = (double)(points[i].x - points[j].x)/(points[i].y - points[j].y);
                    if (data.get(xieLv) == null) {
                        data.put(xieLv, 2);
                    } else {
                        int temp = data.get(xieLv) + 1;
                        data.put(xieLv, temp);
                    }
                    curMax = Math.max(curMax, data.get(xieLv));
                }
             }
             max = Math.max(max, curMax + chongFu);
        }
        return max;
    }
}

class Point {
    int x;
    int y;
    Point() { x = 0; y = 0; }
    Point(int a, int b) { x = a; y = b; }
}