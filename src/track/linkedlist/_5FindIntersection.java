package track.linkedlist;

import track.linkedlist.implementation.ListNode;

import java.util.HashSet;
import java.util.Stack;

/**
 * Problem : https://leetcode.com/problems/intersection-of-two-linked-lists/description/
 */
public class _5FindIntersection {

    /**
     * Approach1; We can use hashing technique to find the intersection of linked list
     * 1. Iterate any one list and store into hashset
     * 2. Iterate second list and check if any node is matching
     * 3. if matching then return that node otherwise return null
     */
    public static  ListNode getIntersectionNode(ListNode headA, ListNode headB)
    {
        HashSet<ListNode> set = new HashSet<>();

        ListNode curr = headA;
        while (curr != null)
        {
            set.add(curr);
            curr = curr.next;
        }

        curr = headB;
        while (curr!=null)
        {
            if(set.contains(curr))
            {
                return curr;
            }
            curr = curr.next;
        }

        // did not find intersection
        return null;
    }
    // TC:O(n), O(n)

    /**
     * Approach 2: Using two stack
     * Store each list in individual list
     * Now, check pop element from both stack until its not same
     * Return last match node
     */
    public static  ListNode getIntersectionNode2(ListNode headA, ListNode headB)
    {
        Stack<ListNode> st1 = new Stack<>();
        Stack<ListNode> st2 = new Stack<>();

        ListNode curr = headA;
        while (curr != null)
        {
            st1.push(curr);
            curr = curr.next;
        }

        curr = headB;
        while (curr != null)
        {
            st2.push(curr);
            curr = curr.next;
        }

        ListNode ans = null;
        while (!st1.isEmpty() && st2.isEmpty() && st1.peek() == st2.peek() )
        {
           ans= st1.pop();
           st2.pop();
        }
        return ans;
    }
    // TC: O(m+n), SC: O(m+n)

    /**
     * Approach 3 : We can store element in array one by one from both list
     * then find first repeating element
     * TC=SC : O(M+N)
     */

    /**
     * Approach 4: we can store one list in array then sort it
     * Now interate second list and search element in sorted array
     * TC : O(Max(mlogm, nlogn)), SC: O(Max(m,n))
     */


    // Approach 5: We can use two point approach to find intersection
    public static ListNode getIntersectionNode5(ListNode headA, ListNode headB) {
        ListNode p1 = headA;
        ListNode p2 = headB;

        // Check until both lists are not end
        while(p1 != null && p2 != null)
        {
            if(p1==p2)
            {
                return p1;
            }
            p1 = p1.next;
            p2 = p2.next;

            // Any one of list is end then point another list
            if(p1==null && p2 !=null)
            {
                p1 = headB;
            }else if(p1!=null && p2 ==null)
            {
                p2 = headA;
            }
        }
        return null;
    }
    // TC: O(1), O(1)

    public static void main(String[] args) {
        //getIntersectionNode
    }
}
