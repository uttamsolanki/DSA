package com.dp;

import java.util.Arrays;

public class _5HouseRobber {
    public  static int f1(int i, int[] nums, int[] dp)
    {
        if(i<0) return 0;
        if(dp[i] != -1)
        {
             return dp[i];
        }
        return dp[i] =Math.max( nums[i] + f1(i-2,nums,dp),f1(i-1,nums,dp) );
    }

    public  static int f2(int n, int[] nums)
    {
        int[] dp = new int[n];

        dp[0] = nums[0];

        for(int i=1;i<n;i++)
        {
            if(i-2>=0)
            {
                dp[i] =Math.max( nums[i] + dp[i-2],dp[i-1]);
            }
            else
            {
                dp[i] =Math.max( nums[i] + 0,dp[i-1]);
            }
        }

        return dp[n-1];
    }

    public static void main(String[] args) {

        int n = 5;
        int[] nums = new int[]{2,7,9,3,1};
        int[] mm = new int[n];
        Arrays.fill(mm,-1);
        System.out.println(f1(n-1,nums,mm));
        System.out.println(f2(n,nums));
    }
}
