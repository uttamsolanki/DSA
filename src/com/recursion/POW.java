/**
 * Problem: LC-50: Implement pow(x, n), which calculates x raised to the power n (i.e., xn).
 */
package com.recursion;

public class POW {

    // Use binary exponentiation formula to multiply base and divide power
    public static double myPowRec(double x, long n, double r)
    {
        if(n==0)
        {
            return r;
        }
        if(n%2==1)
        {
            r= r*x;
        }
        return myPowRec(x*x,n/2,r);
    }
    //TC: log(n);
    public static double myPow(double x, long n) {

        if(n<0)
        {
            return 1/myPowRec(x,n*-1,1);
        }
        else
        {
            return myPowRec(x,n,1);
        }
    }

    public static void main(String[] args) {
        double ans = myPow(2.00000,-2147483648);
        System.out.println(ans);
    }
}
