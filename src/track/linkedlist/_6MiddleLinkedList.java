package track.linkedlist;

import track.linkedlist.implementation.LinkedList;
import track.linkedlist.implementation.ListNode;

/**
 * Problem : Middle of the Linked List
 * https://leetcode.com/problems/middle-of-the-linked-list/description/
 */
public class _6MiddleLinkedList {
    /**
     * Approach 1: Brute force
     * Find length of list and return (length/2)th node
     */
    public static ListNode middleNode(ListNode head) {
        // if ll is null
        if(head==null)
        {
            return head;
        }

        int n = 0;
        ListNode curr = head;
        while (curr!=null)
        {
            curr = curr.next;
            n++;
        }
        curr = head;
        n = n/2 + n%2;
        while (n-->1)
        {
            curr = curr.next;
        }
        return curr;
    }
    // TC: O(n), SC: O(1)

    /**
     * Approach 2: Using two pointer approach
     * One pointer would be slow and second would be twice fast
     *  Once fast pointer reach at end then slow point would be pointed to middle node
     */
    public static ListNode approach1(ListNode head) {

        if(head==null) return null;

        ListNode slow =  head;
        ListNode fast = head;

        // For even length ll, there would be 2 middle node
        // If interview want to return second middle from start then stop fast point at last ( fast !-null && fast.next != null)
        // if fist middle then below condition
        while (fast.next !=null && fast.next.next !=null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    // TC: O(n), SC: O(n)

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        for(int i=1;i<=5;i++)
        {
            list.insertAtEnd(i);
        }
        list.print(list.head);

        ListNode ans = middleNode(list.head);
        System.out.println(ans.val);
    }

}
