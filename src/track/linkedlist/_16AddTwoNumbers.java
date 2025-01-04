package track.linkedlist;

import track.linkedlist.implementation.LinkedList;
import track.linkedlist.implementation.ListNode;

/**
 * Approach 1 : Add Two Numbers
 * Link: https://leetcode.com/problems/add-two-numbers/description/
 * Another variation : https://www.geeksforgeeks.org/sum-of-two-linked-lists/
 *  => to solve this, just reverse given list and follow below approach and last reverse ans list and return it
 */
public class _16AddTwoNumbers {
    /**
     * Approach 1: we can use stack ds and pop element one by one
     * TC: O(n), SC: O(min(n.m))
     */

    /**
     * Approach 2: Two pointer approach
     * Iterate one by one and get sum of two node with curry
     * Create new node with last digit of sum and Stored in third list
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int curr = 0;
        ListNode c1 = l1;
        ListNode c2 = l2;
        ListNode l3 = new ListNode(-1);
        ListNode c3=l3;

        while(c1!=null && c2!=null)
        {
            int sum = curr + c1.val + c2.val;
            int val = sum%10;
            curr = sum/10;
            c3.next = new ListNode(val);
            c3 = c3.next;
            c1 = c1.next;
            c2 = c2.next;
        }
        c1= c1==null? c2:c1;
        while(c1!=null)
        {
            int sum = curr + c1.val;
            int val = sum%10;
            curr = sum/10;
            c3.next = new ListNode(val);
            c3 = c3.next;
            c1 = c1.next;
        }

        if(curr>0)
        {
            c3.next = new ListNode(curr);
        }

        return l3.next;
    }
    // TC:O(n), SC: O(1)

    /**
     * Approach 3 : We can solve without extra list
     * Find out large list first then store ans int it
     */
    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {

        if(countNode(l1)>countNode(l2))
        {
            return addTwoNumbers2(l2,l1);
        }

        ListNode curr1 = l1;
        ListNode curr2 = l2;
        ListNode tail = null;
        int curry =0;

        while (curr1!=null && curr2!=null)
        {
            tail =curr1;
            int sum = curry + curr1.val + curr2.val;
            curry = sum/10;
            curr1.val = sum % 10;
            curr1 = curr1.next;
            curr2 = curr2.next;
        }

        while (curr1 != null)
        {
            tail =curr1;
            int sum = curry + curr1.val;
            curry = sum/10;
            curr1.val = sum % 10;
            curr1 = curr1.next;
        }
        if(curry>0)
        {
            tail.next =  new ListNode(curry);
        }

        return l1;
    }
    public static int countNode(ListNode list)
    {
        ListNode curr = list;
        int n=0;
        while (curr != null)
        {
            n++;
            curr = curr.next;
        }
        return n;
    }
    public static void main(String[] args) {
        LinkedList l1 = new LinkedList();
        for(int i=1;i<=5;i++)
        {
            l1.insertAtEnd(i);
        }
        LinkedList l2 = new LinkedList();
        for(int i=5;i<=9;i++)
        {
            l2.insertAtEnd(i);
        }

        ListNode ans = addTwoNumbers(l1.head,l2.head);
       l1.print(ans);
    }
}
