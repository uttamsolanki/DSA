package com.arrays;

import java.util.Arrays;

public class SortArrayZeroOneTwo {

    public static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Using Dutch National Flag Algorithm
    public static void approach2(int[] arr)
    {
        int low=0,mid=0,high=arr.length-1;
        while (mid<=high)
        {
            if(arr[mid]==0)
            {
                swap(arr,low,mid);
                low++;
                mid++;
            }
            else if(arr[mid]==1)
            {
                mid++;
            }else if(arr[mid]==2)
            {
                swap(arr,mid,high);
                high--;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
    public static void approach1(int[] arr)
    {
        int count_0 = 0;
        int count_1 = 0;

        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]==0)
            {
                count_0++ ;
            }else if(arr[i]==1)
            {
                count_1++;
            }
        }

        for (int j=0;j<count_0;j++)
        {
            arr[j] = 0;
        }

        for (int j=count_0;j<count_0+count_1;j++)
        {
            arr[j] = 1;
        }

        for (int j=count_0+count_1;j<arr.length;j++)
        {
            arr[j] = 2;
        }

        System.out.println(Arrays.toString(arr));

    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,0,2,1,1,0};
        //approach1(arr);
        approach2(arr);
    }
}
