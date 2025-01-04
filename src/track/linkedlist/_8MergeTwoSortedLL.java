package track.linkedlist;

import track.linkedlist.implementation.LinkedList;
import track.linkedlist.implementation.ListNode;

public class _8MergeTwoSortedLL {
    /**
     * Approach 1: Using recursion
     * Invoke recursion one by one and compare node value of both lists
     */
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result = null;
        if(list1==null && list2==null)
        {
            return  result;
        }

        if(list1==null)
        {
            return list2;
        }

        if (list2==null)
        {
            return list1;
        }

        if(list1.val<list2.val)
        {
            result = new ListNode(list1.val);
            result.next = mergeTwoLists(list1.next,list2);
            return result;
        }
        result = new ListNode(list2.val);
        result.next = mergeTwoLists(list1,list2.next);
        return result;
    }
    // TC: O(n+m), SC: O(n+m)

    /**
     * Approach 2: Using pointers
     */
    public static ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(-1);
        ListNode curr = head;

        while (list1!=null && list2!=null)
        {
            if(list1.val<list2.val)
            {
                curr.next = list1;
                list1 = list1.next;
                curr = curr.next;
                curr.next =null;
            }
            else
            {
                curr.next = list2;
                list2 = list2.next;
                curr = curr.next;
                curr.next =null;
            }
        }

        curr.next = list1==null? list2:list1;

        return head.next;
    }
    // TC: O(n+m), SC: O(1)


    public static void main(String[] args) {
        LinkedList ll1 = new LinkedList();
        ll1.insertAtEnd(1);
        ll1.insertAtEnd(3);
        ll1.insertAtEnd(5);
        ll1.insertAtEnd(7);
        ll1.print(ll1.head);

        LinkedList ll2 = new LinkedList();
        ll2.insertAtEnd(2);
        ll2.insertAtEnd(4);
        ll2.insertAtEnd(5);
        ll2.insertAtEnd(6);
        ll2.print(ll2.head);

        ListNode ll3 = mergeTwoLists2(ll1.head,ll2.head);
        ll1.print(ll3);
    }

}
