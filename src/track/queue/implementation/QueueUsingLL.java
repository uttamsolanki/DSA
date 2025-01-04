package track.queue.implementation;

import track.linkedlist.implementation.ListNode;

/**
 * Problem: Design queue using LinkedList
 * Link: https://www.geeksforgeeks.org/problems/implement-queue-using-linked-list/1
 */
public class QueueUsingLL {

    ListNode front,rear;
    QueueUsingLL()
    {
        front = null;
        rear = null;
    }

    boolean isEmpty()
    {
        return front==null;
    }

    void enQueue(int x)
    {
        ListNode temp = new ListNode(x);
        if(front==null)
        {
            front = temp;
            rear = temp;
        }
        else
        {
            rear.next=temp;
            rear = rear.next;
        }
    }
    int deQueue()
    {
        if(isEmpty())
        {
            return -1;
        }
        int val =  front.val;
        front = front.next;
        if(front==null)
        {
            rear = null;
        }
        return val;
    }


    public static void main(String[] args) {
        QueueUsingLL q = new QueueUsingLL();
        q.enQueue(10);
        q.enQueue(20);
        q.enQueue(30);
        System.out.println(q.deQueue());
        q.enQueue(40);
        System.out.println(q.deQueue());
        System.out.println(q.deQueue());
        System.out.println(q.deQueue());
        q.enQueue(50);
        System.out.println(q.deQueue());
        System.out.println(q.deQueue());

    }
}
