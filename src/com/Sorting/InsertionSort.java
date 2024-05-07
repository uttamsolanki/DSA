package com.Sorting;

import java.util.Arrays;

public class InsertionSort {

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
            int j=i;
            while (j>0 && nums[j]<nums[j-1])
            {
                swap(nums,j,j-1);
                j--;
            }

        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{13,48,24,52,20,9};
        int n = 6;
        sort(nums,n);
        System.out.println(Arrays.toString(nums));
    }
}
