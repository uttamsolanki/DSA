package com.arrays;

import java.util.Arrays;

public class NextPermutation {


    public static void sort(int[] nums, int i, int j)
    {
        while (i<j)
        {
            int temp = nums[i];
            nums[i] =  nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }

    public static void swap(int[] nums, int i , int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] =temp;
    }
    public static void solution1(int[] nums)
    {
        int n=nums.length;
        int lastIndex = -1;
        for(int i=n-1;i>0;i--)
        {
            if(nums[i-1]<nums[i])
            {
                lastIndex = i;
                break;
            }
        }

        if(lastIndex==-1)
        {
            sort(nums,0,n-1);
        }else
        {
            // Search element between index and index -1 from range index to n
            int index = lastIndex;
            for(int i=lastIndex;i<n;i++)
            {
                if(nums[i]>nums[lastIndex-1] && nums[lastIndex-1]<nums[i])
                {
                    index = i;
                }
            }

            swap(nums,index,lastIndex-1);
            sort(nums,lastIndex, n-1);
        }

        System.out.println(Arrays.toString(nums));

    }
    public static void main(String[] args) {
        int[] nums = new int[]{1,3,2};

        solution1(nums);
    }
}
