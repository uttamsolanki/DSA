package track.linkedlist.implementation;

public class DLLNode {
   int val;
   DLLNode next;
   DLLNode prev;
   DLLNode(int x)
   {
       this.val = x;
       this.prev = null;
       this.next = null;
   }
}
