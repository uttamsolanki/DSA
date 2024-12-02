package com.bitmanipulate;

import java.util.Arrays;

public class SingleNumberII {
    // This Approach is better than approach 2 in worst case
    // TC: (nlogn + n) = O(nlogn) this is not equal to 32*n becuase logn is less than 32
    public static int approach1(int[] arr) {

        Arrays.sort(arr);

        for(int i=1;i<arr.length;i+=3)
        {
            if(arr[i] != arr[i-1])
            {
                return arr[i-1];
            }
        }

        return arr[arr.length - 1];
    }

    // TC: O(33 * n)
    public static int approach2(int[] arr) {
        int ans = 0;
        for(int bit=0;bit<32;bit++)
        {
            int cntSetBit = 0;
            for(int i=0;i<arr.length;i++)
            {
                int mask = 1<<bit;
                if((arr[i] & mask)!=0)
                {
                    cntSetBit++;
                }
            }

            if((cntSetBit % 3)==1)
            {
                ans =  ans | 1<<bit;
            }
        }

        return ans;
    }

    // This is not intuitive
    // ones and twos methos
    // ones : it will keep one time occurred value
    // twos : it will keep two time occurred value
    // Third occurred value will be rejected by both
    // TC: O(n)
    public static  int Approach3(int[] arr)
    {
        int ones =0;
        int twos =0;

        for(int i=0;i<arr.length;i++)
        {
            ones = (ones ^ arr[i]) & (~twos);
            twos = (twos ^ arr[i]) & (~ones);
        }
        return ones;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{0,1,0,1,0,1,99};

        int ans = Approach3(arr);
        System.out.println(ans);
    }
}
