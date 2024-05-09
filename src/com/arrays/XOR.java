package com.arrays;

public class XOR {
    public static void main(String[] args) {
        int[] arr = new int[]{4, 1, 2, 1, 2};

        int xor1 =0;

        for(int i=0;i<arr.length;i++)
        {
            xor1 = xor1 ^ arr[i];
            System.out.println(xor1);
        }

        System.out.println(xor1 );
    }
}
