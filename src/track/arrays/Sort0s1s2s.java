package track.arrays;

import java.util.Arrays;

/**
 * Problem: Given an array arr[] containing only 0s, 1s, and 2s. Sort the array in ascending order.
 * Link:https://www.geeksforgeeks.org/problems/sort-an-array-of-0s-1s-and-2s4231/1
 */
public class Sort0s1s2s {

    // Count each 0,1 and 2 then fill array
    public static void approach1(int[] arr) {
        int cnt0 = 0;
        int cnt1 = 0;
        int cnt2 = 0;

        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]==0)
            {
                cnt0++;
            }
            else if(arr[i]==1)
            {
                cnt1++;
            }
            else if(arr[i]==2)
            {
                cnt2++;
            }
        }

        for(int i=0;i<cnt0;i++)
        {
            arr[i]=0;
        }
        for(int i=cnt0;i<cnt0+cnt1;i++)
        {
            arr[i]=1;
        }
        for (int i=cnt0+cnt1;i<arr.length;i++)
        {
            arr[i]=2;
        }
    }

    //Using 3 points
    public static void approach2(int[] arr) {

        int left = 0;
        int right=arr.length-1;
        int mid =0;
        while (mid<=right)
        {
            if(arr[mid]==0)
            {
                swap(arr,left,mid);
                left++;
                mid++;
            }
            else if(arr[mid]==1)
            {
                mid++;
            }
            else
            {
                swap(arr,mid,right);
                right--;
            }
        }


    }
    public static void swap(int[] arr, int i , int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{1,0,2};
        approach2(arr);
        System.out.println(Arrays.toString(arr));
    }
}
