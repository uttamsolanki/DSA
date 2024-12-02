package com.binarySearch;

public class MinimumInRotateArray {
    public static int solve(int[] arr)
    {
        int low = 0;
        int high =  arr.length - 1;
        int ans =  Integer.MIN_VALUE;
        while (low<=high)
        {
            int mid = (low + high)/2;

            if(arr[low]<=arr[mid])
            {
                ans =  Math.max(ans,arr[low]);
                low = mid +1;
            }else
            {
                ans =  Math.max(ans,arr[mid]);
                high =  mid - 1;
            }
        }

        return ans;
    }
    public static void main(String[] args) {
        int [] arr =  new int[]
                {
                        4,5,6,7,0,1,2,3
                };

        int ans  =  solve(arr);
        System.out.println(ans);
    }
}
