package com.arrays;

import java.util.HashMap;

public class LongestSubarrayWithSumK {


    // This solution only for positive values
    public static void approach3(int[] arr, int k, int n)
    {
        int start =0, end=0;

        int sum = 0;
        int len = 0;
        while (start<=end && end<n)
        {
            sum += arr[end];

            if(sum==k)
            {
                len = Math.max(len,end-start+1);
            }else if(sum>k)
            {
                sum -= arr[start];
                start++;
            }
            end++;
        }
        System.out.println(len);
    }
    // Using prefix
    // This will work for both positive and negative
    public  static void approach2(int[] arr, int k, int n)
    {
        HashMap<Integer,Integer> map = new HashMap<>();

        int sum = 0;
        int len = 0;

        for(int i=0;i<n;i++)
        {
            sum += arr[i];


            if(sum == k)
            {
                len = Math.max(len,i+1);
            }
            int rem = sum-k;
            if(map.containsKey(rem))
            {
                len = Math.max(len, i-map.get(rem));
            }
            // [2,0,0,0,3] => This will not work if we update index for existing sum
            if(!map.containsKey(sum))
            {
                map.put(sum,i);
            }

        }
        System.out.println(len);
    }
    public static void approach1(int[] arr, int k, int n)
    {
        int sum = 0;
        int len = 0;
        for(int i=0;i<n;i++)
        {
            sum = 0;
            for(int j=i;j<n;j++)
            {
                sum += arr[j];
                if(sum==k)
                {
                    len =  Math.max(len,j-i+1);
                    break;
                }
            }
        }
        System.out.println(len);
    }
    public static void main(String[] args) {
       int[] arr = new int[]{1,2,3,1,1,1,1,3,3};
       int n = 9;
       int k = 6;
        approach3(arr,k,n);
    }
}
