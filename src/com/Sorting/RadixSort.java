package com.Sorting;

import java.util.Arrays;

public class RadixSort {



    // We required 0-9 value for sorting as we gonna use LSD to sort
    public static int NUMS_DIGIT = 10;
    public static void countSort(int[] arr, int place)
    {
        int[] count = new int[NUMS_DIGIT];

        for(int i=0;i<arr.length;i++)
        {
            int elm =  arr[i] / place;
            count[elm%NUMS_DIGIT] += 1;
        }
        for(int i=1;i<NUMS_DIGIT;i++)
        {
            count[i]+=count[i-1];
        }

        int[] sortedArray =  new int[arr.length];

        for(int i=arr.length-1;i>=0;i--)
        {
            int ele =  arr[i] / place;
            int pos = count[ele%NUMS_DIGIT]--;
            sortedArray[pos-1] = arr[i];
        }

        for(int i=0;i<arr.length;i++)
        {
            arr[i] = sortedArray[i];
        }


    }

    public static void radixSort(int[] arr)
    {
        int max = arr[0];

        for(int i=0;i<arr.length;i++)
        {
            max = Math.max(max,arr[i]);
        }

        int place =1;
        while (max >0)
        {
            max /=10;
            countSort(arr,place);
            place*=10;
        }

    }
    public static void main(String[] args) {
        int[] arr = new int[]{831, 443, 256,254 ,336, 736, 907};
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
