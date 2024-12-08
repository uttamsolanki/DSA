package com.dp;

public class _4KJumpFrog {

    //Memoization
    //SC: N + N (Stack)
    //TC: N*K
    public  static int f1(int[] h,int k,int n,int[] dp)
    {
        if(n<0) return Integer.MAX_VALUE;
        if(n==0) return dp[n]=0;

        if(dp[n] != -1) return dp[n];

        int min = Integer.MAX_VALUE;

        for(int jump=1;jump<=k;jump++)
        {
            if(n-jump>=0)
            {
                min =  Math.min(min, Math.abs(h[n] - h[n-jump]) + f1(h,k,n-jump,dp) );
            }
        }
        return dp[n]=min;
    }

    // Tabulation
    // TC: N*K
    // SC: N
    public static  int f2(int[] h,int k,int n)
    {
        int[] dp =  new int[n];

        dp[0] = 0;
        for(int i=1;i<n;i++)
        {
            int min = Integer.MAX_VALUE;
            for(int j=1;j<=k;j++)
            {
                if(i-j>=0)
                {
                    min =  Math.min(min, Math.abs(h[i] - h[i-j]) + dp[i-j] );
                }
            }
            dp[i] = min;
        }
        return dp[n-1];
    }

    public static void main(String[] args) {
        int[] h = new int[]{40,10,20,70,80,10,20,70,80,60};
        int n =10;
        int[] mm = new int[n];
        for(int i=0;i<n;i++)
        {
            mm[i]=-1;
        }
        System.out.println(f1(h,4,n-1,mm));

        System.out.println(f2(h,4,n));
    }
}
