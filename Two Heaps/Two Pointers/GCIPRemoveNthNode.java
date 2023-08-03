import java.util.*;

/** 
    n = 3
    23 >> 28 >> 10 >> 5 >> 67 >> 39 >> 70 >> null

    result:
    23 >> 28 >> 10 >> 5 >> 39 >> 70 >> null

=========

n = 5
    23 >> 28 >> 10 >> 5 >> 67 >> 39 >> 70 >> null
                a                       b


 */ 

class ReverseLinkedList {
    /**
     * constraints:
     * number of nodes in list is k
     * n will always be: n <= k
     * 1 <= k
    */
    public static LinkedListNode removeNthLastNode(LinkedListNode head, int n) {
        // initialize two pointers one node apart
        LinkedListNode ptrA = head;
        LinkedListNode ptrB = head;
        if (ptrB != null) {
            ptrB = ptrB.next;
        }

        // if only one node in list (constraint: n <= k)
        if (ptrB == null) return null;

        // find node index to remove
        int k = 0;
        while(ptrA != null) {
            ptrA = ptrA.next;
            k++;
        }
        int removeIdx = k - n;

        // reset ptrA
        ptrA = head;
        // if n is 0
        if (removeIdx == 0) {
            return ptrB;
        }

        // 0-indexed
        int ptrBIdx = 1;
        while(ptrB != null && ptrBIdx < removeIdx) {
            ptrA = ptrB;
            ptrB = ptrB.next;
            ptrBIdx++;
        }

        // perform "remove": ptrB is at n and ptrA is before it
        ptrA.next = ptrB.next;
        //ptrB.next = null;

        
        return head;
    }

/** 
    n = 3
    23 >> 28 >> 10 >> 5 >> 67 >> 39 >> 70 >> null

    result:
    23 >> 28 >> 10 >> 5 >> 39 >> 70 >> null

=========

n = 5
    23 >> 28 >> 10 >> 5 >> 67 >> 39 >> 70 >> null
          a                             b

=========

n = 1
    23 >> null
    a      b

 */ 


    /** OPTIMIZED: using some math and fast and slow pointers to simplify code */
    public static LinkedListNode removeNthLastNode(LinkedListNode head, int n) {
        // initialize two pointers
        LinkedListNode ptrA = head;
        LinkedListNode ptrB = head;

        for(int i = 0; i < n; i++) {
            ptrB = ptrB.next;
        }

        // n is the first node -> remove the first node
        if(ptrB == null) return head.next;

        while(ptrB.next != null) {
            ptrA = ptrA.next;
            ptrB = ptrB.next;
        }

        // skip the node (aka "remove" the node)
        ptrA.next = ptrA.next.next;

        return head;
    }

}
