package com.binarySearch;

public class KthMissingNumber {
    public static int approach1(int[] arr, int k) {

        int low = 0;
        int high = arr.length;

        while (low<=high)
        {
            int mid = low + (high - low)/2;

            int missingNos = arr[mid] -  (mid+1);
            if(missingNos<=k)
            {
                low = mid + 1;
            }
            else
            {
                high = mid - 1;
            }
        }


        return k + high + 1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]
                {
                        4,7,9,10
                };
        int k=4;
        int ans = approach1(arr,k);
        System.out.println(ans);
    }
}
