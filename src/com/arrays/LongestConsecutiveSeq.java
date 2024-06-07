package com.arrays;

import java.util.Arrays;
import java.util.HashSet;

public class LongestConsecutiveSeq {



    public static boolean linearSearch(int index,int val,int[] nums)
    {
        for(int i=index;i<nums.length;i++)
        {
            if(nums[i]==val)
            {
                return true;
            }
        }
        return false;
    }
    //Search all consecutive values for each element if the array
    public static void solution1(int[] nums)
    {
        int n=nums.length;
        int ans = Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            int x =  nums[i];
            int cnt = 1;
            while (linearSearch(i,x+1,nums))
            {
                cnt++;
                x++;
            }

            ans = Math.max(ans,cnt);
        }

        System.out.println(ans);

    }

    //Using sorting
    public static void solution2(int[] nums)
    {

        HashSet<Integer> set= new HashSet<>();

        int n=nums.length;
        int ans = 0;
        int cnt = 1;


        for(int i=0;i<n;i++)
        {
            set.add(nums[i]);
        }


        for(int num:set)
        {
            // This will be starting point. So it will not item again
            if(!set.contains(num-1))
            {
                int x = num;
                cnt = 1;
                while (set.contains(x+1))
                {
                    cnt++;
                    x++;
                }
            }

            ans = Math.max(ans,cnt);
        }
        System.out.println(ans);
    }

    //Using hashSet
    public static void solution3(int[] nums)
    {
        HashSet<Integer> set= new HashSet<>();

        int n=nums.length;
        int ans = 0;

        for(int i=0;i<n;i++)
        {
            set.add(nums[i]);
        }

        for(int i=0;i<n;i++)
        {
            int x =  nums[i];
            int cnt = 1;
            while (set.contains(x+1))
            {
                set.remove(x+1);
                cnt++;
                x++;
            }

            ans = Math.max(ans,cnt);
        }
        System.out.println(ans);

    }
    public static void main(String[] args) {
            int[] nums = new int[]{3, 8, 5, 7, 6};
            solution3(nums);
    }
}
