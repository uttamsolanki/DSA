package com.dp;

import java.util.Arrays;

public class _6HouseRobberTwo {
    // Tabulation
    // TC: N
    // SC: N
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

    // Space Optimization
    // TC: N
    // SC: 1
    public  static int f3(int n, int[] nums)
    {
        int prev1 = nums[0];
        int prev2 = 0;

        for(int i=1;i<n;i++)
        {
            int curr =Math.max( nums[i] + prev2,prev1);
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }

    public static void main(String[] args) {


        int[] nums = new int[]{1,2,3,1};
        int n = nums.length;

        int ans =  Math.max( f3(n-1,Arrays.copyOfRange(nums,1,n)), f3(n-1,Arrays.copyOfRange(nums,0,n-1)) );
        System.out.println(ans);
    }
}
