package com.maths;

public class PrimeArrangements {

    public static  boolean isPrime(int n)
    {
        if(n<=1)
        {
            return false;
        }
        if(n%2==0 && n!=2)
        {
            return false;
        }

        if(n%7==0 && n!=7)
        {
            return false;
        }

        if(n%13==0 && n!=13)
        {
            return false;
        }

        if(n%17==0 && n!=17)
        {
            return false;
        }

        for(int i=3;i*i<=n;i++)
        {
            if(n%i==0)
            {
                return false;
            }
        }
        return true;
    }

    public static long factorial(int n)
    {   long mod = (long)(1e9 +7) ;
        long f =1;
        for(int i=1;i<=n;i++)
        {
           f = (f * i)%mod;
        }
        return  f;
    }

    public static int approach1(int n) {
        System.out.println(factorial(12));
        int cntPrime = 0;
        for(int i=1;i<=n;i++)
        {
            if(isPrime(i))
            {
                cntPrime++;
            }
        }

        int nonPrime =  n - cntPrime;

        long mod = (long)(1e9 +7) ;
        long ans =  (factorial(cntPrime) * factorial(nonPrime)) % mod;
        return (int) ans;
    }

    public static void main(String[] args) {
        int ans = approach1(100);
        System.out.println(ans);
    }
}
