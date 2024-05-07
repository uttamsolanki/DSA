package com.recursion;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MergeSort {

    //In- place
    public static void merge(int[] arr, int start, int mid,int end)
    {
            int i =start;
            int j = mid+1;

            while (i<=mid && j<=end)
            {
                if(arr[i]<=arr[j])
                {
                    i++;
                }
                else if(arr[i]>arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                    j++;
                }

            }
    }

    //Using extra Array
    public static void mergeArr(int[] arr, int start, int mid,int end)
    {
        int i =start;
        int j = mid+1;
        int[] temp = new int[end-start+1];
        int tempIndex = 0;
        while (i<=mid && j<=end)
        {
            if(arr[i]<=arr[j])
            {
                temp[tempIndex++] = arr[i];
                i++;
            }
            else if(arr[i]>arr[j]) {
                temp[tempIndex++] = arr[j];
                j++;
            }
        }
        while (i<=mid)
        {
            temp[tempIndex++] = arr[i];
            i++;
        }

        while (j<=end)
        {
            temp[tempIndex++] = arr[j];
            j++;
        }

        for(int k=start;k<=end;k++)
        {
            arr[k] =  temp[k-start];
        }
    }
    public static void partition(int[] arr, int start, int end)
    {
        if(start==end) return;
        int mid = (start +end)/2;
        partition(arr,start,mid);
        partition(arr,mid+1,end);
        mergeArr(arr,start,mid,end);

    }
    public static void mergeSort(int[] arr)
    {
        partition(arr,0,arr.length-1);
    }
    public static void main(String[] args) {
        int[] arr = new int[]{2,1,4,3,5,4,6};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
