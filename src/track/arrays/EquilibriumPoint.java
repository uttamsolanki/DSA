package track.arrays;

import java.util.Arrays;

/**
 * Problem: Given an array arr of non-negative numbers. The task is to find the first equilibrium point in an array.
 * The equilibrium point in an array is an index (or position) such that the sum of all elements before that index is the same as the sum of elements after it.
 * Note: Return equilibrium point in 1-based indexing. Return -1 if no such point exists.
 * Link: https://www.geeksforgeeks.org/problems/equilibrium-point-1587115620/1
 */
public class EquilibriumPoint {

    //Using two for loop
    public static int approach1(int[] arr) {

        int n = arr.length;
        int leftSum = arr[0];
        for(int i=1;i<n-1;i++)
        {
            int rightSum = 0;
            for(int j=i+1;j<n;j++)
            {
                rightSum += arr[j];
            }
            if(leftSum==rightSum)
            {
                return i+1;
            }
            leftSum+=arr[i];

        }
        return -1;
    }

    //Using prefix sum
    public static int approach2(int[] arr)
    {
        int n = arr.length;

        for(int i=1;i<n;i++)
        {
            arr[i]+=arr[i-1];
        }

        for(int i=1;i<n-1;i++)
        {
            if(arr[i-1]==arr[n-1]-arr[i])
            {
                return  i+1;
            }
        }

        System.out.println(Arrays.toString(arr));
        return -1;
    }

    // Using two pointer, get sum from left side and right side
    public static int approach3(int[] arr)
    {
        int n = arr.length;
        int leftsum = arr[0];
        int rightSum = arr[n-1];
        int i=1;
        int j=n-2;

        while (i<=j)
        {
            if(leftsum==rightSum && j-i==0)
            {
                return i+1;
            }
            else if(leftsum<rightSum)
            {
                leftsum +=arr[i++];
            }else
            {
                rightSum +=arr[j--];
            }
        }


        return -1;
    }

    public static void main(String[] args) {
        int[] arr  = new int[]{0, 1, 0};
        int ans = approach3(arr);
        System.out.println(ans);
    }
}
