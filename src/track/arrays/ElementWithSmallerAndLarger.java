package track.arrays;

import java.util.Arrays;

/**
 * Problem: Given an unsorted array of arr. Find the first element in an array such that all of its left elements are smaller and all right elements of its are greater than it.
 * Note: Return -1 if there is no such element.
 * Link: https://www.geeksforgeeks.org/problems/unsorted-array4925/1
 */
public class ElementWithSmallerAndLarger {
    public static int approach1(int[] arr) {
        int n = arr.length;

        int[] leftMax = new int[n];
        int[] rightMin = new int[n];
        leftMax[0] = arr[0];
        rightMin[n-1] = arr[n-1];

        for(int i=1;i<n;i++)
        {
            leftMax[i] = Math.max(leftMax[i-1],arr[i]);
        }

        for(int i=n-2;i>=0;i--)
        {
            rightMin[i] = Math.min(rightMin[i+1],arr[i]);
        }

        boolean isGreater = true;
        int ans = -1;
        for(int i=n-2;i>0;i--)
        {
            if(leftMax[i-1]<arr[i] && (arr[i]<=rightMin[i]))
            {
                if(isGreater==false)
                {
                    return -1;
                }
                ans = arr[i];
            }
        }

        return ans;
    }

    public static void main(String[] args) {
      //  int[] arr = new int[]{73,84,29,100,97,98,98,50,61,37};
        int[] arr = new int[]{4, 2, 5, 7};
        int ans = approach1(arr);
        System.out.println(ans);
    }
}
