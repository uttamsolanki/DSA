package com.binarySearch;

public class MinDaytoMakeMbouquet {


    public static int approach1(int[] arr, int m, int k)
    {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;


        for(int i=0;i<arr.length;i++)
        {
            max = Math.max(max,arr[i]);
            min = Math.min(min,arr[i]);
        }


        for(int day = min; day<=max;day++)
        {
            int cnt = 0;
            int ans = 0;
            for(int i=0;i<arr.length;i++)
            {
                if(arr[i]<=day)
                {
                    cnt++;
                }else
                {
                    ans += (cnt/k);
                    cnt = 0;
                }
            }
            ans += (cnt/k);
            if(ans>=m)
            {
                return day;
            }
        }


        return -1;
    }

    public static  int approach2(int[] arr, int m, int k)
    {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;


        if(m*k>arr.length) return -1;

        for(int i=0;i<arr.length;i++)
        {
            max = Math.max(max,arr[i]);
            min = Math.min(min,arr[i]);
        }


        int low = min;
        int high = max;
        while (low<=high)
        {
            int cnt = 0;
            int ans = 0;
            int day = low + (high - low)/2;
            for(int i=0;i<arr.length;i++)
            {
                if(arr[i]<=day)
                {
                    cnt++;
                }else
                {
                    ans += (cnt/k);
                    cnt = 0;
                }
            }
            ans += (cnt/k);
            if(ans>=m)
            {
                high = day -1;
            }
            else
            {
                low = day + 1;
            }
        }


        return low;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{
                7,7,7,7,13,11,12,7
        };
        int k = 3;
        int m = 2;

        int ans = approach2(arr, m, k);
        System.out.println(ans);
    }
}
