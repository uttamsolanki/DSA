package track.arrays;

import java.util.Arrays;

/**
 * Problem link : https://www.geeksforgeeks.org/problems/chocolate-distribution-problem3825/1
 */
public class ChocolateDistribution {
    // Sort the array and keep m size window
    // find diff using first and last element of the window
    // store  in min variable
    public static int approach1(int[] arr, int m) {
        Arrays.sort(arr);

        int left =0;
        int right = m-1;
        int min =  arr[right] -  arr[left];
        while (right<arr.length)
        {
            min  = Math.min(min,arr[right++] -  arr[left++]);
        }

        return min;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 4, 1, 9, 56, 7, 9, 12};
        int ans = approach1(arr,5);
        System.out.println(ans);
    }
}
