package com.kerwin.springframework.leetcode;

import org.junit.Test;
import org.springframework.util.Assert;

/**
 * @program: spring
 * @description: leetcode2
 * @author: tianyu
 * @create: 2020-10-08 10:34
 **/
public class LeetcodeTest2 {
	@Test
	public void leetCodeTest() {
		ListNode<Integer> node1 = new ListNode<Integer>(3);
		ListNode<Integer> node11 = new ListNode<>(9);
		node1.setNext(node11);
		ListNode<Integer> node2 = new ListNode<Integer>();
		node2.setVal(9);
		ListNode listNode = addTwoNumbers(node1, node2);
		Assert.notNull(listNode);
	}












	public ListNode addTwoNumbers(ListNode<Integer> l1, ListNode<Integer> l2) {
		ListNode<Integer> head = null, tail = null;
		int carry = 0;
		while (l1 != null || l2 != null) {
			int n1 = l1 != null ? l1.val : 0;
			int n2 = l2 != null ? l2.val : 0;
			int sum = n1 + n2 + carry;
			if (head == null) {
				head = tail = new ListNode(sum % 10);
			} else {
				tail.next = new ListNode(sum % 10);
				tail = tail.next;
			}
			carry = sum / 10;
			if (l1 != null) {
				l1 = l1.next;
			}
			if (l2 != null) {
				l2 = l2.next;
			}
		}
		if (carry > 0) {
			tail.next = new ListNode(carry);
		}
		return head;
	}

	public class ListNode<T> {
		private ListNode next;
		private T val;

		public ListNode() {
		}

		public ListNode(T val) {
			this.val = val;
		}

		public ListNode getNext() {
			return next;
		}

		public void setNext(ListNode next) {
			this.next = next;
		}

		public T getVal() {
			return val;
		}

		public void setVal(T val) {
			this.val = val;
		}
	}
}
