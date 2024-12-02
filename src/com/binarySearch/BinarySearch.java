package com.binarySearch;

public class BinarySearch {


    // Iterative approach
    public static int Approach1(int x, int[] arr)
    {
        int n = arr.length;

        int low= 0;
        int high  = n-1;

        while(low<=high)
        {
            int mid = (low + high)/2;

            if(arr[mid]== x)
            {
                return mid;
            }
            else if(x>arr[mid])
            {
                low = mid +1;
            }else
            {
                high = mid -1;
            }
        }
        return -1;
    }


    public static int solve(int low, int high, int x, int[] arr)
    {
        if(low>high) return -1;

        int mid =  (low + high)/2;
        if(arr[mid]==x)
        {
            return mid;
        }else if(x > arr[mid])
        {
            return solve(mid+1,high,x,arr);
        }
        return solve(low,mid-1,x,arr);
    }
    // Recursive Approach
    public static int Approach2(int x, int[] arr)
    {
        return solve(0,arr.length-1,x,arr);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{
                1,2,3,4,5,6,7,9,10
        };

        int x = 6;

        int ans =  Approach2(x, arr);
        System.out.println(ans);
    }
}
