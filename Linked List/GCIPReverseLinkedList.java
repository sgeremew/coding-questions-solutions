import java.util.*;

public class ReverseLinkedList {

/*

h -> 4 2 7 8 9 0 2 -> null

()   4 > 2 > 7 > 8 > 9 > 0 > 2
p    c   n

() < 4   2 > ...
p    c   n
 
() < 4 < 2   7 ...
     p   c   n

() < 4 < 2   7 > 8 ...
         p   c   n
...

() < 4 < 2 < 7 < 8 < 9 < 0 < 2   ()
                             p   cn

out:
h -> 2 0 9 8 7 2 4 -> null
p
*/
    
    public static LinkedListNode reverse(LinkedListNode head) {
        LinkedListNode prev = null;
        LinkedListNode curr = head;
        LinkedListNode next = head;

        while (curr != null) {
            next = curr.next;

            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}