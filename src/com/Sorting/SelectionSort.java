package com.Sorting;

import java.util.Arrays;

public class SelectionSort {

    public static  void swap(int[] nums, int i, int j)
    {
            int temp =  nums[i];
            nums[i] = nums[j];
            nums[j]= temp;
    }
    public static void sort(int[] nums,int n)
    {
        for(int i=0;i<n;i++)
        {
            int min = i;
            for(int j=i+1;j<n;j++)
            {
                if(nums[j]<nums[min])
                {
                    min = j;
                }
            }

            swap(nums,i,min);
        }
    }

    public static void recursiveSort(int[] nums, int i){

        if(i>=nums.length)
        {
            return;
        }
        int min = i;
        for(int j=i+1;j<nums.length;j++)
        {
            if(nums[j]<nums[min])
            {
                min = j;
            }
        }

        swap(nums,i,min);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{13,48,24,52,20,9};
        int n = 6;
        //sort(nums,n);
        recursiveSort(nums,0);
        System.out.println(Arrays.toString(nums));
    }
}
