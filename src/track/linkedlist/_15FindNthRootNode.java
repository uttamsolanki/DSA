package track.linkedlist;

import track.linkedlist.implementation.LinkedList;
import track.linkedlist.implementation.ListNode;

/**
 * Problem:
 */
public class _15FindNthRootNode {
    // Approach 1: Using
    public static ListNode FindSqrtOfNNode(ListNode head) {

        if(head==null)
        {
            return null;
        }
        int i=1,j=1;
        ListNode curr=head,sqrtHead=null;
        while (curr!=null)
        {
            if(i==j*j)
            {
                if(sqrtHead==null)
                {
                    sqrtHead=head;
                }
                else
                {
                    sqrtHead = sqrtHead.next;
                }

                j++;
            }
            i++;
            curr = curr.next;
        }

        return sqrtHead;
    }
    //TC: O(n), SC:O(1)

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        for(int i=1;i<=16;i++)
        {
            ll.insertAtEnd(i);
        }
        ListNode ans = FindSqrtOfNNode(ll.head);
        System.out.println(ans.val);
    }
}
