package track.queue;

import java.util.Queue;
import java.util.Stack;

/**
 * Problem: Reverse First K elements of Queue
 * Link: https://www.geeksforgeeks.org/problems/reverse-first-k-elements-of-queue/1?
 */
public class _4ReverseKelement {

    // Approach 1: Using stack
    public static Queue<Integer> modifyQueue(Queue<Integer> q, int k) {

        Stack<Integer> st = new Stack<>();
        int n = q.size();
        int count=0;
        while (!q.isEmpty() && count<k)
        {
            st.add(q.poll());
            count++;
        }
        while (!st.isEmpty())
        {
            q.add(st.pop());
        }

        if(n<=k)
        {
            return q;
        }
        count=0;
        k = n-k;
        while (!q.isEmpty() && count<k)
        {
            q.add(q.poll());
            count++;
        }
        return q;
    }

    public static void main(String[] args) {
        int ans = approach1();
        System.out.println(ans);
    }
}
