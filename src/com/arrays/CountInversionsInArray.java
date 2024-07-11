package com.arrays;

import java.util.ArrayList;

public class CountInversionsInArray {
    public static void Approach1(int[] arr)
    {
        int n = arr.length;
        int cnt =0;
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

        System.out.println(cnt);
    }


    public static int merge(int[] arr,int low, int mid,int high)
    {
        ArrayList<Integer> temp = new ArrayList<>();
        int left =low;
        int right = mid+1;
        int cnt = 0;
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
                cnt += (mid-left)+1;
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

        return cnt;
    }
    public static  int mergeSort(int[] arr, int left , int right)
    {
        int cnt =0;
        if(left>=right) return cnt;

        int mid  = left + (right-left)/2;
        cnt+=mergeSort(arr,left,mid);
        cnt+=mergeSort(arr,mid+1,right);
        cnt+=merge(arr,left,mid,right);

        return cnt;

    }
    public static void Approach2(int[] arr)
    {
       int ans = mergeSort(arr,0,arr.length-1);
        System.out.println(ans);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5,4,3,2,1};
        Approach2(arr);
    }
}
