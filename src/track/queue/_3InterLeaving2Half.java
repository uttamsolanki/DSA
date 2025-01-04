package track.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Problem: Interleave the First Half of the Queue with Second Half
 * Link: https://www.geeksforgeeks.org/problems/interleave-the-first-half-of-the-queue-with-second-half/1?
 */
public class _3InterLeaving2Half {
    // Approach 1 : We can use Stack and Queue to solve this problem
    public static void interLeaving2Half(Queue<Integer> q) {
        if(q.isEmpty())
        {
            return;
        }

        int n = q.size();
        if(n%2==1)
        {
            return;
        }

        Stack<Integer> st = new Stack<>();

        for(int i=0;i<=n/2;i++)
        {
            st.push(q.poll());
        }

        while (!st.isEmpty())
        {
            q.add(st.pop());
        }

        for(int i=0;i<=n/2;i++)
        {
            q.add(q.poll());
        }
        for(int i=0;i<=n/2;i++)
        {
            st.push(q.poll());
        }

        while (!st.isEmpty())
        {
            q.add(st.pop());
            q.add(q.poll());
        }

    }

    // TC: O(n), SC:O(n)

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        interLeaving2Half(q);
        while (!q.isEmpty())
        {
            System.out.print(q.poll()+" ");
        }
    }
}
