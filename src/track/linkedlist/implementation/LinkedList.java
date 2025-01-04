package track.linkedlist.implementation;

import java.util.Scanner;

public class LinkedList {
    public ListNode head;
    public LinkedList()
    {
        this.head = null;
    }

    // Insert node at end
    public void insertAtEnd(int x)
    {
        if(this.head==null)
        {
            this.head = new ListNode(x);
        }else
        {
            ListNode temp =  this.head;
            while (temp.next!= null)
            {
                temp = temp.next;
            }
            temp.next = new ListNode(x);
        }
    }
    // Insert the node at beginnig
    void insertAtBeginning(int x)
    {
        ListNode temp =  new ListNode(x);
        if(this.head != null)
        {
            temp.next =  this.head;
        }
        this.head =  temp;
    }

    //Insert the node at nth position
    void insertAtNthPosition(int x, int n)
    {
        ListNode newNode =  new ListNode(x);
        if(n == 1 || this.head == null)
        {
            newNode.next =  this.head;
            this.head = newNode;
        }
        else
        {
            ListNode curr =  this.head;
            // Why N-2 here, b'coz we need to reach at n-1 node first
            // and here given n is 1 based index so 0 based index would be n-2
            // Both condition is added , either we will reach at n-1  position or last node
            for(int i=0;i<n-2 && curr.next!=null;i++)
            {
                curr = curr.next;
            }
            newNode.next = curr.next;
            curr.next = newNode;
        }
    }
    // Delete the node from nth position
    void delete(int n)
    {
        if(n==1)
        {
            if(this.head!=null)
            {
                this.head = this.head.next;
            }
        }
        else
        {
            ListNode curr =  this.head;
            for(int i=0;i<n-2 && curr!=null;i++)
            {
                curr = curr.next;
            }
            // check if curr node is not last node
            if(curr.next!=null)
            {
                curr.next = curr.next.next;
            }
        }
    }
    public void  print(ListNode head)
    {
        ListNode curr =  head;
        while (curr!=null)
        {

            System.out.print(curr.val +" ");
            curr = curr.next;
        }
        System.out.println();
    }
    void printUsingRec(ListNode head)
    {
        ListNode curr = head;

        while (curr!=null)
        {
            System.out.print(curr.val +" ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        Scanner sc = new Scanner(System.in);
//        for(int i=0;i<5;i++)
//        {
//            int x = sc.nextInt();
//            list.insertAtBeginning(x);
//        }
        list.insertAtNthPosition(10,1);
        list.insertAtNthPosition(20,1);
        list.insertAtNthPosition(30,1);
        list.insertAtNthPosition(40,1);
        list.insertAtNthPosition(50,6);
        list.print(list.head);
        System.out.println("------");
        list.printUsingRec(list.head);
    }

}
