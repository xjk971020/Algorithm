package niuke.offer;

/**
 * @author xjk
 * @date 2019/5/17 -  23:24
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 **/
public class SumSolution {
    public int Sum_Solution(int n) {
        int temp = n;
        boolean b = (temp > 0) && ((temp += Sum_Solution(n - 1)) > 0);
        return temp;
        // if (n == 1) {
        //     return n;
        // }
        // return n + Sum_Solution(n - 1);
    }
}
