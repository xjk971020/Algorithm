// 链接：https://www.nowcoder.com/questionTerminal/c4ea1f2263434861aef111aa44a5b064
// 来源：牛客网

// 牛牛有一个由小写字母组成的字符串s,在s中可能有一些字母重复出现。比如在"banana"中,字母'a'和字母'n'分别出现了三次和两次。
// 但是牛牛不喜欢重复。对于同一个字母,他只想保留第一次出现并删除掉后面出现的字母。请帮助牛牛完成对s的操作。 



import java.util.HashSet;
import java.util.Set;
import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner();
		String result = "";
		String input = sc.next();
		Set set = new HashSet();
		for (int i = 0; i < input.length; i ++) {
			if (set.add(input.charAt(i))) {
				result += input.charAt(i);
			}
		}
		System.out.print(result);
	}
}