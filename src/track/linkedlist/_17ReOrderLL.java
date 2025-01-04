package track.linkedlist;

import track.linkedlist.implementation.LinkedList;
import track.linkedlist.implementation.ListNode;

/**
 * Problem: Reorder List
 * Link-1: https://leetcode.com/problems/reorder-list/
 * Link-2: https://www.geeksforgeeks.org/rearrange-a-given-linked-list-in-place/
 */
public class _17ReOrderLL {
    /**
     * Approach-1: Two pointer + reverse
     * We can use slow and fast point to get middle of link
     */
    public static void reorderList(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next !=null && fast.next.next!=null)
        {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode prev = null;
        ListNode curr = slow.next;
        slow.next = null;
        while (curr!=null)
        {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        curr = head;
        while (prev!=null)
        {
           ListNode temp = prev.next;
            prev.next = curr.next;
            curr.next = prev;
            prev = temp;
            curr = curr.next.next;
        }
    }
    // TC: O(n),SC:0(1)

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();

        for(int i=1;i<=6;i++)
        {
            ll.insertAtEnd(i);
        }

        reorderList(ll.head);
        ll.print(ll.head);
    }
}
