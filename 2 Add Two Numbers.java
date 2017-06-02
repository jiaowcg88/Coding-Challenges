/**
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

*/

/**
idea: 
since the digits are stored in reverse order and each of their nodes contain a single digit, it is easy to solve using a single linked list. 
keep the while loop going when at least one of the three conditions is met, l1 != null, or l2!= null, or carry != 0;
if l1 == null, then replace it with 0; if l2 == null, then replace it with 0;
*/

public class Solution {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2){
			ListNode pre = new ListNode(0);
			ListNode head = pre;
			int car = 0;
			while (l1 != null || l2 != null || car != 0){
				ListNode cur = new ListNode(0);
				int sum = ((l1 == null)? 0 : l1.val) + ((l2 == null)? 0: l2.val) + car;
				cur.val = sum%10;
				car = sum/10;
				pre.next = cur;
				pre = cur;

				l1 = (l1 == null)? l1: l1.next;
				l2 = (l2 == null)? l2 : l2.next;
			}

			return head.next;
    }
}
