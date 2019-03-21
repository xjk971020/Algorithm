/**
 *斐波那契数列
 *现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 */
public class Solution{
	/**
	 *迭代方式
	 */
	public int Fibonacci(int n) {
		int preNum = 0;
		int num = 1;
		int result = 0;
		if (n <= 0) {
			return 0; 
		}
		if (n == 1) {
			return 1;
		}
		for (int i = 2; i <= n; i++) {
			result = preNum + num;
			preNum = num;
			num = result;
		}
		return result;
	}
}