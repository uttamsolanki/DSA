package com.recursion;

import java.util.Arrays;

public class ReverseArray {

    public static void reverse2(int[] arr, int i)
    {
        int n = arr.length;
        int j =  n-i-1;
        if(i>j) return;
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
        reverse2(arr,i+1);
    }
    public static void reverse(int[] arr, int i,int j)
    {
        if(i>j) return;
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
        reverse(arr,i+1,j-1);
    }
    public static void main(String[] args) {
        int[]  arr = new int[]{1,2,3,4,2};
        reverse2(arr,0);
        System.out.println(Arrays.toString(arr));
    }
}
