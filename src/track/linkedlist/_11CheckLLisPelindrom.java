package track.linkedlist;

import track.linkedlist.implementation.LinkedList;
import track.linkedlist.implementation.ListNode;

import java.util.Stack;

/**
 * Problem : Palindrome Linked List
 * Link: https://leetcode.com/problems/palindrome-linked-list/description/
 */
public class _11CheckLLisPelindrom {
    /**
     * Approach 1: Using stack
     * Just push list into stack
     * Then Iterate and pop element with stack element
     * Return true if all are match otherwise false
     */
    public static  boolean isPalindrome(ListNode head) {
        Stack<ListNode> st = new Stack<>();
        ListNode curr = head;

        while (curr != null)
        {
            st.push(curr);
            curr = curr.next;
        }

        curr = head;

        while (!st.isEmpty())
        {
            ListNode node = st.pop();
            if(node.val == curr.val)
            {
                curr = curr.next;
            }
            else{
                break;
            }
        }
        return st.isEmpty();
    }
    //TC: O(n), SC:O(n)

    /**
     * Approach 2: Iterative Approach
     * Reached to middle of list
     * Reverse second half then compare
     */
    public static  boolean isPalindrome2(ListNode head) {

        if(head==null || head.next == null)
        {
            return true;
        }
        ListNode slow = head;
        ListNode fast= head;

        while (fast.next!=null && fast.next.next!=null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse ll from mid
        ListNode prev = null;
        ListNode curr = slow.next;
        while (curr!=null)
        {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr=temp;
        }

        // Compare reverse node and ll from head
        curr =head;
        while (prev!=null && prev.val == curr.val)
        {
            prev = prev.next;
            curr = curr.next;
        }

        return prev==null;
    }
    // TC:O(n), SC:O(1)


    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.insertAtEnd(1);
       // ll.insertAtEnd(2);
      //  ll.insertAtEnd(4);
       // ll.insertAtEnd(2);
        ll.insertAtEnd(1);

        boolean ans = isPalindrome2(ll.head);
        System.out.println(ans);
    }
}
