package com.arrays;

import java.util.HashMap;
import java.util.Map;

public class FindRepeatAndMissingNumber {

    // Using count
    public static void Approach1(int[] arr)
    {
        int n =  arr.length;
        int missing = -1;
        int repeat = -1;
        for(int i=1;i<=n;i++)
        {
            int cnt = 0;
            for(int j=0;j<n;j++)
            {
                if(arr[j]==i) cnt++;
            }

            if(cnt>1)
            {
                repeat = i;
            }else if(cnt==0)
            {
                missing = i;
            }

            if(repeat!=-1 && missing != -1)
            {
                break;
            }
        }

        System.out.println(repeat);
        System.out.println(missing);
    }

    // Using Hashing
    public static void Approach2(int[] arr)
    {
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<arr.length;i++)
        {
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        int missing = -1;
        int repeat = -1;

        for(int i=1;i<=arr.length;i++)
        {
            int value =  map.getOrDefault(i,0);
            if(value==0)
            {
                missing = i;
            }else if(value>1)
            {
                repeat = i;
            }
        }

        System.out.println(repeat);
        System.out.println(missing);
    }

    //Using Maths
    public static void Approach3(int[] arr)
    {
        long n =  arr.length;
        long sn = (n*(n+1))/2;
        long s2n = (n*(n+1)*(2*n+1))/6;

        long s = 0;
        long s2 = 0;
        for(int i=0;i<n;i++)
        {
            s += arr[i];
            s2 += (arr[i]*arr[i]);
        }

        // x - y = val1
        long val1 = s-sn;

        // x^2 - y^2 = val2
        long val2 = s2 - s2n;

        //(x-y)(x+y) = val2

        val2 = val2/val1;

        long x = (val1 + val2)/2;

        long y = val2 - x;

        System.out.println(x);
        System.out.println(y);



    }
    public static void main(String[] args) {
        int[] arr =  new int[]{3,1,2,5,3};
        Approach3(arr);
    }
}
