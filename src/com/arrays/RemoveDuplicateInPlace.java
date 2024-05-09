package com.arrays;

import java.util.Arrays;

public class RemoveDuplicateInPlace {
    public static void main(String[] args) {
        int[] arr = new int[]{1,1,2,2,2,3,3};
        int j=1;
        for(int i = 1;i<arr.length;i++)
        {
            if(arr[i-1]!=arr[i])
            {
                arr[j] = arr[i];
                j++;
            }

        }
        System.out.println(Arrays.toString(arr));
    }
}
