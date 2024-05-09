package com.arrays;

public class CheckIfArraysSorted {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,8,7,7};

        boolean sorted= true;


        for(int i=0;i<arr.length-1;i++)
        {
            if(arr[i]>arr[i+1])
            {
                sorted = false;
                break;
            }
        }

        System.out.println(sorted);
    }
}
