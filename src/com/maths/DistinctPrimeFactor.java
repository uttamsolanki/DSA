package com.maths;

import java.util.HashSet;

public class DistinctPrimeFactor {

    public static void primeFactorization(int n, HashSet<Integer> set)
    {
        for(int i=2;i*i<=n;i++)
        {
            boolean isFactor = false;
            while (n%i==0)
            {
                isFactor = true;
                n/=i;
            }

            if(isFactor)
            {
                if(!set.contains(i))
                {
                    set.add(i);
                }
            }
        }

        if(n>1)
        {
            if(!set.contains(n))
            {
                set.add(n);
            }
        }
    }


    public static int approach1(int[] nums) {

        HashSet<Integer> set =  new HashSet<>();

        for(int i=0;i<nums.length;i++)
        {
            primeFactorization(nums[i],set);
        }

        return set.size();
    }

    public static void main(String[] args) {
        int[] arr = new int[]{
                2,4,3,7,10,6
        };
        int ans = approach1(arr);
        System.out.println(ans);
    }
}
