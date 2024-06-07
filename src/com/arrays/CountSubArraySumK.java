package com.arrays;

import java.util.HashMap;

public class CountSubArraySumK {

    public static void solution2(int[] arr, int k)
    {
        int n = arr.length;
        int cnt =0;
        int preSum = 0;
        HashMap<Integer,Integer> hm = new HashMap<>();

        hm.put(0,1);

        for(int i=0;i<n;i++)
        {
            preSum +=arr[i];

            int remove =  preSum - k;

            cnt +=  hm.getOrDefault(remove,0);

            hm.put(preSum, hm.getOrDefault(preSum,0)+1);
        }

        System.out.println(cnt);
    }

    public static void solution1(int[] arr, int k)
    {
        int n = arr.length;
        int cnt =0;
        for(int i=0;i<n;i++)
        {
            int sum = 0;
            for(int j=i;j<n;j++)
            {
                sum += arr[j];
                if(sum==k)
                {
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }
    public static void main(String[] args) {
        int[] arr = new int[]{3,1,2,4};
        int k=6;

        solution2(arr,k);
    }
}
