package track.linkedlist;

import track.linkedlist.implementation.LinkedList;
import track.linkedlist.implementation.ListNode;

public class _2ReverseLinkedList {
    //Iterative approach
    public static ListNode approach1(ListNode node) {

        // Base conditon
        if(node==null || node.next == null)
        {
            return node;
        }
        
        ListNode prev = null;
        ListNode curr =  node;

        while (curr != null)
        {
            ListNode temp = curr;
            curr =  curr.next;
            temp.next = prev;
            prev = temp;
        }
        return prev;
    }
    // Recursive approach
    public static ListNode approach2(ListNode node) {

        if(node.next==null)
        {
            return node;
        }

        ListNode next = node.next;
        ListNode prev =  approach2(next);
        next.next = node;
        node.next = null;
        return prev;

    }


    public static void main(String[] args) {

        LinkedList list = new LinkedList();
        for(int i=1;i<=6;i++)
        {
            list.insertAtEnd(i);
        }
      //  list.print(list.head);
        ListNode test =  approach2(list.head);
        list.print(test);
    }
}
