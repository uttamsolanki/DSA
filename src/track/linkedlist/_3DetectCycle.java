package track.linkedlist;

import track.linkedlist.implementation.*;

import java.util.HashSet;

/**
 * Problem: https://leetcode.com/problems/linked-list-cycle/description/
 */
public class _3DetectCycle {
    // Using hashTable
    public static boolean approach1(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();

        ListNode curr = head;
        while (curr!=null)
        {
            if(set.contains(curr))
            {
                return  true;
            }
            set.add(curr);
            curr = curr.next;
        }


        return false;
    }
    //TC : O(n)
    //SC L O(n)
    // We can solve using Floyd cycle finding algorithm ( slow and fast pointer)
    public static boolean approach2(ListNode head)
    {
        if(head == null)
        {
            return false;
        }

        ListNode fast = head;
        ListNode slow = head;
        while(fast !=null && fast.next !=null)
        {
            slow = slow.next;
            fast = fast.next.next;

            if(fast == slow)
            {
                return true;
            }
        }
        return false;
    }
    // TC: O(n)
    // SC: O(1)

    // If we have to return node where cycle is detected
    // Approach1 : we can use HashMap to get node
    // Approach2 : we can use two pointers
    // When we take slow and fast pointers it will be match node which is half of the way from head
    // So, once its detected cycle we can start slow point from head again and move one by one both pointer
    public static ListNode approach3(ListNode head)
    {
        if(head == null)
        {
            return null;
        }

        ListNode fast = head;
        ListNode slow = head;
        boolean isCycle = false;
        while(fast !=null && fast.next !=null)
        {
            slow = slow.next;
            fast = fast.next.next;

            if(fast == slow)
            {
                isCycle = true;
                break;
            }
        }
        if(isCycle==false)
        {
            return null;
        }
        slow = head;
        while (slow!=null)
        {
            if(slow==fast) return slow;
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
    // Another Problem:We can find length of loop as well
    public static int Approach4(ListNode head)
    {
        if(head == null)
        {
            return -1;
        }

        ListNode slow = head;
        ListNode fast = head;
        boolean isCycle = false;
        while (fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
            {
                isCycle = true;
                break;
            }
        }
        if (isCycle==false)
        {
            return -1;
        }
        int cnt = 0;

        do{
            cnt++;
            fast = fast.next;
        }
        while (fast != slow);
        return cnt;

    }

    public static void main(String[] args) {
//        int ans = approach1();
//        System.out.println(ans);
    }
}
