package com.DailyRandom;

import java.util.Arrays;

public class MinIncreamenttoMakeUnique {
    public static int solution1(int[] arr)
    {
        Arrays.sort(arr);

        int ans =0;
        for(int i=1;i<arr.length;i++)
        {
            if(arr[i-1]>=arr[i])
            {
                int diff = arr[i-1] - arr[i];
                arr[i] = arr[i]+diff+1;
                ans+=diff+1;
            }
        }
        return ans;
    }

    public static int solution2(int[] arr)
    {

        int max =  Arrays.stream(arr).max().getAsInt();

        int n = arr.length;
        int[] count =  new int[max+n]; // not max but all number would be unique so last would be max value

        for(int i=0;i<arr.length;i++)
        {
            count[arr[i]]++;
        }

        int ans = 0;
        for(int i=0;i<count.length;i++)
        {
            if(count[i]<=1) continue;

            int diff = count[i]-1;
            count[i+1] += diff;
            ans += diff;
        }

        System.out.println(Arrays.toString(count));
        return ans;

    }
    public static void main(String[] args) {
        int[] arr = new int[]{
                1,2,2
        };

        int ans = solution2(arr);
        System.out.println(ans);
    }
}
