package com.DailyRandom;

public class MaxMonthsPnL {
    static int  min = Integer.MAX_VALUE;
    static int ans =0;
    public static void solve1(int[] PnL,int i, int sum,int neg)
    {
        if(i>=PnL.length)
        {
            if(sum>0 && sum<min)
            {
                min = sum;
                ans = neg;
            }
            return ;
        }
        solve1(PnL,i+1,sum-PnL[i],neg+1);
        solve1(PnL,i+1,sum+PnL[i],neg);
    }

    private static int solve(int[] arr, int ind, long sum) {
        if(ind>=arr.length) {
            if(sum > 0) {
                return 0;
            } else {
                return -1*arr.length;
            }
        }
        return Math.max(solve(arr, ind+1, sum+arr[ind]), 1 + solve(arr, ind+1, sum-arr[ind]));
    }


    public static void main(String[] args) {
        int[] arr = new int[]{5,2,3,5,2,3};
       ans= solve(arr,0,0);
        System.out.println(ans);
    }
}
