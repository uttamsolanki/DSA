package com.basics;

public class Maths {


    public static boolean isPrime(int num)
    {
        //Approach - 1
//        for(int i=2;i<num;i++)
//        {
//            if(num%i==0)
//            {
//                return true;
//            }
//        }
//        return false;

        //Approach - 2
        for(int i=2;i<=Math.sqrt(num);i++)
        {
            if(num%i==0)
            {
                return false;
            }
        }
        return true;
    }
    public static void allDivisors(int num)
    {
        //Approach - 1
        for(int i=1;i<=num;i++)
        {
            if(num%i==0)
            {
                System.out.print(i+" ");
            }
        }
        System.out.println();
        //Approach - 2
        for(int i=1;i<=Math.sqrt(num);i++)
        {
            if(num%i==0)
            {
                System.out.print(i+" ");

                if(i*i != num)
                {
                    System.out.print(num/i+" ");
                }
            }
        }
    }
    public static void armstrongNumbers(int num)
    {
        int n = num;


        //count digit
        int cnt = (int)(Math.log10(num)+1);

        int sum = 0;
        while(n>0)
        {
            sum = sum + (int)Math.pow(n%10,cnt);
            n/=10;
        }

        System.out.println(num==sum);
    }
    public static int GCDEuclideanTheorem(int a, int b)
    {

        if(b==0) return a;

        return GCDEuclideanTheorem(b,a%b);
    }
    public static void GCD(int a, int b)
    {
        //Approach - 1
        int ans = 0;

        for(int i=1;i<Math.min(a,b);i++)
        {
            if(a%i==0 && b%i==0)
            {
                ans = i;
            }
        }
        System.out.println(ans);

        //Approach - 2
        System.out.println(GCDEuclideanTheorem(a,b));
    }
    public static  void palindrome(int num)
    {
        int n = num;

        int rev = 0;

        while (n>0)
        {
            rev = rev*10 + (n%10);
            n/=10;
        }
        System.out.println(rev);
        System.out.println(rev==num);

    }
    public static void reverseNumber(int num)
    {
        int n = num;
        int rev = 0;
        while (n>0)
        {
            rev= rev*10 + (n % 10);
            n /= 10;
        }
        System.out.println(rev);

    }
    public static void countDigits(int num)
    {
        int cnt = 0;
        int n =num;
        while(n>0)
        {
            cnt++;
            n =n/10;
        }
        System.out.println(cnt);

        // Second Approach
        System.out.println(Math.floor(Math.log10(num)+1));
    }
    public static void main(String[] args) {
        //countDigits(12345);
        //reverseNumber(12345);
        //palindrome(121);
        //GCD(15,11);
        //armstrongNumbers(153);
        //allDivisors(36);
        System.out.println(isPrime(8));
    }
}
