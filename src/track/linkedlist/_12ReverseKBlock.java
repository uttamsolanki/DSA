package track.linkedlist;

import track.linkedlist.implementation.LinkedList;
import track.linkedlist.implementation.ListNode;

import java.util.Stack;

/**
 * Problem: Reverse Nodes in k-Group
 * Link: https://leetcode.com/problems/reverse-nodes-in-k-group/description/
 */
public class _12ReverseKBlock {
    /**
     * Approach-1 : Using stack
     */
    public static ListNode reverseKGroup(ListNode head, int k) {

        if(k<=1)
        {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode curr = dummy;

        while (curr.next!=null)
        {
            ListNode prev = curr;

            int cont = 0;
            Stack<ListNode> st = new Stack<>();
            while (curr!=null && cont<k )
            {
                curr = curr.next;
                if(curr!=null) {
                    st.push(curr);
                    cont++;
                }
            }

            if(curr==null && cont!=k)
            {
                break;
            }

            ListNode next = curr==null? null: curr.next;
            while (!st.isEmpty())
            {
                prev.next = st.pop();
                prev = prev.next;
            }
            prev.next =next;
            curr = prev;
        }

        return dummy.next;
    }
    //TC: O(n), SC:(n)

    /**
     * Approach-2: Using iterative approach
     */
    public static ListNode reverseKGroup2(ListNode head, int k) {
        if(k<=1)
        {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode curr = dummy.next;
        ListNode prev = dummy;
        while (curr != null)
        {

            int cnt = 0;
            while (curr!=null && cnt< k)
            {
                curr = curr.next;
                cnt++;
            }

            if(curr==null && cnt!=k)
            {
                break;
            }

            // for reverse
            ListNode pr= null;
            ListNode cr = prev.next;

            while (cr != curr)
            {
                ListNode temp = cr.next;
                cr.next = pr;
                pr = cr;
                cr=temp;
            }
            // Pointer exchange
            ListNode temp = prev.next;
            prev.next.next = curr;
            prev.next = pr;
            prev = temp;

        }
        return dummy.next;
    }
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        for(int i=1;i<=5;i++)
        {
            ll.insertAtEnd(i);
        }
        ll.print(ll.head);
        ListNode ans = reverseKGroup2(ll.head,6);
        ll.print(ans);

        ListNode n1 =  new ListNode(1);
        ListNode n2 =  new ListNode(1);
        System.out.println(n1==n2);
       // System.out.println(ans);
    }
}
