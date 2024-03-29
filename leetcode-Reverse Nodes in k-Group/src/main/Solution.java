package main;

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}

public class Solution {
	public static ListNode reverseKGroup(ListNode head, int k) {
		if(head == null)
			return null;
		if(k == 1)
			return head;
		ListNode newHead = head,oldHead = null, p = null, q = null;
		for(int i = 0 ; i < k-1; i++ ) {
			newHead = newHead.next;
			if(newHead == null)
				return head;
		}
		
		
		p = head;
		q = p.next;
		
		
		
		while(true) {
			for(int i = 0 ; i < k-1; i++) {
				if(i == 0)
					oldHead = p;
				ListNode r = q.next;
				q.next = p;
				p = q;
				q = r;
			}
			
			if(q == null) {
				oldHead.next = q;
				return newHead;
			}
				
			ListNode nextHead = q;
			for(int i = 0 ; i < k-1; i++) {
									
				nextHead = nextHead.next;
				if(nextHead== null) {
					oldHead.next = q;
					return newHead;
				}
			}
			
			oldHead.next = nextHead;
			p = q;
			q = q.next;
		}
		
	}
	
	static ListNode generateLinked(int []nums) {
		ListNode head = null;
		ListNode prev = null, t;
		for(int i = 0; i < nums.length; i++) {
			t = new ListNode(nums[i]);
			if(prev != null){
				prev.next = t;
				prev = t;
			}
			else {
				head = t;
				prev = t;
			}
			
		
		}
		return head;
	}
	
	public static void main(String[] args) {
		int nums[] = {1,2};
		reverseKGroup(generateLinked(nums), 2);
	}
}