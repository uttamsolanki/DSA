package com.Sorting;

import java.util.Arrays;

public class BubbleSort {

    public static  void swap(int[] nums, int i, int j)
    {
        int temp =  nums[i];
        nums[i] = nums[j];
        nums[j]= temp;
    }


    public static void sort(int[] nums,int n)
    {
        for(int i=n-1;i>=0;i--)
        {
            for(int j=1;j<=i;j++)
            {
                if(nums[j-1]>nums[j])
                {
                    swap(nums,j,j-1);
                }
            }
        }
    }


    public static void recursiveSort(int[] nums, int n){

        if(n==1) return;

        for(int j=1;j<n;j++)
        {
            if(nums[j-1]>nums[j])
            {
                swap(nums,j-1,j);
            }
        }
        recursiveSort(nums,n-1);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{13,48,24,52,20,9};
        int n = 6;
        //sort(nums,n);
        recursiveSort(nums,n);
        System.out.println(Arrays.toString(nums));
    }
}
