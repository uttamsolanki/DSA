package com.arrays;

import java.util.Arrays;
import java.util.HashMap;

public class _2Sum {

    //Using 2 Pointer
    public static void approach2(int[] arr, int target, int n)
    {
        Arrays.sort(arr);
        int i=0,j=n-1;

        while (i<j && j<n)
        {
            int sum = arr[i] + arr[j];
            if( sum == target)
            {
                System.out.println("YES");
                break;
            }else if(sum > target){
                j--;
            }else{
                i++;
            }

        }

    }

    // Using Hashmap
    public static void approach1(int[] arr, int target, int n)
    {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[2];
        ans[0] = ans[1] = -1;
        for(int i=0;i<n;i++)
        {
            int sum =  arr[i];

            int rem = target - sum;
            if(map.containsKey(rem))
            {
                ans[0] = map.get(rem);
                ans[1] = i;
                break;
            }

            map.put(sum,i);
        }

        System.out.println(Arrays.toString(ans));
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,6,5,8,11};
        int target = 14;
        int n=5;
        approach2(arr,target,n);
    }
}
