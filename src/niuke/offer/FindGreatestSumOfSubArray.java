package niuke.offer;

public class FindGreatestSumOfSubArray {
    public int findGreatestSumOfSubArray(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int num = 0;
        int maxNum = 0x80000000;
        for (int i = 0; i < array.length; ++i) {
            if (num <= 0) {
                num = array[i];
            } else {
                num += array[i];
            }
            if (num > maxNum) {
                maxNum = num;
            }
        }
        return maxNum;
    }
}
