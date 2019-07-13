package niuke.offer;

/**
 * @author xjk
 * @date 2019/5/13 -  12:30
 * 数值的整数次方
 * 题目描述
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 **/
public class Power {
    /**
     * 一刷
     * 从前往后遍历
     * 时间复杂度为log(n)，时间效率不行
     * @param base
     * @param exponent
     * @return
     */
    public double Power(double base, int exponent) {
        if (base == 0) {
            return 0;
        }
        double temp = 1;
        if (exponent >= 0) {
            for (int i = 0; i < exponent; ++i) {
                temp *= base;
                if(temp > Double.MAX_VALUE) {
                    throw new RuntimeException("超出double的最大范围");
                }
            }
            return temp;
        } else {
            exponent = -exponent;
            for (int i = 0; i < exponent; ++i) {
                temp *= base;
                if(temp > Double.MAX_VALUE) {
                    throw new RuntimeException("超出double的最大范围");
                }
            }
            temp = 1.0/temp;
            return temp;
        }
    }
}
