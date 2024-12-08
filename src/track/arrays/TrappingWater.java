package track.arrays;

import java.util.Arrays;

/**
 * Problem:  Given an array arr[] with non-negative integers representing the height of blocks. If the width of each block is 1,
 * compute how much water can be trapped between the blocks during the rainy season.
 * Link: https://www.geeksforgeeks.org/problems/trapping-rain-water-1587115621/1
 */
public class TrappingWater {
    // find out max value from right to left and left to right
    public static int approach1(int[] arr) {

        int  n =  arr.length;
        int[] leftMax = new int[n];
        int[] rightMax =  new int[n];
        leftMax[0]=arr[0];
        rightMax[n-1]=arr[n-1];
        for(int i=1;i<arr.length;i++)
        {
            leftMax[i] =  Math.max(leftMax[i-1],arr[i]);
        }
        for(int i=n-2;i>=0;i--)
        {
            rightMax[i] =  Math.max(rightMax[i+1],arr[i]);
        }

        int cnt = 0;
        for(int i=1;i<n-1;i++)
        {
            cnt += Math.min(leftMax[i],rightMax[i]) - arr[i];
        }
        System.out.println(Arrays.toString(leftMax));
        System.out.println(Arrays.toString(rightMax));

        return cnt;
    }

    public static void main(String[] args) {
        int[] arr =  new int[]{6, 9, 9};
        int ans = approach1(arr);
        System.out.println(ans);
    }
}
