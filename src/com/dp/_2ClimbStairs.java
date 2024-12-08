package com.dp;

import java.util.Arrays;

public class _2ClimbStairs {


    public static int f2(int n, int[] mm)
    {
        if(n==1 || n==0)
        {
            return mm[n]=1;
        }
        if(mm[n] != -1)
        {
            return mm[n];
        }
        return mm[n] = f2(n-1,mm) + f2(n-2,mm);
    }

    public static int f3(int n)
    {
        int[] dp = new int[n+1];
        //Base Condition
        dp[0]=dp[1]=1;
        for(int i=2;i<=n;i++)
        {
            dp[i] =  dp[i-1] + dp[i-2];
        }

        return dp[n];
    }

    public static void main(String[] args) {

        int n=2;
        int[] mm = new int[n+1];
        Arrays.fill(mm,-1);

        System.out.println(f2(2,mm));
    }
}
