package com.binarySearch;

public class NthRoot {


    public static int func(int b, int exp)
    {
        int ans = 1;
        int base = b;

        while (exp > 0)
        {
            if(exp % 2 ==1)
            {
                ans=ans*base;
                exp--;
            }else
            {
                exp/=2;
                base*=base;
            }
        }
        return ans;
    }
    //Using power exponent method
    public static int solve2(int n, int m)
    {

        int low = 1;
        int high = m;
        while (low<=high)
        {
            int mid = low + (high - low)/2;
            int value = func(mid,n);
            if(value==m)
            {
                return  mid;
            }
            else if(value<m)
            {
                low =  mid + 1;
            }
            else
            {
                high =  mid - 1;
            }
        }


        return -1;
    }

    public static int solve(int n, int m)
    {

        int low = 1;
        int high = m;
        while (low<=high)
        {
            int mid = low + (high - low)/2;
            if(Math.pow(mid,n)==m)
            {
                return  mid;
            }
            else if(Math.pow(mid,n)<m)
            {
                low =  mid + 1;
            }
            else
            {
                high =  mid - 1;
            }
        }


        return -1;
    }
    public static void main(String[] args) {
        int ans = solve2(3,27);
        System.out.println(ans);
    }
}
