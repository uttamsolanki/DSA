package track.stack;

import java.util.Stack;

/**
 * Problem: Largest Rectangular Area in a Histogram
 * Link - 1: https://www.geeksforgeeks.org/problems/maximum-rectangular-area-in-a-histogram-1587115620/1?
 * Link - 2: https://leetcode.com/problems/largest-rectangle-in-histogram/
 */
public class _15LargestRectangleArea {
    /**
     * Approach - 1: We can use 2 for loop and find greater element from current for left and right
     */
    public static int largestRectangleArea(int[] arr) {

        int n =  arr.length;
        int ans = 0;
        for(int i=0;i<n;i++)
        {
            int curr = arr[i];
            for(int j=i-1;j>=0 && arr[j]>=arr[i];j--)
            {
                curr+=arr[i];
            }
            for(int j=i+1;j<n && arr[j]>=arr[i];j++)
            {
                curr+=arr[i];
            }
            ans = Math.max(ans,curr);
        }
        return ans;
    }
    // TC: O(n^2), SC: O(n)

    /**
     * Approach - 2: We can find next small elements and previous small elements using stack
     */
    public static int largestRectangleArea2(int[] arr) {
        int n =  arr.length;
        int ans = 0;
        int[] nextSmall = nextSmall(arr);
        int[] prevSmall = prevSmall(arr);

        for(int i=0;i<n;i++)
        {
            ans = Math.max(ans, (nextSmall[i]-prevSmall[i]-1)* arr[i] );
        }
        return ans;
    }
    // TC: O(n), SC: O(n)

    public static int[] nextSmall(int[] arr)
    {
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int[] smaller = new int[n];

        for(int i=n-1;i>=0;i--)
        {
            while (!st.isEmpty() && arr[st.peek()]>=arr[i])
            {
                st.pop();
            }
            if(st.isEmpty())
            {
                smaller[i] = n;
            }
            else
            {
                smaller[i] = st.peek();
            }
            st.push(i);
        }

        return smaller;
    }
    public static int[] prevSmall(int[] arr)
    {
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int[] smaller = new int[n];

        for(int i=0;i<n;i++)
        {
            while (!st.isEmpty() && arr[st.peek()]>=arr[i])
            {
                st.pop();
            }
            if(st.isEmpty())
            {
                smaller[i] = -1;
            }
            else
            {
                smaller[i] = st.peek();
            }
            st.push(i);
        }

        return smaller;
    }

    // Approach 3: Space optimized approach using stack
    public static int largestRectangleArea3(int[] arr) {
        int n = arr.length;

        int ans = 0;

        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i++)
        {
            while (!st.isEmpty() && arr[st.peek()]>=arr[i])
            {
                int popIndex = st.pop();
                int width = st.isEmpty()?i:i - st.peek()-1;
                ans = Math.max(ans,width*arr[popIndex]);
            }
            st.push(i);
        }

        while (!st.isEmpty())
        {
            int popIndex = st.pop();
            int width = st.isEmpty()?n:n - st.peek()-1;

            ans = Math.max(ans,width*arr[popIndex]);
        }

        return  ans;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{60, 20, 50, 40, 10, 50, 60};
        int ans = largestRectangleArea3(arr);
        System.out.println(ans);
    }
}
