package com.binarySearch;

public class SmallestDivisor {

    public static  int getDivisorSum(int divisor,int[] arr)
    {
        int totalSum = 0;

        for(int i=0;i<arr.length;i++)
        {
            totalSum+= Math.ceil((double) arr[i]/(double) divisor);
        }
        return totalSum;

    }
    public static int approach1(int[] arr, int limits) {

        int max = Integer.MIN_VALUE;

        for(int i=0;i<arr.length;i++)
        {
            max = Math.max(max,arr[i]);
        }

        for(int i=1;i<=max;i++)
        {
            int totalSum =  getDivisorSum(i,arr);
            if(totalSum<=limits)
            {
                return i;
            }
        }
        return -1;
    }

    public static int approach2(int[] arr, int limits) {

        int max = Integer.MIN_VALUE;

        for(int i=0;i<arr.length;i++)
        {
            max = Math.max(max,arr[i]);
        }

        int low = 1;
        int high = max;

        while (low<=high)
        {
            int mid = low + (high - low) / 2;
            int totalSum =  getDivisorSum(mid,arr);
            if(totalSum<=limits)
            {
                high = mid - 1;
            }
            else
            {
                low = mid + 1;
            }
        }

        return low;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{
                1,2,3,4,5
        };
        int limits = 8;
        int ans = approach2(arr, limits);
        System.out.println(ans);
    }
}
