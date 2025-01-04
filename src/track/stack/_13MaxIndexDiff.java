package track.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * Probolem :  Given an array A of integers, find the maximum of j – i subjected to the constraint of A[i] < A[j].
 * Link: https://www.geeksforgeeks.org/problems/maximum-index3307/1
 */
public class _13MaxIndexDiff {
    //Approach 1: Brute force appraoch
    public static int maxIndexDiff(int[] arr) {

        int  n =  arr.length;
        int maxAns = 0;
        for(int i=0;i<n-1;i++)
        {
            int max = 0;
            for(int j=i+1;j<n;j++)
            {
                if(arr[i]<arr[j])
                {
                    max = Math.max(max,j-i);
                }
            }
            maxAns = Math.max(max,maxAns);
        }

        return maxAns;
    }
    // TC: O(n2), SC: O(1)

    //Approach 2: we can find max greatest element, in that we can create monotonic decreasing array
    public static int maxIndexDiff2(int[] arr) {

        int n =  arr.length;
        int[] maxEnd = new int[n];
        maxEnd[n-1] = arr[n-1];

        for(int i=n-2;i>=0;i--)
        {
            maxEnd[i] = Math.max(maxEnd[i+1],arr[i]);
        }

        int ans = 0;
        for(int i=0;i<n;i++)
        {
            int val =  arr[i];

            int low = i+1;
            int high = n-1;

            // Binary search
            while (low<=high)
            {
                int mid  = low + (high-low)/2;

                if(val<=maxEnd[mid])
                {
                    ans = Math.max(mid - i,ans);
                    low = mid+1;
                }
                else
                {
                    high = mid -1;
                }
            }
        }

        return ans;
    }
    // TC: O(nlogn), SC:O(n)

    //Approach - 3: Finding greatest element from right and smallest element from left then traverser from left to right
    public static int maxIndexDiff3(int[] arr) {
        int n =  arr.length;
        int[] max = new int[n];
        max[n-1] = arr[n-1];

        for(int i=n-2;i>=0;i--)
        {
            max[i] = Math.max(max[i+1],arr[i]);
        }

        int[] min = new int[n];
        min[0] = arr[0];
        for(int i=1;i<n;i++)
        {
            min[i] = Math.min(arr[i],min[i-1]);
        }
        int i=0,j=0;
        int ans =0;
        while (i<n && j<n)
        {
            // Same thing we can do here with single only max array as well if(max[j] >= arr[i])
            if(min[i]<=max[j])
            {
                ans = Math.max(ans,j-i);
                j++;
            }
            else
            {
                i++;
            }
        }
        return ans;

    }
    //TC: O(n), SC: O(n)

    //Approach - 4: Using Stack
    public static int maxIndexDiff4(int[] arr) {

        Stack<Integer> st = new Stack<>();

        int n = arr.length;
        int ans =0;
        for(int i=0;i<n;i++)
        {
            if(st.isEmpty() || arr[st.peek()]>arr[i])
            {
                st.push(i);
            }
        }

        for(int j=n-1;j>=0;j--)
        {

            while (!st.isEmpty() && arr[st.peek()]<=arr[j])
            {
                ans = Math.max(ans,j-st.peek());
                st.pop();
            }
        }

        while (!st.isEmpty())
        {
            System.out.println(arr[st.pop()]);
        }


        return ans;
    }
    // TC: O(n), SC:(n)


    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6};
        int ans = maxIndexDiff4(arr);
        System.out.println(ans);
    }
}
