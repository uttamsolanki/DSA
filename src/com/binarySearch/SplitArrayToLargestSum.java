package com.binarySearch;

public class SplitArrayToLargestSum {
    public static int getNumberOfArray(int[] arr, int sum)
    {
        int arrCount = 1;
        int currSum = 0;

        for (int i=0;i<arr.length;i++)
        {
            if(currSum + arr[i]<=sum)
            {
                currSum+=arr[i];
            }else
            {
                arrCount++;
                currSum = arr[i];
            }
        }
        return arrCount;
    }
    public static int approach1(int[] arr, int k) {
        int max = 0;
        int sum = 0;

        for(int i=0;i<arr.length;i++)
        {
            max = Math.max(max,arr[i]);
            sum += arr[i];
        }

        int low = max;
        int high = sum;

        while (low<=high)
        {
            int mid = low + (high - low)/2;
            int arrCount = getNumberOfArray(arr,mid);
            if(arrCount<=k)
            {
                high = mid - 1;
            }
            else
            {
                low = mid +1;
            }
        }

        return low;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{
                5, 5, 5, 5
        };
        int k = 2;
        int ans = approach1(arr,k);
        System.out.println(ans);
    }
}
