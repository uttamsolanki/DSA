package track.linkedlist;

import track.linkedlist.implementation.LinkedList;
import track.linkedlist.implementation.ListNode;

/**
 * Problem: Segregate even and odd nodes in a Linked List
 * Link: https://www.geeksforgeeks.org/problems/segregate-even-and-odd-nodes-in-a-linked-list5035
 */
public class _14OddEvenData {
    /**
     * Approach 1:
     */
    public static ListNode divide(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode even = dummy;
        ListNode curr = dummy;

        while (curr!=null && curr.next!=null)
        {
            ListNode temp = curr.next;

            if(temp.val%2 == 0 )
            {
                if(temp == even.next) {
                    even = even.next;
                    curr = curr.next;
                }
                else
                {
                    curr.next = temp.next;
                    temp.next = even.next;
                    even.next = temp;
                    even = even.next;
                }

            }
            else
            {
                curr = curr.next;
            }

        }
        return dummy.next;
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
//        ll.insertAtEnd(17);
//        ll.insertAtEnd(15);
//        ll.insertAtEnd(8);
//        ll.insertAtEnd(9);
//        ll.insertAtEnd(2);
//        ll.insertAtEnd(4);
//        ll.insertAtEnd(6);
        ll.insertAtEnd(8);
        ll.insertAtEnd(2);
        ll.insertAtEnd(4);
        ll.insertAtEnd(6);
        ll.insertAtEnd(17);
        ll.insertAtEnd(15);
        ll.insertAtEnd(9);
        ll.print(ll.head);
        ListNode ans = divide(ll.head);
        ll.print(ans);
    }
}
