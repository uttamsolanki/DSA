package track.stack.implementation;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Problem : Implemen stack using two queue
 * We can make one of the operation expensive based on requirements
 * In this problem : push : O(1), pop: O(n)
 */
public class StackUsingTwoQueue {
    Queue<Integer> q1;
    Queue<Integer> q2;
    StackUsingTwoQueue()
    {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }
    void push(int x)
    {
        q1.add(x);
    }

    int pop()
    {
        int val = -1;
        while (!q1.isEmpty())
        {
            val = q1.poll();
            if(q1.isEmpty())
            {
                break;
            }
            q2.add(val);
        }
        Queue<Integer> temp = q2;
        q2 = q1;
        q1 = temp;
        return val;
    }

    public static void main(String[] args) {
        StackUsingTwoQueue s = new StackUsingTwoQueue();
        s.push(10);
        s.push(20);
        s.push(30);
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
    }
}
