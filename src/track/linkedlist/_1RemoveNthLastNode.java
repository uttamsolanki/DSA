package track.linkedlist;

import track.linkedlist.implementation.LinkedList;
import track.linkedlist.implementation.ListNode;

import java.util.HashMap;

// Problem: Remove nth node from last
// Link: https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
public class _1RemoveNthLastNode {

    //Using two pointers
    public static ListNode removeNthLastNode(ListNode head, int n) {

        ListNode fast = head;
        int length = 0;
        for(int i=1;i<=n && fast!=null;i++)
        {
            fast = fast.next;
            length++;
        }
        if(length<n)
        {
            return head;
        }

        if(fast==null)
            return head.next;
        else
        {
            ListNode slow = head;
            while (fast.next!=null)
            {
                fast = fast.next;
                slow = slow.next;
            }
            slow.next = slow.next.next;
            System.out.printf(String.valueOf(slow.val));
        }
        System.out.println();
        return head;
    }

    // Using Hash Table we can solve this problem
    public static ListNode removeNthLastNode2(ListNode head, int n) {

        HashMap<Integer, ListNode> map = new HashMap<>();
        ListNode curr = head;
        int i = 1;
        while (curr != null)
        {
            map.put(i++,curr);
            curr = curr.next;
        }
        i--;
        if(i<n)
        {
           return  head;
        }
        if(i==n)
        {
            return head.next;
        }
        if(map.containsKey(i-n))
        {
            ListNode temp =  map.get(i-n);
            temp.next = temp.next.next;
        }

        return head;
    }

    public static void main(String[] args) {

        LinkedList list = new LinkedList();
        for(int i=1;i<=6;i++)
        {
            list.insertAtEnd(i);
        }
        list.print(list.head);
       ListNode n = removeNthLastNode2(list.head,6);
       list.print(n);
    }
}
