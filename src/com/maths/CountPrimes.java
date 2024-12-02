package com.maths;

public class CountPrimes {
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
    public static int approach1(int n) {

        boolean[] arr = new boolean[n+1];

        for(int i=0;i<=n;i++)
        {
            arr[i] = true;
        }

        for(int i=2;i*i<=n;i++)
        {
            if(isPrime(i))
            {
               for(int j=2;j*i<=n;j++)
               {
                   arr[i*j] = false;
               }
            }
        }

        int cnt = 0;

        for(int i = 2; i<n;i++)
        {
            if(arr[i]==true)
            {
                cnt++;
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        int ans = approach1(5000000);
        System.out.println(ans);
    }
}
