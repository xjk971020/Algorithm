package niuke.offer;

/**
 * @author xjk
 * @date 2019/5/13 -  12:30
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 **/
public class Power {
    public static final double MAX_VALUE = 1.7976931348623157E308;
    public double Power(double base, int exponent) {
        if (base == 0) {
            return 0;
        }
        double temp = 1;
        if (exponent >= 0) {
            for (int i = 0; i < exponent; ++i) {
                temp *= base;
                if(temp > MAX_VALUE) {
                    throw new RuntimeException("超出double的最大范围");
                }
            }
            return temp;
        } else {
            exponent = -exponent;
            for (int i = 0; i < exponent; ++i) {
                temp *= base;
                if(temp > MAX_VALUE) {
                    throw new RuntimeException("超出double的最大范围");
                }
            }
            temp = 1.0/temp;
            return temp;
        }
    }
}
