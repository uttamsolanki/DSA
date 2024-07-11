package com.DailyRandom;

public class MinimumNoofDaysToMakeBouquets {


    public static int minDays(int[] bloomDay, int m, int k) {

        int max = Integer.MIN_VALUE;

        int n  =  bloomDay.length;
        for(int i=0;i<n;i++)
        {
            max = Math.max(max,bloomDay[i]);
        }

        int start = 0;
        int end = max;
        int ans = -1;
        while (start<=end)
        {
            int day = (start+end)/2;


            int count =0;
            int noOfB =0;
            for(int i=0;i<bloomDay.length;i++)
            {
                if(bloomDay[i]<=day)
                {
                    count++;
                }else
                {
                    count =0;
                }

                if(count==k)
                {
                    noOfB++;
                    count=0;
                }
            }


            if(noOfB>=m)
            {
                ans = day;
                end = day-1;
            }
            else
            {
                start = day+1;
            }

        }

        System.out.println(ans);
        return ans;
    }


    public static void main(String[] args) {
        int[] bloomDay =  new int[]{7,7,7,7,12,7,7};
        minDays(bloomDay,2,3);
    }
}
