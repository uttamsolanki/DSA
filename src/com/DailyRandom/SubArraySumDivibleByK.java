package com.DailyRandom;

import java.util.HashMap;

public class SubArraySumDivibleByK {

    public static int Solve(int[] nums, int k)
    {

        int n = nums.length;
        int prefixSum = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        int cnt =0;
        map.put(0,1);
        for(int i=0;i<n;i++)
        {
            prefixSum +=  (nums[i]%k) + k;

            prefixSum =  prefixSum % k;

            if(map.containsKey(prefixSum))
            {
                cnt+= map.get(prefixSum);
            }
            map.put(prefixSum,map.getOrDefault(prefixSum,0)+1);

            //System.out.println(rem);
        }

        return  cnt;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{4,5,0,-2,-3,1};
        int k=5;
        int ans = Solve(nums,k);
        System.out.println(ans);
    }
}
