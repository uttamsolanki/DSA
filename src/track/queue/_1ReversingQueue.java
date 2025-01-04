package track.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Problem: Give an algorithm for reversing a queue Q. To access the queue, we are only allowed to use the methods of queue ADT
 */
public class _1ReversingQueue {
    //Approach 1: we can use stack to reverse queue element
    public static void reversingQueue(Queue<Integer> q) {
        Stack<Integer> st = new Stack<>();

        while (!q.isEmpty())
        {
            st.push(q.poll());
        }
        while (!st.isEmpty())
        {
            q.add(st.pop());
        }
    }
    //TC: O(n), SC: O(n)

    // Approach - 2: we can solve this problem using recursion as well

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        reversingQueue(q);
        while (!q.isEmpty())
        {
            System.out.println(q.poll());
        }
    }
}
