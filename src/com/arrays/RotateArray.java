package com.arrays;

import java.util.Arrays;

public class RotateArray {

    public static void reverse(int[] arr,int i, int j)
    {
        while (i<j)
        {
            int tem =  arr[i];
            arr[i] = arr[j];
            arr[j] = tem;
            i++;
            j--;
        }
    }
    public static void rotatedByK(int[] arr, int n, int k)
    {
        if(n==0)
        {
            return;
        }

        k = k%n;

        if(k>n) {
            return;
        }

        //Left rotation
//        reverse(arr,0,k);
//        reverse(arr,k+1,n-1);
//        reverse(arr,0, n-1);

       // right rotation
        reverse(arr,0,n-k-1);
        reverse(arr,k+1,n-1);
        reverse(arr,0, n-1);
    }
    public static void rotatedByOne(int[] arr,int n){

        int first = arr[0];
        for(int i=0;i<n-1;i++){
            arr[i] = arr[i+1];
        }
        arr[n-1] = first;
    }
    public static void main(String[] args) {
        int n =5;
        int[] arr = new int[]{1,2,3,4,5};
        //rotatedByOne(arr,n);
        rotatedByK(arr,n,2);
        System.out.println(Arrays.toString(arr));
    }
}
