package com.Sorting;

import java.util.Arrays;

public class QuickSort {


    public static  void swap(int[] nums, int i, int j)
    {
        int temp =  nums[i];
        nums[i] = nums[j];
        nums[j]= temp;
    }
    public static int partition(int[] nums, int start, int end)
    {
        int pivot = nums[start];
        int i = start;
        int j = end;

        while (i<j)
        {
            while (nums[i]<=pivot && i<end)
            {
                i++;
            }
            while (nums[j]>pivot && j>start)
            {
                j--;
            }
            if(i<j)
            swap(nums,i,j);
        }
        swap(nums,start,j);
        return j;
    }



    public static void sort(int[] nums,int low,int high)
    {
        if(low>high) return;
        //Pivot index
        int mid = partition(nums,low,high);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{13,48,24,52,20,9};
        int n = 6;
        sort(nums,0,n-1);
        System.out.println(Arrays.toString(nums));
    }
}
