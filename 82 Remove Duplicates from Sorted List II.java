/**
Remove all elements from a linked list of integers that have value val.

Example
Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
Return: 1 --> 2 --> 3 --> 4 --> 5


*/

/**
idea: using a single linked list, created a dummpy node before the head
*/

public class Solution {
	public ListNode removeElements(ListNode head){
		if(head == null) return null;
		ListNode fakeHead = new ListNode(0);
		fakeHead.next = head;

		// two pointer, one pointer pre points to fakeHead node,the other pointer cur points to current node
		ListNode pre = fakeHead;
		ListNode cur = head;
		while (cur !=null){
			while (cur.next != null && cur.val == cur.next.val){ // if the value is same as the next vale, then go to next step.
				cur = cur.next;
			}
			if (pre.next == cur){
				pre = pre.next;
			}else {
				pre.next = cur.next;
			}
			cur = cur.next;
		}
		return fakeHead.next;
	}
}