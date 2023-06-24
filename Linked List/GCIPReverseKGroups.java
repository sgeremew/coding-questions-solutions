import java.util.*;
public class ReverseKGroups{
/*

()   1 > 2 > 3 > 4 > 5 > ()
p    c   n
reverseGroup(null, [1], 3)

4 < 1 < 2 < 3  4 > 5 > ()
3 > 2 > 1 > 4 > 5 > ()


()   1 > 2 > 3 > 4 > 5 > ()
p    c   n
k = 3
i = 0

() < 1   2 > 3 > 4 > 5 > ()
     p   cn
i = 0

() < 1 < 2   3 > 4 > 5 > ()
         p   cn
i = 1

() < 1 < 2 < 3   4 > 5 > ()
     t       p   c   n
i = 2

//////////////

()   1 > 2 > 3 > 4 > 5 > ()
p    c           n
             h
i=3
first=false
        reverse:: () < 1 < 2 < 3   4 > 5 > ()
                       t       p   cn
                  i=3



*/

  public static LinkedListNode reverseKGroups(LinkedListNode head, int k) {
    LinkedListNode prev = null;
    LinkedListNode curr = head;
    LinkedListNode next = head;

    boolean firstGroup = true;
    int i = 1;
    while (next.next != null) {
      next = next.next;
      i++;
      
      if (i == k) {
        if (firstGroup) {
          head = next;
          firstGroup = false;
        }
        next = next.next;
        LinkedListNode[] prevAndCurr = reverseGroup(prev, curr, k); // reverse group
        prev = prevAndCurr[0];
        prev.next = next;
        curr = next;
        i = 1;
      }
    }

    return head;
  }

  // reverse only k nodes
  public static LinkedListNode reverseGroup(LinkedListNode prev, LinkedListNode curr, int k) {
    LinkedListNode tail = curr;
    LinkedListNode next = curr;

    for(int i = 0; i < k && curr != null; i++) {
      next = curr.next;

      curr.next = prev;
      prev = curr;
      curr = next;
    }

    return new LinkedListNode[]{tail, prev};
  }



//GCIP SOLUTION
  public static LinkedListNode reverseKGroups(LinkedListNode head, int k) {
    // create dummy node that where dumm.next is head
    LinkedListNode dummy = new LinkedListNode(0);
    dummy.next = head;
    LinkedListNode ptr = dummy; // ptr to traverse list

    while (ptr != null) {

        LinkedListNode tracker = ptr;

        // traverse 1 group
        for (int i = 0; i < k; i++) {
            if (tracker == null) {
                break; // we reached end of list
            }
            tracker = tracker.next;
        }

        if (tracker == null) {
            break; // we reached end of list
        }

        // ptr is the node just before the group we want to reverse
        // ptr.next is the first node in the group we want to reverse
        LinkedListNode[] updatedNodes = LinkedListReversal.reverseLinkedList(ptr.next, k);
        LinkedListNode previous = updatedNodes[0]; // the head of the reversed group
        LinkedListNode current = updatedNodes[1]; // the head of the right hand fragmented list

        // ptr is the node just before the group we reversed
        // ptr.next is the last node in the group we reversed
        LinkedListNode lastNodeOfReversedGroup = ptr.next;
        // link the last node of reversed group to the head of the right hand fragmented list
        lastNodeOfReversedGroup.next = current;
        ptr.next = previous; // ptr node points to head of reversed group
        // update ptr to be the node just before our next (potential) group
        ptr = lastNodeOfReversedGroup;

    }

    // dummy is just before the head
    // dummy.next is the head
    return dummy.next;
  }

  // reverse k nodes starting from given node
  public static LinkedListNode[] reverseLinkedList(LinkedListNode node, int k){
    
    LinkedListNode previous = null;  
    LinkedListNode current = node;  
    LinkedListNode next = null;  

    for (int i = 0; i < k; i++) {
      next = current.next;  
      current.next = previous;  
      previous = current;  
      current = next;
    }

    // return [head of reversed list, head of fragmented list]
    return new LinkedListNode[]{previous, current}; 
  }


}