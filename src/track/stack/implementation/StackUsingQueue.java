package track.stack.implementation;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Problem: Design stack using queue
 */
public class StackUsingQueue {
    Queue<Integer> q;
    StackUsingQueue()
    {
        q = new LinkedList<>();
    }

    void push(int x)
    {
        q.add(x);
    }
    int pop()
    {
        int n = q.size();
        if(n==0)
        {
            return -1;
        }
        while (n-->1)
        {
            q.add(q.poll());
        }

        return q.poll();
    }

    public static void main(String[] args) {
        StackUsingQueue st = new  StackUsingQueue();
        st.push(10);
        st.push(20);
        st.push(30);
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());
    }
}
