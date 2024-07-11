package com.arrays;

import java.util.ArrayList;

public class ReversePairs {

    public static void merge(int[] arr,int low, int mid,int high)
    {
        ArrayList<Integer> temp = new ArrayList<>();
        int left =low;
        int right = mid+1;

        while (left<=mid && right<=high )
        {

            if(arr[left]<=arr[right])
            {
                temp.add(arr[left]);
                left++;
            }else
            {
                temp.add(arr[right]);
                right++;
            }
        }

        while (left<=mid) {
            temp.add(arr[left]);
            left++;
        }

        while (right<=high) {
            temp.add(arr[right]);
            right++;
        }

        for(int i=low;i<=high;i++)
        {
            arr[i] = temp.get(i-low);
        }

    }
    public static int countPairs(int[] arr, int low , int mid, int high)
    {
        int cnt =0;
        int right = mid+1;
        for(int i=low;i<=mid;i++)
        {
            while (right<=high && arr[i]>2*arr[right]) right++;
            cnt += (right - (mid+1));
        }
        return cnt;
    }
    public static  int mergeSort(int[] arr, int left , int right)
    {
        int cnt =0;
        if(left>=right) return cnt;

        int mid  = left + (right-left)/2;
        cnt+=mergeSort(arr,left,mid);
        cnt+=mergeSort(arr,mid+1,right);
        cnt+=countPairs(arr,left,mid,right);
        merge(arr,left,mid,right);

        return cnt;

    }
    public static void solve(int[] arr)
    {
        int ans = mergeSort(arr,0,arr.length-1);
        System.out.println(ans);
    }
    public static void main(String[] args) {
        int[] arr = new int[]{
                1,3,2,3,1
        };
        solve(arr);
    }
}
