package track.linkedlist;

import track.linkedlist.implementation.LinkedList;
import track.linkedlist.implementation.ListNode;

import java.util.Stack;

/**
 * Problem: Check if Linked List is Even Length
 * Link: https://www.geeksforgeeks.org/check-whether-the-length-of-given-linked-list-is-even-or-odd/
 */
public class _7EvenOddLength {
    //Approach 1: We can find length and determine even or odd length of list
    public static boolean isEven(ListNode head) {

        int n =0;
        ListNode curr = head;

        while (curr!=null)
        {
            n++;
            curr = curr.next;
        }

        return n%2==0;
    }
    // TC: O(n), SC:(1)

    /**
     * Approach 2: We can use stack and push/pop one by one
     * At the end, we will check that if stack is empty or not
     */
    public static boolean isEven2(ListNode head) {
        Stack<ListNode> st = new Stack<>();

        ListNode curr = head;
        while (curr!=null)
        {
            if(st.isEmpty())
            {
                st.push(curr);
            }else
            {
                st.pop();
            }
            curr = curr.next;
        }
        return st.isEmpty();
    }
    // TC: O(n), SC:(1)

    /**
     * Approach 3: Using fast pointer technique only
     * if fast pointer is pointing to null then even length otherwise odd length
     */
    public static boolean isEven3(ListNode head) {
        ListNode fast = head;

        while (fast !=null && fast.next!=null)
        {
            fast = fast.next.next;
        }

        return fast==null;
    }
    // TC: O(n/2)=O(n), SC: O(n)


    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        for(int i=1;i<=6;i++)
        {
            list.insertAtEnd(i);
        }
        list.print(list.head);

        boolean ans = isEven3(list.head);
        System.out.println(ans);
    }
}
