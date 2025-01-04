package track.queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Problem: Maximum sum in sliding window
 */
public class _2MaximumSum {
    // We can solve this problem in optimal way using two pointers
    // Here we can try using queue
    public static int maximumSum(int[] arr, int w) {
        int n = arr.length;
        int sum=0;
        Queue<Integer> q = new LinkedList<>();
        int maxSum = 0;

        for(int i=0;i<n;i++)
        {
            sum += arr[i];
            q.add(arr[i]);
            if(q.size()>w)
            {
                sum -= q.poll();
            }
            if(q.size() == w)
            {
                maxSum = Math.max(maxSum,sum);
            }


        }
        return maxSum;
    }

    //TC: O(n), SP: O(w) => window size;

    public static void main(String[] args) {
        int[] arr = new int[]{1,3,-1,-3,5,3,6,7};
        int ans = maximumSum(arr,3);
        System.out.println(ans);

        Deque<Integer> deque = new ArrayDeque<>();
        deque.addFirst(10);
        deque.addFirst(20);
        System.out.println(deque.removeLast());
    }
}
