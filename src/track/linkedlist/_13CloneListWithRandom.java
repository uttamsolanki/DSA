package track.linkedlist;

import java.util.HashMap;

/**
 * Porblem: Copy List with Random Pointer
 * Link : https://leetcode.com/problems/copy-list-with-random-pointer/description/
 */
public class _13CloneListWithRandom {
   static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    /**
     * Approach-1: Using HashTable
     */
    public static  Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<>();

        Node curr = head;


        while(curr!=null)
        {
            map.put(curr,new Node(curr.val));

            curr = curr.next;
        }

        curr= head;

        while(curr != null)
        {
            Node newNode = map.get(curr);
            newNode.next = map.get(curr.next);
            newNode.random = map.get(curr.random);
            curr = curr.next;
        }

        return map.get(head);
    }
    //TC: O(n), SC:O(n)

    /**
     * Approach-2 Using in-place approach
     * Create new node and insert its next
     * Create one by one and at last unlink original list
     */
    public static Node copyRandomList2(Node head)
    {
        if(head==null)
        {
            return null;
        }

        Node curr = head;

        while (curr != null)
        {
            Node newNode = new Node(curr.val);
            // insert current to next
            newNode.next = curr.next;
            curr.next = newNode;
            curr = newNode.next;
        }

        // Update random node
        curr = head;

        while(curr!=null)
        {
            if(curr.random != null)
            {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        curr = head;
        Node cloneHead = head.next;
        Node clone = head.next;
        while (clone.next!=null)
        {
            // unlink clone and original
            curr.next = curr.next.next;
            clone.next = clone.next.next;
            // advance curr
            curr = curr.next;
            clone = clone.next;
        }
        curr.next = null;
        clone.next = null;
        return cloneHead;
    }
    //TC: O(n), SC:(1)

    public void main(String[] args) {

        //System.out.println(ans);
    }
}
