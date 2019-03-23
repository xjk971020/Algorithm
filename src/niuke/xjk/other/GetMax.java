package niuke.xjk.other;

/**
 * @author xjk
 * @date 2019/3/22 -  13:13
 * 使用递归的方式求数组中指定位置的最大值
 **/
public class GetMax {
    public static int getMax(int[] arr,int left,int right) {
        if (left == right) {
            return arr[left];
        }
        int mid = (left + right)/2;
        int maxLeft = getMax(arr,left,mid);
        int maxRight = getMax(arr,mid + 1,right);
        return Math.max(maxLeft,maxRight);
    }

    public static void main(String[] args) {
        int arr[] = {1,4,6,2,3};
        System.out.println(getMax(arr,0,4));
    }
}
