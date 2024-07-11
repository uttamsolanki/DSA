package com.arrays;

import java.util.Arrays;

public class MergeTwoSortedArraysWithoutExtraSpace {

    public static void swap(int[] arr1, int[] arr2,int i,int j)
    {
        int temp = arr1[i];
        arr1[i] = arr2[j];
        arr2[j] = temp;
    }
    public static void Approach1(int[] arr1, int[] arr2)
    {
        int n = arr1.length;
        int m = arr2.length;

        int[] arr = new int[m+n];
        int j =0;
        int k=0;
        for(int i=0;i<m+n;i++)
        {
            if(j>=n || k>=m)
            {
                if(j<n)
                {
                    arr[i] = arr1[j++];
                }else if(k<m)
                {
                    arr[i] = arr1[k++];
                }
            }
            else if(arr1[j]<=arr2[k])
            {
                arr[i] = arr1[j++];
            }else
            {
                arr[i] = arr2[k++];
            }
        }

        System.out.println(Arrays.toString(arr));
    }

    public static void Approach2(int[] arr1, int[] arr2)
    {
        int p1 = arr1.length-1;
        int p2 = 0;

        int n =  arr1.length;
        int m = arr2.length;
        while (p1>=0 && p2<m)
        {
            if(arr1[p1]>arr2[p2])
            {
                swap(arr1,arr2,p1,p2);
                p1--;
                p2++;
            }
            else
            {
                break;
            }

        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }

    public static void swqpIfGreater(int[] arr1, int[] arr2, int index1, int index2)
    {
        if(arr1[index1]>arr2[index2])
        {
            int temp =  arr1[index1];
            arr1[index1] = arr2[index2];
            arr2[index2] = temp;
        }
    }

    public static void Approach3(int[] arr1, int[] arr2)
    {
        int n = arr1.length;
        int m =  arr2.length;
        int len = n + m;

        int gap =  (len/2) + (len%2);

        while (gap>0)
        {
            int left = 0;
            int right = left + gap;

            while (right<len)
            {
                // One pointer on Arr1 and another pointer on Arr2
                if(left<n && right>=n)
                {
                    swqpIfGreater(arr1,arr2,left,right-n);
                }
                // Both pointers are on Arr1
                else if(left<n && right<n)
                {
                    swqpIfGreater(arr1,arr1,left,right);
                }
                //both pointers are on Arr2
                else {
                    swqpIfGreater(arr2,arr2,left-n,right-n);
                }
                left++;
                right++;
            }

            if(gap==1)
            {
                break;
            }
            else
            {
                gap = (gap/2) + (gap%2);
            }
        }
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{1,4,8,10};
        int[] arr2 = new int[]{2,3,9};

        Approach3(arr1,arr2);
    }
}
