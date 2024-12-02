package com.bitmanipulate;

import java.util.Arrays;

public class SingleNumber {

    //using sorting
    public static int Approach1(int[] arr) {
        Arrays.sort(arr);
        for(int i=1;i<arr.length;i+=2)
        {
            if(arr[i] !=arr[i-1])
            {
                return arr[i-1];
            }
        }
        return arr[arr.length-1];
    }
    public static int Approach2(int[] arr) {

        int xor  = 0;
        for(int i=0;i<arr.length;i++)
        {
            xor^=arr[i];
        }
        return xor;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4,1,2,1,2};
        int ans = Approach2(arr);
        System.out.println(ans);
    }
}
