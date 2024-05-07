package com.Sorting;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeSort {

    public static void swap(int[] nums, int i , int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public static void merge(int[] nums, int start, int mid, int end)
    {
        ArrayList<Integer> temp = new ArrayList<>();
        int left = start;
        int right = mid+1;
        while (left<=mid && right<=end){

            if(nums[left]<=nums[right])
            {
                temp.add(nums[left++]);
            }else{
                temp.add(nums[right++]);
            }
        }

        while (left<=mid)
        {
            temp.add(nums[left++]);
        }

        while (right<=end){
            temp.add(nums[right++]);
        }

        for(int i=0;i<temp.size();i++)
        {
            nums[start+i] = temp.get(i);
        }

    }
    public static  void divide(int[] nums, int start, int end)
    {
        if(start<end)
        {
            int mid=  (start+end)/2;
            divide(nums,start,mid);
            divide(nums,mid+1,end);
            merge(nums,start,mid,end);
        }
    }

    public static void sort(int[] nums,int n)
    {
        divide(nums, 0, n-1);
    }
    public static void main(String[] args) {
        int[] nums = new int[]{13,48,24,52,20,9};
        int n = 6;
        sort(nums,n);
        System.out.println(Arrays.toString(nums));
    }
}
