package com.maths;

public class IsPrime {

    public static  boolean isPrime(int n)
    {
        for(int i=2;i*i<=n;i++)
        {
            if(n%i==0)
            {
                return false;
            }
        }
        return true;
    }
    public static void approach1(int n) {

        for(int i=2;i<=n;i++)
        {
            if(isPrime(i))
            {
                System.out.println(i);
            }
        }

    }

    public static void approach2(int n) {
        boolean[] isPrime =  new boolean[n+1];

        isPrime[2] = true;

        for(int i=3;i<=n;i++)
        {
            isPrime[i]=true;
        }
        for(int i=2;i*i<=n;i++)
        {
            if(isPrime(i))
            {
                for(int j=2;i*j<=n;j++)
                {
                    isPrime[i*j]=true;
                }
            }
        }

        for(int i=2;i<=n;i++)
        {
            if(isPrime(i))
            {
                System.out.println(i);
            }
        }

    }

    public static void main(String[] args) {
        approach2(10000000);
    }
}
