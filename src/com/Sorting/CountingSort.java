package com.Sorting;

import java.util.Arrays;

public class CountingSort {

    public static void countSort(int[] arr)
    {
        // 1. Get min and max
        int min = Arrays.stream(arr).min().getAsInt();
        int max = Arrays.stream(arr).max().getAsInt();

        // 2. Get range array
        int k = max - min;
        int[] count = new int[k+1];

        // 3. Get Frequency count
        for(int i=0;i<arr.length;i++)
        {
            count[arr[i]-min] += 1;
        }

        // 3. Get cumulative sum
        for(int i=1;i<k+1;i++)
        {
            count[i]+=count[i-1];
        }

        // 4. Start reading original array from right

        int[] sortedArray = new int[arr.length];
        for(int i=arr.length-1;i>=0;i--)
        {
            int element = arr[i];
            // check position of 'element'
            int pos = count[element-min];// get element in range of (min - max)

            // Place item in sorted array, -1 because array would be 0-index but our prefix sum is 1-index base
            sortedArray[pos-1] = element;

            // Decrease frequency count as we already place that items from unsorted to sorted array
            count[element-min]--;
        }

        // Sorted value to original
        for(int i=0;i<arr.length;i++)
        {
            arr[i]=sortedArray[i];
        }
    }
    public static void main(String[] args) {
      int[] arr = new int[]{-5,-5,2,3,-1};
      countSort(arr);
      System.out.println(Arrays.toString(arr));
    }
}
