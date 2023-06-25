import java.util.*;
public class Reorder{
    public static LinkedListNode reorderList(LinkedListNode head) {
    // Write your code here

        // reverse second half of list
        // head pointer and mid pointer traverse list alternating/connecting
        //  each other's next nodes

        // this slows down the slow node traversal so it ends up at the midpoint
        //   when we traverse the list
        LinkedListNode dummy = new LinkedListNode(0);
        dummy.next = head;

        LinkedListNode slow = dummy;
        LinkedListNode fast = head;

        /*
        [1 2 3 4 5 6]
             s
                     f

        [1 2 3 4 5]
             s     
                   f

        */

        // slow will point at the node just before we start reversing from
        // aka the mid point
        while(fast != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
        }

        // reverse the second half
        LinkedListNode prev = null;
        LinkedListNode curr = slow.next;
        LinkedListNode next = null;

        while (curr != null) {
            next = curr.next;

            curr.next = prev;
            prev = curr; 
            curr = next;
        }

    // System.out.println("prev: ");
    // printList(prev);
    // System.out.println("slow: ");
    // printList(slow);


        // prev is head of reversed half
        // slow is tail of untouched left half
        slow.next = prev;

         printList(head);

        // now we went from: [1 2 3 4 5 6] to [1 2 3 6 5 4]

        // time to "fold" the list by alternating links
        LinkedListNode left = head;
        LinkedListNode leftNext = head.next;

        LinkedListNode mid = slow.next;
        LinkedListNode midNext = mid.next;

        /*

        1 > 2 > 3 > 6 > 5 > 4
        l  ln       m  mn

        l.next = m;
        m.next = ln;

        1 > 6 > 2 > 3   5 > 4
        l   m   ln      mn

        l = ln
        ln = ln.next;
        m = mn
        mn = mn.next;

        1 > 6 > 2 > 3   5 > 4
                l  ln   m   mn

        1 > 6 > 2 > 5 > 3 > 4 > ()
                        l   m  ln mn

        */
        //TODO this half is wrong

        while (left != mid && midNext != null) {
            left.next = mid;
            mid.next = leftNext;

            left = leftNext;
            mid = midNext;

            if(leftNext != null) leftNext = leftNext.next;
            if(midNext != null) midNext = midNext.next;
        }



        return head;
    }

    // print linked list from node
    public static void printList(LinkedListNode node) {
      String out = "";
      while (node != null) {
          out += node.data + "-> ";
          node = node.next;
      }
      out += "null";
      System.out.println(out);
  }
}