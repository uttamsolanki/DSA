package com.dp;
import java.util.Arrays;

/*
* Problem: Find fibonacci number for given n
* */
public class _1Fibonacci {


    // Memoization:
    // TC: 2^N
    // SC: N + N ( Stack Complexity )
    public static int  f1(int n,int[] mm)
    {
        if(n==0 || n==1) return mm[n]=n;

        if(mm[n]!=-1)
        {
            return  mm[n];
        }

        return mm[n]=f1(n-1,mm) + f1(n-2,mm);
    }

    // Tabulation:
    // TC: N
    // SC: N
    public static  int f2(int n)
    {
     int[] dp= new int[n+1];

     dp[0]=0;
     dp[1]=1;

     for(int i=2;i<=n;i++)
     {
         dp[i] =  dp[i-1]+dp[i-2];
     }

     return dp[n];
    }

    // Space optimization
    // TC: N
    // SC: 1
    public static  int f3(int n)
    {
        int prev2 = 0;
        int prev1 = 1;

        for(int i=2;i<=n;i++)
        {
            int temp = prev1;

            prev1 = prev1 + prev2;

            prev2 = temp;
        }
        return prev1;
    }
    public static void main(String[] args) {
        int n = 20;
        int[] mm =  new int[n+1];
        Arrays.fill(mm,-1);

        System.out.println("Memoization: "+f1(n,mm));
        System.out.println("Tabulation: "+f2(n));
        System.out.println("Tabulation with space optimization: "+f3(n));

    }
}
