package com.DailyRandom;

public class BurstBalloons {
    public static int solve(int i,int j,int[] arr,int[][] dp)
    {
        if(i>j)
        {
            return 0;
        }
        if(dp[i][j]!=0)
        {
            return dp[i][j];
        }

        int ans = Integer.MIN_VALUE;
        for(int k=i;k<=j;k++)
        {
            int cost = arr[i-1] * arr[k] * arr[j+1];
            ans = Math.max(ans,(solve(i,k-1,arr,dp)+solve(k+1,j,arr,dp)) + cost );
        }
        return dp[i][j]=ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{
                3,1,5,8
        };

        int n = nums.length;
        int[] arr = new int[n+2];

        for(int i=0;i<n;i++)
        {
            arr[i+1] = nums[i];
        }
        arr[0] = 1;
        arr[arr.length-1] = 1;

        int[][] dp = new int[arr.length][arr.length];
        int ans = solve(1,n,arr,dp);
        System.out.println(ans);
    }
}
