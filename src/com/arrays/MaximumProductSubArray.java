package com.arrays;

import java.util.Map;

public class MaximumProductSubArray {

    public static int Approach1(int[] arr)
    {
        int maxProduct = 1;

        for(int i=0;i<arr.length;i++)
        {
            int prod = 1;
            for(int j=i;j<arr.length;j++)
            {
                prod *=arr[j];
                maxProduct = Math.max(maxProduct,prod);
            }
        }
        return maxProduct;
    }

    public static int Approach2(int[] arr)
    {
        int maxProduct = Integer.MIN_VALUE;
        int suffix = 1;
        int prefix = 1;

        int n = arr.length;
        for(int i=0;i<n;i++)
        {
            if(prefix==0)
            {
                prefix = 1;
            }

            if(suffix == 0)
            {
                suffix = 1;
            }
            prefix*=(double)arr[i];
            suffix*=(double)arr[n-i-1];

            maxProduct = (int) Math.max(maxProduct,Math.max(prefix,suffix));
        }
        return maxProduct;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,0};

        int ans = Approach2(arr);

        System.out.println(ans);
    }
}
