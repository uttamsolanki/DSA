package com.binarySearch;

public class UpperBound {
    // Iterative approach
    public static int Approach1(int x, int[] arr)
    {
        for(int i=0;i<arr.length;i++)
        {
            if(x<=arr[i])
            {
                return i;
            }
        }
        return -1;
    }

    // Using Binary search
    public static int Approach2(int x, int[] arr)
    {
        int n = arr.length -1;
        int ans = n;

        int low = 0;
        int high = n;

        while (low<=high)
        {
            int mid =  (low + high)/2;

            if(x<arr[mid])
            {
                ans = mid;
                high = mid -1;
            }
            else
            {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{
                1,2,3,4,5,6,7,9,10
        };

        int x = 7;

        int ans =  Approach2(x, arr);
        System.out.println(ans);
    }
}
