/**
 * Middle of the Linked List
 * Given a singly linked list, return the middle node of the linked list. If the number of nodes in 
 * the linked list is even, return the second middle node.
 * 
 */ 

import java.util.*;
public class MiddleNode{
    public static LinkedListNode middleNode(LinkedListNode head) {
      LinkedListNode slow = head;
      LinkedListNode fast = head;

      if (fast != null) {
        fast = fast.next;
        if (fast != null) {
          fast = fast.next;
        } else {
          return slow;
        }
      }

      // h[ 3 ] null
      //    s   f   ret slow

      // h[ 3 , 5, 2] null
      //        s     
      //               f   ret slow

      // h[ 3, 5, 2, 1] null
      //       s  
      //                f   ret slow.next
      while(fast != null) {
        slow = slow.next;
        fast = fast.next;
        if(fast != null) {
          fast = fast.next;
        } else {
          return slow;
        }
      }

      return slow.next;
  }
}