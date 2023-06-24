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
        prev = reverseGroup(prev, curr, k); // reverse group and store pointer in prev
        prev.next = next;
        curr = next;
      }
    }

    return head;
  }

  // reverse only k nodes
  public static LinkedListNode reverseGroup(LinkedListNode prev, LinkedListNode curr, int k) {
    LinkedListNode tail = curr;
    LinkedListNode next = curr;

    for(int i = 0; i < k - 1 && curr != null; i++) {
      next = curr.next;

      curr.next = prev;
      prev = curr;
      curr = next;
    }

    return tail;
  }
}