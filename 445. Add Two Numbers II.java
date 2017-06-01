/**
You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Follow up:
What if you cannot modify the input lists? In other words, reversing the lists is not allowed.

*/

/**
using stack to solve the problem
first we store all digits to two stacks respectively. Then we implmented them.

*/

public class Solution {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2){
		Stack<Integer> stack1 = new Stack<>();
		Stack<Integer> stack2 = new Stack<>();
		while (l1 != null){
			stack1.push(l1.val);
			l1 = l1.next;
		}
		while (l2 != null){
			stack2.push(l2.val);
			l2 = l2.next;
		}
		int car = 0;
		ListNode list = new ListNode(0);
		while (!stack1.empty() || !stack2.empty()){
			if (!stack1.empty()) car += stack1.pop();
			if(!stack2.empty()) car += stack2.pop();
			list.val = car%10;
			ListNode head = new ListNode(car/10);
			head.next = list;
			list = head;
			car /= 10;
		}

		return list.val == 0? list.next: list;
	}
}