package com.arrays;

import java.util.Arrays;

public class MoveZero {

    public static void approachTwo(int[] arr){

        int j = -1;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]==0)
            {
                j=i;
                break;
            }
        }
        if(j==-1)
        {
            return;
        }

        for(int i=j+1;i<arr.length;i++)
        {
            if(arr[i] != 0)
            {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
        }

        System.out.println(Arrays.toString(arr));
    }
    public static void approachOne(int[] arr)
    {
        int j=0;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i] != 0)
            {
                arr[j++]=arr[i];
            }
        }

        while (j<arr.length)
        {
            arr[j++] =0;
        }

        System.out.println(Arrays.toString(arr));
    }
    public static void main(String[] args) {
        int[] arr = new int[]{ 1 ,0 ,2 ,3 ,0 ,4 ,0 ,1};
        //approachOne(arr);
        approachTwo(arr);
    }
}
