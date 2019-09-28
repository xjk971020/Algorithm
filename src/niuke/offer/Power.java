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
        if (exponent == 0){
            return 1;
        }
        boolean smallerThanZero = false;
        if (exponent < 0) {
            smallerThanZero = true;
            exponent = -exponent;
        }
        double sum = 1;
        for (int i = 0; i < exponent; ++i) {
            sum = sum * base;
            if (sum > Double.MAX_VALUE) {
                //注意此处需要判断是否超出Double类型的最大值
                throw new RuntimeException("超出double的最大值");
            }
        }
        return smallerThanZero?1.0/sum:sum;
    }
}
