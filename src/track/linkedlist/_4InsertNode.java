package track.linkedlist;

import track.linkedlist.implementation.ListNode;

/**
 * Problem: Insert a node in sorted linked list
 * Link: https://www.geeksforgeeks.org/problems/insert-in-a-sorted-list/1
 */
public class _4InsertNode {
    ListNode sortedInsert(ListNode head, int key) {
        // Add your code here.
        ListNode curr = null;
        ListNode next = head;
        ListNode newNode = new ListNode(key);

        if(head==null)
        {
            return newNode;
        }
        while(next!=null)
        {
            if(next.val<key)
            {
                curr = next;
                next = next.next;
            }else
            {
                break;
            }
        }

        if(curr==null)
        {

            newNode.next = head;
            head = newNode;
        }
        else
        {
            curr.next = newNode;
            newNode.next = next;
        }
        return head;
    }
    //TC: O(n), SC: O(1)

    public static void main(String[] args) {

    }
}
