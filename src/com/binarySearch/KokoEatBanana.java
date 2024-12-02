package com.binarySearch;

public class KokoEatBanana {

    public static int calculateTotalHours(int k, int[] arr)
    {
        int totalhr = 0;
        for(int i=0;i<arr.length;i++)
        {
            // This is IMP
            totalhr += Math.ceil((double)(arr[i]) / (double)(k));
        }
        return totalhr;
    }
    //Approach 1 - brute force
    public static int Approach1(int[] arr, int h)
    {
        int max = 0;
        for(int i=0;i<arr.length;i++)
        {
            max =  Math.max(max,arr[i]);
        }


        for(int i=1;i<=max;i++)
        {
            int total = calculateTotalHours(i,arr);
            if(total<=h)
            {
               return i;
            }
        }
        return max;
    }

    //Approach 2 - Binary Search
    public static int Approach2(int[] arr, int h)
    {
        int max = 0;
        for(int i=0;i<arr.length;i++)
        {
            max =  Math.max(max,arr[i]);
        }

        int low = 1;
        int high = max;

        while (low <= high)
        {
            int mid =  low + (high - low)/2;
            int total = calculateTotalHours(mid,arr);

            if(total<=h)
            {
                high = mid - 1;
            }else
            {
                low =  mid + 1;
            }
        }

        return low;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{
                7, 15, 6, 3
        };
        int h = 8;
        int ans =  Approach2(arr,h);
        System.out.println(ans);
    }
}
