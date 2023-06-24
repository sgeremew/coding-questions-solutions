import java.util.*;
public class ReverseLinkedList{

    // my solution
    public static LinkedListNode reverseBetween(LinkedListNode head, int left, int right) {
        if (head == null) return null;

        LinkedListNode dummy = null;
        if (head != null) {
            dummy = new LinkedListNode(0);
            dummy.next = head;
        }

        LinkedListNode ptr = dummy;
        // skip to node we want to start at
        // ptr will be just before the node we want to start reversing at
        for(int i = 1; i < left; i++) {
            if (ptr == null) break;
            ptr = ptr.next;
        }

        LinkedListNode[] updatedNodes = reverse(ptr.next, (right - left) + 1);
        LinkedListNode headOfReversedList = updatedNodes[0];
        LinkedListNode headOfFragmentedList = updatedNodes[1];

        LinkedListNode tailOfReversedList = ptr.next;
        tailOfReversedList.next = headOfFragmentedList;
        ptr.next = headOfReversedList;

        return dummy.next;
    }

    public static LinkedListNode[] reverse(LinkedListNode curr, int count) {

        LinkedListNode prev = null;
        LinkedListNode next = null;

        for(int i = 0; i < count; i++) {
            next = curr.next;

            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // [headOfReversedList, headOfFragmentedRightSide]
        return new LinkedListNode[]{prev, curr};
    }
}