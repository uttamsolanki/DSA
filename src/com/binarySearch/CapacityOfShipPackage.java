package com.binarySearch;

public class CapacityOfShipPackage {

    public static  int findDays(int capacity, int[] arr)
    {
        int days =1;
        int load =0;
        for(int i=0;i<arr.length;i++)
        {
            if(load+arr[i]>capacity)
            {
               days++;
               load = arr[i];
            }
            else
            {
                load+=arr[i];
            }

        }
        return days;
    }
    public static int approach1(int[] arr, int d) {

        int sum = 0;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++)
        {
            sum += arr[i];
            max = Math.max(max,arr[i]);
        }

        int low = max;
        int high = sum;

        while (low<=high)
        {
            int cap = low + (high - low) / 2;
            int days = findDays(cap,arr);

            if(days<=d)
            {
                high =  cap - 1;
            }else
            {
                low = cap + 1;
            }
        }



        return low;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{
                5,4,5,2,3,4,5,6
        };
        int d = 5;
        int ans = approach1(arr,d);
        System.out.println(ans);
    }
}
