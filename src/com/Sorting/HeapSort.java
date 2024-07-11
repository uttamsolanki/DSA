package com.Sorting;

import java.util.Arrays;

public class HeapSort {


    public static void swap(int[] arr, int i , int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void heapify(int[] arr, int size, int index)
    {
        int left = 2*index + 1;
        int right = 2*index + 2;
        int largestIndex = index;

        if(left<size && arr[left]> arr[largestIndex])
        {
            largestIndex = left;
        }

        if(right < size && arr[right] > arr[largestIndex])
        {
            largestIndex = right;
        }
        if(largestIndex!=index)
        {
            swap(arr, index,largestIndex);
            heapify(arr, size,largestIndex);
        }

    }

    public static void main(String[] args) {

        int[] arr = new int[]{2,3,1,5,9,7};

        // we can find parent of any child using floor(childIndex/2)
        for(int i = arr.length -1; i>=0;i--)
        {
            heapify(arr,arr.length,i);
        }

        //HeapSort
        for(int i=arr.length-1;i>0;i--)
        {
            swap(arr,0,i);
            heapify(arr,i,0);
        }
        System.out.println(Arrays.toString(arr));
    }
}
