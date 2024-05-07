package com.arrays;

public class LargestElement {

    public static void main(String[] args) {
        int  n = 5;
        int[] arr =new int[]{1, 2, 3, 4, 5};

        int max = -1;
        for(int i=0;i<arr.length;i++){
            max = Math.max(max,arr[i]);
        }
        System.out.println(max);
    }
}
