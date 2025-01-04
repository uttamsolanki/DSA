package track.linkedlist.implementation;

public class DoublyLinkedList {

    DLLNode head;
    DoublyLinkedList()
    {
        this.head = null;
    }

     void print(DLLNode node)
     {
         while (node != null)
         {
             System.out.print(node.val +" ");
             node = node.next;
         }
         System.out.println();
     }

     void reversePrint(DLLNode node)
     {
         if(node==null) return;

         while (node.next!=null)
         {
             node = node.next;
         }

         while (node!=null)
         {
             System.out.print(node.val+" ");
             node = node.prev;
         }
         System.out.println();
     }


    void InsertAtHead(int x)
    {
        DLLNode node = new DLLNode(x);
        if(this.head==null)
        {
            this.head = node;
            return;
        }
        this.head.prev = node;
        node.next = this.head;

        this.head = node;
    }

     void InsertAtTail(int x)
     {
         DLLNode node = new DLLNode(x);

         if(this.head == null)
         {
             this.head = node;
             return;
         }

         DLLNode curr = this.head;
         while (curr.next!=null)
         {
             curr = curr.next;
         }

         curr.next = node;
         node.prev = curr;

     }

     void InsertAtNthPosition(int n, int x)
     {
         DLLNode node = new DLLNode(x);
         if(this.head==null)
         {
             this.head = node;
             return;
         }

         if(n==1)
         {
             this.head.prev = node;
             node.next = this.head;
             this.head = node;
         }
         else
         {
             DLLNode curr = this.head;

             for(int i=0;i<n-2 && curr!=null;i++)
             {
                 curr = curr.next;
             }

             if(curr!=null)
             {
                 DLLNode next = curr.next;
                 node.next = next;
                 next.prev = node;
                 curr.next = node;
                 node.prev = curr;
             }

         }
     }

     void deleteNthNode(int n)
     {
         if(this.head==null)
         {
             return;
         }

         if(n==1)
         {
             this.head = this.head.next;

             if(this.head!=null)
             {
                 this.head.prev = null;
             }
         }
         else
         {
             DLLNode curr = this.head;

             // Using position count
             for(int i=0;i<n-2 && curr!=null;i++)
             {
                 curr = curr.next;
             }

             if(curr != null && curr.next != null)
             {
                    DLLNode nextNode = curr.next.next;

                    if(nextNode==null)
                    {
                        curr.next.prev = null;
                        curr.next = null;
                    }
                    else
                    {
                        nextNode.prev = curr;
                        curr.next = nextNode;
                    }
             }
         }
     }

    public static void main(String[] args) {
        DoublyLinkedList dll =  new DoublyLinkedList();

        for (int i=1;i<=5;i++)
        {
            dll.InsertAtTail(i);
        }
        dll.deleteNthNode(6);
     //   dll.InsertAtNthPosition(5,6);
        dll.print(dll.head);
        dll.reversePrint(dll.head);
    }
}
