package track.linkedlist.implementation;

public class CLinkedList {

    public CLLNode head;
    public CLinkedList()
    {
        this.head = null;
    }
    public void print(CLLNode head)
    {
        CLLNode curr = head;
        if(head==null)
        {
            return;
        }

        do{
            System.out.print(curr.data+" ");
            curr = curr.next;
        }while (head!=curr);
        System.out.println();
    }
    public void insertAtTail(int x)
    {
        CLLNode node = new CLLNode(x);
        node.next = node;
        if(this.head==null)
        {
            this.head = node;
        }
        else
        {
            CLLNode curr = this.head;
            while (curr.next != this.head)
            {
                curr = curr.next;
            }
            node.next = curr.next;
            curr.next = node;
        }
    }
    public void insertAtHead(int x)
    {
        CLLNode node = new CLLNode(x);
        node.next = node;
        if(this.head==null)
        {
            this.head = node;
        }
        else
        {
            CLLNode curr = this.head;
            while (curr.next != this.head)
            {
                curr = curr.next;
            }
            node.next = curr.next;
            curr.next = node;
            // just update head to new node
            this.head = node;
        }
    }
    public void deleteLastNode()
    {
        if(this.head==null)
        {
            return;
        }
        if(this.head==this.head.next)
        {
            this.head=null;
        }
        else
        {
            CLLNode temp=null;
            CLLNode curr = this.head;
            while (curr.next != this.head)
            {
                temp = curr;
                curr = curr.next;
            }
            temp.next = this.head;
        }
    }
    public void deleteFrontNode()
    {
        if(this.head==null)
        {
            return;
        }
        if(this.head==this.head.next)
        {
            this.head=null;
        }
        else
        {
            CLLNode curr = this.head;
            while (curr.next != this.head)
            {
                curr = curr.next;
            }
            curr.next = this.head.next;
            this.head = this.head.next;
        }
    }

    public static void main(String[] args) {
        CLinkedList cll = new CLinkedList();
        cll.insertAtTail(1);
        cll.insertAtTail(2);
        cll.insertAtTail(3);
        //cll.insertAtHead(5);
        cll.deleteLastNode();
        //cll.deleteFrontNode();
        cll.print(cll.head);
    }
}
