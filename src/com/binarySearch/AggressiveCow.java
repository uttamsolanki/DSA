package com.binarySearch;

import java.util.Arrays;

public class AggressiveCow {

    public static boolean canWePlaceCow(int[] arr, int dist, int k)
    {
        // we have placed cow at first place
        int lastStall =  arr[0];
        int countStall = 1;
        for(int i=1;i<arr.length;i++)
        {
            if(arr[i]- lastStall >=dist)
            {
                countStall++;
                lastStall =  arr[i];
            }
            if(countStall >= k)
                    return true;
        }

        return false;

    }
    public static int approach1(int[] arr, int k) {

        //First sort the stalls
        Arrays.sort(arr);

        // Mini distance between stall where we can place cow;
        int min = 1;

        // Max distance between stall to place cow
        int max = Arrays.stream(arr).max().getAsInt() - Arrays.stream(arr).min().getAsInt();

        for(int i=min;i<=max;i++)
        {
            if(canWePlaceCow(arr,i,k))
            {
                return (i-1);
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{
                0,3,4,7,10,9
        };
        int k = 4;
        int ans = approach1(arr,k);
        System.out.println(ans);
    }
}
