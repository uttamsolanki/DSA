/**
 * Problems: LC - 1922 : Count Good Numbers
 */
package com.recursion;

public class CountGoodNumber {

    // Using Binary Exponentiation
    public static long pow(long x,long n, long m)
    {
        if(n==0) return 1;

        if(n%2==1)
        {
            return (x*pow((x*x) % m, (n-1)/2,m)) % m;
        }
        else
        {
            return pow((x*x) % m, n/2,m);
        }

    }
    public static int countGoodNumbers(long n) {
        long mod = 1000000007;
        // On even position total even number would be 5 [0,2,4,6,8]
        // On odd position total primer number would be 4 [2,3,5,7]

        long ans = pow(4, n/2, mod) % mod;
        ans = ans * pow(5, (n+1)/2, mod) % mod;
        return (int)ans;
    }
    // TC: log(n)

    public static void main(String[] args) {
        int ans = countGoodNumbers(4);
        System.out.println(ans);
    }
}

/**
 * Notes:
 * I have face problem regarding binary exponentiation and second related to number conversation
 */
