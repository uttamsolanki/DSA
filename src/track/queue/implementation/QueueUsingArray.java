package track.queue.implementation;

/**
 * Problem: Design queue using fixed sized array
 * Link:https://www.geeksforgeeks.org/problems/implement-queue-using-array/1
 */
public class QueueUsingArray {

    int[] arr;
    int front,rear;
    int n;
    QueueUsingArray()
    {
        n = 5;
        arr = new int[n];
        front = -1;
        rear = -1;
    }

    boolean isEmpty()
    {
        return rear==-1 && front==-1;
    }

    boolean isFull()
    {
        return (front==0 && rear==n-1) || (front-1==rear);
    }
    void enQueue(int x)
    {
        if(isFull())
        {
            System.out.println("Queue is full");
            return;
        }
        else if(front==-1)
        {
            front=rear=1;
        }
        else
        {
            rear = (rear+1)%n;
        }

        arr[rear] = x;
    }
    int deQueue()
    {
        if(isEmpty())
        {
            System.out.println("Queue is empty");
            return -1;
        }
        int val =  arr[front];

        if(front==rear)
        {
            front=-1;
            rear=-1;
        }else
        {
            front = (front+1)%n;
        }

        return val;
    }
    public static void main(String[] args) {

        QueueUsingArray  q = new QueueUsingArray();
        q.enQueue(10);
        q.enQueue(20);
        q.enQueue(30);
        q.enQueue(40);
        q.enQueue(50);
        System.out.println(q.deQueue());
        q.enQueue(60);
        System.out.println(q.deQueue());
        System.out.println(q.deQueue());
        System.out.println(q.deQueue());
        System.out.println(q.deQueue());
        System.out.println(q.deQueue());
        System.out.println(q.deQueue());
        System.out.println(q.deQueue());
      //  q.enQueue(70);

       // System.out.println(q.deQueue());

    }
}
