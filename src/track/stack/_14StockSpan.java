package track.stack;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Problem: Finding Spans: Given an array A, the span S[i] of A[i] is the maximum number of consecutive elements A[j] immediately preceding A[i] and such that A[j] < A[i]?
 * Link-1: https://leetcode.com/problems/online-stock-span/
 * Link-2: https://www.geeksforgeeks.org/problems/stock-span-problem-1587115621/1?
 */
public class _14StockSpan {
    // Approach 1 : we can use 2 for loop to solve this problem
    // Approach 2: we can use monotonic stack to solve this problem
    public static ArrayList<Integer> calculateSpan(int[] arr) {
        ArrayList<Integer> span = new ArrayList<>();
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i++)
        {
            while (!st.isEmpty() && arr[st.peek()]<=arr[i])
            {
                st.pop();
            }
            int top =-1;
            if(!st.isEmpty())
            {
                top = st.peek();
            }
            span.add(i-top);
            st.push(i);
        }
        return span;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{11, 4, 5, 90, 120, 80};
        ArrayList<Integer> ans = calculateSpan(arr);
        System.out.println(ans);
    }
}
