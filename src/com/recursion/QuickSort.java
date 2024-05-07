package com.recursion;

import java.util.Arrays;

public class QuickSort {

    public  static int partition(int[] arr, int start, int end){
        int i =start;
        int j =end;
        int pivot = arr[start];
        while (i<j)
        {
            while (i<end && arr[i]<=pivot)
            {
                i++;
            }
            while (j>start && arr[j]>pivot)
            {
                j--;
            }
            if(i<j)
            {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] =temp;
            }
        }
        int temp = arr[start];
        arr[start] = arr[j];
        arr[j] =temp;
        return j;
    }
    public static void quickSort(int[] arr, int start, int end)
    {
        int[] cparr = Arrays.copyOfRange(arr,start,end+1);
        System.out.println(Arrays.toString(cparr));
        // We will sort if array has more than one element
       if(start<end)
       {
           int pivotIndex = partition(arr,start,end);
           quickSort(arr,start,pivotIndex-1);
           quickSort(arr,pivotIndex+1,end);
       }
    }
    public static void main(String[] args) {
        int[] arr = new int[]{ 4,6,2,5,7,9,1,3};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
