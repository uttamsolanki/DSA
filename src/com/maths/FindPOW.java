package com.maths;

public class FindPOW {
    public static double myPow(double x, int n) {
        long nn = n;

        if(n<0)
        {
            nn = nn*(-1);
        }

        double r = 1;
        while(nn>0)
        {
            if(nn%2==1)
            {
                r = r * x;
            }

            x*=x;
            nn/=2;
        }
        if(n<0)
        {
            return 1/r;
        }
        return r;
    }
    public static void main(String[] args) {
        double ans = myPow(2.00000, -2147483648);
        System.out.println(ans);
    }
}
