package com.luoExpress.leetcode.list;

public class _206_reverseList {
	
	public ListNode reverseList(ListNode head) {
		if (head == null || head.next == null) return head;
	
		ListNode newHead = reverseList(head.next);
		head.next.next = head;
		head.next = null;
		return newHead;
    }

	
	public ListNode reverseList2(ListNode head) {
		if (head == null || head.next == null) return head;
	
		ListNode newHead = null;
		while (head != null) {
			ListNode tmp = head.next;
			head.next = newHead;//（从等号的左边向右看是箭头的指向方向）
			newHead = head;
			head = tmp;
		}
		
		return newHead;
    }

}
