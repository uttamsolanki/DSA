/**
 * Problem: Given an array, check whether the array is in sorted order with recursion
 */

package com.recursion;

public class IsArraySorted {
    public static boolean IsArraySorted(int[] arr, int n) {
            if(n==1)
            {
                return true;
            }

            if(arr[n]<arr[n-1])
            {
                return false;
            }
        return IsArraySorted(arr,n-1);
    }
    // TC: O(n) and SC: O(n)

    public static void main(String[] args) {

        int[] arr = new int[]{1,2,3,9,4,5,6};
        boolean ans = IsArraySorted(arr,arr.length - 1);
        System.out.println(ans);
    }
}
