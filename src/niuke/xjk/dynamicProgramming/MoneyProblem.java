package niuke.xjk.dynamicProgramming;

/**
 * @author xjk
 * @date 2019/4/28 -  9:33
 * 给定一个数组 和一个目标数，求数组中的数加起来能否等于目标数
 **/
public class MoneyProblem {
    public static boolean solution(int[] arr,int aim) {
        return process(arr,0,0,aim);
    }

    /**
     * 暴力求出每一条路径的值
     * @param arr
     * @param i
     * @param sum
     * @param aim
     * @return
     */
    private static boolean process(int[] arr,int i,int sum,int aim) {
        if (sum == aim) {
            return true;
        }
        if (i == arr.length) {
            return false;
        }
        return process(arr,i + 1,sum,aim) || process(arr,i + 1,sum + arr[i],aim);
    }

    public static void main(String[] args) {
        int[] arr = {1,2};
        int aim = 1;
        System.out.println(solution(arr, aim));
    }
}
