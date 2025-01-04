package track.linkedlist;

import track.linkedlist.implementation.LinkedList;
import track.linkedlist.implementation.ListNode;

public class _9ReverseInPair {
    /**
     * Approach 1: Based on odd/even position and take one by one node
     * Create new list based on odd and even number position
     * Use flag to maintain position
     * Then marge one by one
     */
    public static ListNode swapPairs(ListNode head) {
        ListNode odd = new ListNode(-1);
        ListNode even =  new ListNode(-1);
        ListNode curr = head;
        ListNode oddCurr = odd;
        ListNode evenCurr = even;
        int flag = 1;

        while (curr!=null)
        {
            if(flag==1)
            {
                oddCurr.next = curr;
                oddCurr =oddCurr.next;
                curr = curr.next;
                oddCurr.next = null;
            }
            else
            {
                evenCurr.next = curr;
                evenCurr =evenCurr.next;
                curr = curr.next;
                evenCurr.next = null;
            }

            flag = flag ^ 1;
        }
        odd = odd.next;
        even = even.next;
        flag=1;
        ListNode ans = new ListNode(-1);
        curr = ans;
        while (odd!=null && even!=null)
        {
            if(flag==0)
            {
                curr.next = odd;
                odd = odd.next;
                curr=curr.next;
                curr.next = null;
            }
            else
            {
                curr.next = even;
                even = even.next;
                curr=curr.next;
                curr.next = null;
            }
            flag = flag ^ 1;
        }
        curr.next = odd==null?even:odd;

        return ans.next;
    }
    //TC:O(n), SC:(1) but took exra memories for even/odd pointers


    /**
     * Approach 2: Using odd/event pointers and swap node value
     */
    public static ListNode swapPairs2(ListNode head) {
        if(head==null || head.next==null)
        {
            return head;
        }

        ListNode prev = head;
        ListNode curr = head.next;

        while (prev != null && curr != null)
        {
            int temp = prev.val;
            prev.val = curr.val;
            curr.val = temp;

            prev = curr.next;
            if(prev!=null)
            {
                curr = prev.next;
            }
            else
            {
                curr = prev;
            }
        }
        return head;
    }
    //TC: O(n), SC:(1)

    /**
     * Approach 3: Using odd/event pointers and swap node its self
     */
    public static ListNode swapPairs3(ListNode head) {
        if(head==null || head.next==null)
        {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode prev1 = dummy;
        ListNode prev2 = dummy.next;
        ListNode curr = prev2.next;

        while (curr != null)
        {
            prev2.next = curr.next;
            curr.next = prev2;
            prev1.next = curr;


            prev1 = prev2;
            prev2 = prev1.next;
            if(prev2==null)
            {
                curr = null;
            }else
            {
                curr = prev2.next;
            }

        }
        return dummy.next;
    }
    //TC: O(n), SC:O(1)

    public static void main(String[] args) {
        LinkedList ll1 = new LinkedList();
        ll1.insertAtEnd(1);
        ll1.insertAtEnd(2);
        ll1.insertAtEnd(3);
        ll1.insertAtEnd(4);
       // ll1.insertAtEnd(5);
        ll1.print(ll1.head);
        ListNode ans = swapPairs3(ll1.head);
        ll1.print(ans);
    }
}
