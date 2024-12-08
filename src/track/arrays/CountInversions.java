package track.arrays;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Problem: Given an array of integers arr[]. Find the Inversion Count in the array.
 * Two elements arr[i] and arr[j] form an inversion if arr[i] > arr[j] and i < j.
 * Link: https://www.geeksforgeeks.org/problems/inversion-of-array-1587115620/1
 */
public class CountInversions {

    // Solve using comparision, one by one
    public static int approach1(int arr[]) {

        int cnt = 0;
        int n = arr.length;
        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                if(arr[i]>arr[j])
                {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static int marge(int[] arr, int low, int high, int mid)
    {
        ArrayList<Integer> list = new ArrayList<>();
        int left = low;
        int right = mid+1;
        int cnt = 0;
        while (left<=mid && right<=high)
        {
            if(arr[left]<=arr[right])
            {
                list.add(arr[left++]);
            }
            else
            {
                list.add(arr[right++]);
                cnt+= (mid-left)+1;
                System.out.println((mid-left)+1);
            }
        }
        while (left<=mid)
        {
            list.add(arr[left++]);
        }
        while (right<=high)
        {
            list.add(arr[right++]);
        }
        int index = 0;
        for(int i=low;i<=high;i++)
        {
            arr[i] = list.get(index++);
        }
        return cnt;
    }
    public static int mergeSort(int[] arr, int low, int high)
    {
        int cnt = 0;
        if(low>=high) return cnt;

        int mid = low + (high-low)/2;

        cnt+=mergeSort(arr,low,mid);
        cnt+=mergeSort(arr,mid+1,high);
        cnt+=marge(arr,low,high,mid);
        return cnt;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 4, 1, 3, 5};
       int ans  = mergeSort(arr,0,arr.length-1);
       // int ans = approach1(arr);
        System.out.println(ans);
    }
}
