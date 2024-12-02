package com.maths;

public class PrimePalindrome {

    public static  boolean isPrime(int n)
    {
        if(n<=1) return false;
        for(int i=2;i*i<=n;i++)
        {
            if(n%i==0)
            {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindrome(int n)
    {
        if(n<9) return true;

        int temp =n;

        int rem = 0;
        while (n>0)
        {
            rem = rem * 10 + (n%10);
            n/=10;
            // all even number of palindrome are not prime
            if (n > 10_000_000 && n < 100_000_000) {
                n = 100_000_000;
            }
        }
        return temp==rem;

    }

    public static int approach1(int n) {

        while (n<2 * 1e9)
        {
            if(isPalindrome(n) && isPrime(n))
            {
                return n;
            }
            n++;
        }
        return 0;
    }

    public static void main(String[] args) {
        int ans = approach1(1);
        System.out.println(ans);
    }
}
