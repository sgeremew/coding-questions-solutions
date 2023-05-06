/**
 * Linked List Cycle
 * Check whether or not a linked list contains a cycle. If a cycle exists, return TRUE. Otherwise, 
 * return FALSE. The cycle means that at least one node can be reached again by traversing the next 
 * pointer.
 * 
 * Constraints:
 * Let n be the number of nodes in a linked list.
 * • 0 <= n <= 500
 * • -10^5 <= Node.data <= 10^5
 * 
 */


/*
	class LinkedListNode {
    	public int data;
	    public LinkedListNode next;
	    // Constructor will be used to make a LinkedListNode type object
	    public LinkedListNode(int data) {
	      this.data = data;
	      this.next = null;
	    }
 	}
 */ 

import java.util.*;
public class CycleDetection{
    public static boolean detectCycle(LinkedListNode head) {
	    LinkedListNode slow = head;
	    LinkedListNode fast = head;

	    if(fast != null && fast.next != null) {
	    	fast = fast.next.next;
	    }

	    while(fast != null) {
	    	if(slow == fast) return true;

	    	slow = slow.next;
	    	fast = fast.next;
	    	if(fast != null) fast = fast.next;
	    }

	    return false;
	}
}

