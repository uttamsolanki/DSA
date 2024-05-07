package com.basics;

public class Patterns {




    public static void patter2()
    {
        int n =5;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<=i;j++)
            {
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println();

        for(int i=0;i<n;i++)
        {
            for(int j=i;j<n;j++)
            {
                System.out.print("*");
            }
            System.out.println();
        }

    }

    public static void patter3()
    {
        int n =5;
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=i;j++)
            {
                System.out.print(j);
            }
            System.out.println();
        }

        System.out.println();

        for(int i=0;i<=n;i++)
        {
            for(int j=1;j<=n-i;j++)
            {
                System.out.print(j);
            }
            System.out.println();
        }

    }
    public static void patter4()
    {
        int n =5;
        for(int i=1;i<=n;i++)
        {
            for(int j=0;j<i;j++)
            {
                System.out.print(i);
            }
            System.out.println();
        }

    }

    public static void pattern5(){

        int n = 5;

        for(int i=0;i<n;i++)
        {
            for(int j=1;j<n-i;j++)
            {
                System.out.print(" ");
            }
           // System.out.println(j);
            for(int j=n-i;j<=n+i;j++)
            {
                System.out.print("*");
            }

            for(int j=n+i;j<2*n-1;j++)
            {
                System.out.print(" ");
            }

            System.out.println();
        }
        for(int i=n-1;i>=0;i--)
        {
            for(int j=1;j<n-i;j++)
            {
                System.out.print(" ");
            }
            // System.out.println(j);
            for(int j=n-i;j<=n+i;j++)
            {
                System.out.print("*");
            }

            for(int j=n+i;j<2*n-1;j++)
            {
                System.out.print(" ");
            }

            System.out.println();
        }

    }

    public static void pattern6()
    {
        int n=5;

        for(int i=0;i<2*n;i++)
        {
            if(i<=n)
            {
                for(int j=0;j<i;j++)
                {
                    System.out.print("*");
                }
            }else
            {
                for(int j=0;j<2*n-i;j++)
                {
                    System.out.print("*");
                }
            }

            System.out.println();
        }


    }
    public static void pattern7()
    {
        int n=5;

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<=i;j++)
            {
                System.out.print(((i+j)%2)^1);
            }
            System.out.println();
        }
    }
    public static void pattern8()
    {
        int n=5;
        for(int i=1;i<n;i++)
        {
            for(int j=1;j<=i;j++)
            {
                System.out.print(j);
            }

            for(int j=i;j<2*n-2-i;j++)
            {
                System.out.print(" ");
            }

            for(int j=n-i;j<n;j++)
            {
                System.out.print(n-j);
            }
            System.out.println();

        }
    }
    public static void pattern9()
    {
        int n=5;
        int cnt =1;
        for(int i=1;i<=n;i++)
        {
            for(int j=0;j<i;j++)
            {
                System.out.print(cnt + " ");
                cnt++;
            }
            System.out.println();
        }
    }
    public static void pattern10(int n)
    {
        int ascii = (int) 'A';
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<=i;j++)
            {
                System.out.print((char)(ascii+j));
            }
            System.out.println();
        }
        System.out.println();
        for(int i=n-1;i>=0;i--)
        {
            for(int j=0;j<=i;j++)
            {
                System.out.print((char)(ascii+j));
            }
            System.out.println();
        }
        System.out.println();
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<=i;j++)
            {
                System.out.print((char)(ascii+i));
            }
            System.out.println();
        }
    }
    public static void pattern11(int n)
    {
        int ascii = (int) 'A';
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n-i-1;j++)
            {
                System.out.print(" ");
            }
            for(int j=0;j<=i;j++)
            {
                System.out.print((char)(ascii+ j));
            }

            for(int j=i-1;j>=0;j--)
            {
                System.out.print((char)(ascii+j));
            }
            for(int j=n+i;j<2*n-1;j++)
            {
                System.out.print(" ");
            }

            System.out.println();
        }
    }

    public static void pattern12(int n)
    {
        int ascii = (int) 'A';
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<=i;j++)
            {
                System.out.print((char) (ascii + (n-i-1+j)) + " ");
            }
            System.out.println();
        }
    }


    public static void pattern13(int n)
    {
        for(int i=0;i<2*n;i++)
        {
            if(i<n)
            {
                for(int j=0;j<n-i;j++)
                {
                    System.out.print("*");
                }
                for(int j=n-i;j<n+i;j++)
                {
                    System.out.print(" ");
                }
                for(int j=n+i;j<2*n;j++)
                {
                    System.out.print("*");
                }
            }
            else {
                for(int j=0;j<=i%n;j++)
                {
                    System.out.print("*");
                }
                for(int j=i%n+1;j<2*n-(i%n)-1;j++)
                {
                    System.out.print(" ");
                }
                for(int j=i%n;j>=0;j--)
                {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }

    public static void pattern14(int n)
    {

        for(int i=0;i<2*n;i++)
        {
            int j=0;
            if(i<n)
            {
                for(;j<=i;j++)
                {
                    System.out.print("*");
                }

                for(;j<2*n-i-1;j++)
                {
                    System.out.print(" ");
                }
                for (;j<2*n;j++)
                {
                    System.out.print("*");
                }
            }
            else {

                for (;j<n - (i%n)-1;j++)
                {
                    System.out.print("*");
                }

                for (;j<=n+(i%n);j++)
                {
                    System.out.print(" ");
                }

                for (;j<2*n;j++)
                {
                    System.out.print("*");
                }
            }


            System.out.println();
        }
    }

    public static void pattern15(int n)
    {
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(i==0 || j==0 || i==n-1 || j==n-1)
                {
                    System.out.print("*");
                }
                else
                {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void pattern16(int n)
    {

        for(int i=4;i>1;i--)
        {
            int j=0;
            for(;j<n-i;j++)
            {
                System.out.print(n-j+" ");
            }
            for(;j<n+i-1;j++)
            {
                System.out.print(i+" ");
            }
            for(;j<2*n-1;j++)
            {
                System.out.print(j-n+2+" ");
            }
            System.out.println();
        }

        for(int i=1;i<=n;i++)
        {
            int j=0;
            for(;j<n-i;j++)
            {
                System.out.print(n-j+" ");
            }
            for(;j<n+i-1;j++)
            {
                System.out.print(i+" ");
            }
            for(;j<2*n-1;j++)
            {
                System.out.print(j-n+2+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        pattern16(4);
    }
}
