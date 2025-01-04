package track.queue.implementation;

import java.util.Stack;

/**
 * Problem: Design queue using stack
 */
public class QueueUsingStack {
    Stack<Integer> s1;
    Stack<Integer> s2;
    QueueUsingStack()
    {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }
    void push(int x)
    {
        s1.push(x);
    }

    int pop()
    {
        if(s2.isEmpty() && s1.isEmpty())
        {
            return -1;
        }
        else if(s2.isEmpty())
        {
            while (!s1.isEmpty())
            {
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }
    // TC: here pop would be O(n) but push would be O(1)

    public static void main(String[] args) {

        QueueUsingStack q = new QueueUsingStack();
        q.push(10);
        q.push(20);
        q.push(30);
        System.out.println(q.pop());
        System.out.println(q.pop());
        System.out.println(q.pop());
        System.out.println(q.pop());
    }
}
