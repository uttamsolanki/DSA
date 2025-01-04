package track.linkedlist;

import track.linkedlist.implementation.CLLNode;
import track.linkedlist.implementation.CLinkedList;

/**
 * Problem: Split circular list into two halved lists
 * Link: https://www.geeksforgeeks.org/problems/split-a-circular-linked-list-into-two-halves/1?
 */
public class _10SplitCLL {
    static class Pair<T, U> {
        private final T first;
        private final U second;

        public Pair(T first, U second) {
            this.first = first;
            this.second = second;
        }

        public T getFirst() {
            return first;
        }

        public U getSecond() {
            return second;
        }
    }
    // Approach 1: Using slow and fast point algo
    public static Pair<CLLNode, CLLNode> splitList(CLLNode head) {
        if(head == null || head.next == null)
        {
            return new Pair<>(null,null);
        }

        CLLNode slow =  head;
        CLLNode fast = head;

        while (fast.next != head && fast.next.next != head)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        while (fast!=null && fast.next != head)
        {
            fast = fast.next;
        }
        CLLNode ll2 = slow.next;
        fast.next= ll2;
        slow.next=head;

        return new Pair<>(head,ll2);
    }

    public static void main(String[] args) {
        CLinkedList ll = new CLinkedList();
        ll.insertAtTail(10);
        ll.insertAtTail(4);
        ll.insertAtTail(9);
        ll.insertAtTail(10);
        //ll.insertAtTail(5);
        ll.print(ll.head);
        Pair<CLLNode, CLLNode> result =  splitList(ll.head);
        CLLNode ll1 = result.getFirst();
        CLLNode ll2 = result.getSecond();
        ll.print(ll1);
        ll.print(ll2);
    }
}
