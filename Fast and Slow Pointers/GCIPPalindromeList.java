import java.util.*;
public class PalindromeList{
  public static boolean palindrome(LinkedListNode head) {
        if (head == null) return false;
        // printList(head);

        LinkedListNode slow = head;
        LinkedListNode fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
        }
        

        //reverse half of list and get the middle pointer
        LinkedListNode mid = reverseLinkedList(slow);
        LinkedListNode start = head;
        // printList(mid);
        // printList(start);

        while (mid != null) {
            if (start.data != mid.data) {
                return false;
            }
            start = start.next;
            mid = mid.next;
        }

        return true;
    }

    public static LinkedListNode reverseLinkedList(LinkedListNode node) {
        LinkedListNode prev = null;
        LinkedListNode curr = node;
        LinkedListNode next = node;
        if (node != null) next = next.next;

        while (curr != null) {
            curr.next = prev;
            prev = curr;
            curr = next;
            if (next != null) {
                next = next.next;
            }
        }

        return prev;
    }

    // PRINT FOR TESTING
    public static void printList (LinkedListNode head) {
        if (head == null) {
            System.out.println("HEAD IS NULL");
            return;
        }
        LinkedListNode curr = head;

        while (curr.next != null) {
            System.out.print(" " + curr.data + " ->");
            curr = curr.next; //iterate
        }
        System.out.print(" " + curr.data);
        System.out.println();
    }

    // REVERSE LINKED LIST LOGIC
    // 2 > 3 > 5 > 8 > 9 > 10 > 11 >  null
    //             s
    //                           f (f.next is null so stop here)

    // 2 > 3 > 5 > 8 > 9 > 10 > null
    //             s
    //                           f (f is null so stop here)   SO, when f or f.next is null stop loop


    // revesrs from c to the end of list
    // need prev, curr, next pointers

    /*

        c n   p
    1 2 3 2 1 null
-------------------
        p
    1 2 3 > null
     
     c n
     2 1 > null
     -------------------
        p
    1 2 2 > 3 > null
     
     c   n
     1 > null  
     -------------------
        p
    1 2 2 > 3 > null
     
     c   n
     1 > null     



    2 3 5 8 null
    c 
      n

     p=null
----------------
    c.next = p
    p = c
    c = n
    n = n.next

    3 5 8 null
    c
      n

    2 null 
    p
    ----------------

    5 8 null
      n
    c

    3 2 null
    p
    ----------------
    8 null
        n
    c

    5 3 2 null
    p
    ----------------
    null
    n
    c


    8 5 3 2 null 
    p

    point middle of list to p
    */
}










