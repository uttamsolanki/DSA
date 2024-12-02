package com.bitmanipulate;

public class BitwiseANDofRange {
    public static int approach1(int left,int right) {

        if((left^right) ==0) return left;

        int nLeft = (int)(Math.log(left)/Math.log(2));
        int nRight = (int)(Math.log(right)/Math.log(2));

        if(nLeft==nRight)
        {

            int n = left^right;
            int bitN =  (int)(Math.log(n)/Math.log(2)) + 1;
            int mask = n | ((1<<(bitN-1)) - 1);

            return (~mask & (left & right));
        }
        return 0;
    }

    // Make right shift until number is equal
    // Count how many right shift we have made
    // Then append that right shift as a left shift
    public  static int approach2(int left, int right)
    {
        int cnt = 0;
        while (left!=right)
        {
            left>>=1;
            right>>=1;
            cnt++;
        }
        return left<<cnt;
    }

    public static void main(String[] args) {
        int left = 9, right =13;
        int ans = approach2(left,right);
        System.out.println(ans);
    }
}
