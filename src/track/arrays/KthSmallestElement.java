package track.arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Problem: Given an array arr[] and an integer k where k is smaller than the size of the array, the task is to find the kth smallest element in the given array.
 * Follow up: Don't solve it using the inbuilt sort function.
 */
public class KthSmallestElement {

    //Using sorting Approach
    public static int approach1(int[] arr, int k) {
        Arrays.sort(arr);
        if(k<arr.length)
        {
            return arr[k-1];
        }
        return 0;
    }
    //Using Priority queue
    public static int approach2(int[] arr, int k)
    {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0;i<arr.length;i++)
        {
            pq.add(arr[i]);
            if(!pq.isEmpty() && pq.size()>k)
            {
                pq.poll();
            }
        }
        return pq.poll();
    }

    public static void main(String[] args) {
        int[] arr = new int[]{7, 10, 4, 3, 20, 15};

        int ans = approach2(arr,3);
        System.out.println(ans);
    }
}
