package com.arrays;

import java.util.HashMap;
import java.util.HashSet;

public class LargestSubArraywithSumZero {

    public static int Approach1(int[] arr)
    {
        int n =  arr.length;
        int ans = 0;
        for(int i=0;i<n;i++)
        {
            int sum=0;
            for(int j=i;j<n;j++)
            {
                sum += arr[j];
                if(sum==0)
                {
                    ans = Math.max(ans,j-i+1);
                }
            }
        }
        return ans;
    }

    //Using prefix
    public static int Approach2(int[] arr)
    {
        int ans=0;

        HashMap<Integer,Integer> map = new HashMap<>();

        int prefix = 0;
        for(int i=0;i<arr.length;i++)
        {
            prefix += arr[i];
            if(prefix==0)
            {
                ans=i+1;
            }
            else
            {
                if(map.containsKey(prefix))
                {
                    ans =  Math.max(ans,i-map.get(prefix)+1);
                }else {
                    map.put(prefix,i);
                }

            }

        }

        return ans;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{
                6, -2, 2, -8, 1, 7, 4, -10
        };
        int ans = Approach2(arr);
        System.out.println(ans);
    }
}
