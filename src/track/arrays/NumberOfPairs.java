package track.arrays;

import java.util.Arrays;

/**
 * Problem: Given two positive integer arrays arr and brr, find the number of pairs such that xy > yx (raised to power of)
 * where x is an element from arr and y is an element from brr.
 * Link: https://www.geeksforgeeks.org/problems/number-of-pairs-1587115620/1
 */
public class NumberOfPairs {
    public static long countPairs(int x[], int y[], int M, int N) {
        // code here
        long cnt = 0;
        Arrays.sort(x);
        Arrays.sort(y);
        for(int i=0;i<M;i++)
        {
            for(int j=0;j<N;j++)
            {
                int X = x[i];
                int Y = y[j];

                if(Math.pow(X,Y) > Math.pow(Y,X) )
                {
                    System.out.println(X+"---"+Y);
                    cnt++;
                }
            }
        }
        return cnt;
    }



    public static void main(String[] args) {
        //2 7 9
        //6 8 7
       int[] x = new int[]{2, 1, 6};
       int[] y = new int[]{1, 5};
       long ans = countPairs(x,y,x.length,y.length);
        System.out.println(ans);
    }
}
