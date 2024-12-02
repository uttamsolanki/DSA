package com.arrays.GG;

public class MaximumSubSeqOFKdistance {

    public static int approach1(int[] arr,int k) {
        int ans = 0;
        for(int i=0;i<arr.length;i++)
        {
            int sum = 0;
            for(int j=i;j<arr.length;j=j+k)
            {
                sum += arr[j];
            }
            ans = Math.max(ans,sum);
        }
        return ans;
    }


    public static int approach2(int[] arr,int k) {
        int ans = 0;
        for(int i=k;i<arr.length;i++)
        {
            for(int j=i-k;j>=i-k;j++)
            {
                arr[i] = Math.max(arr[i],arr[i]+arr[j]);
                ans = Math.max(arr[i],ans);
            }

        }
        return ans;
    }




    public static void main(String[] args) {
        int[] arr  = new int[] {2, -3, -1, -1, 2};
        int k = 2;
        int ans = approach2(arr,k);
        System.out.println(ans);
    }
}
