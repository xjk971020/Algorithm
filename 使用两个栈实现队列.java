/*
 *用两个栈实现一个队列
 */
public class Solution{
	Stack<Integer> stack1 = new Stack<Integer>();
	Stack<Integer> stack2 = new Stack<Integer>();
 	public void push(int i) {
 		stack1.push(i);
	}
	public int pop() {
		if (stack1.isEmpty() && stack2.isEmpty()) {
			throw new RuntimeException("队列中没有数据");
		}
		if (stack2.isEmpty()) {
			while (stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		}
		return stack2.pop();
	}
}