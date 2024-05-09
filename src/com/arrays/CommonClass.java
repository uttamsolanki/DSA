package com.arrays;

public class CommonClass {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 0, 1, 1, 1};

        int count =0;
        int max = Integer.MIN_VALUE;

        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]==1){
                count++;
            }else
            {
                max = Math.max(count,max);
                count =0;
            }
        }
        max = Math.max(count,max);

        System.out.println(max);
    }
}
