package com.DailyRandom;

public class ArmstrongNumber {
    static String armstrongNumber(int n){
        // code here
        int sum =0;

        int digit = n;
        while(digit>0)
        {
            int rep =  digit % 10;
            sum += (int)Math.pow(rep,3);
            digit/=10;
        }

        if(sum==n)
        {
            return "Yes";
        }
        return "No";

    }
    public static void main(String[] args) {
        System.out.println(armstrongNumber(153));
    }
}
